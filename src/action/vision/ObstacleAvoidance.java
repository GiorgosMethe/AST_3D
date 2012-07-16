package action.vision;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.DangerousObject;
import perceptor.localization.Landmark;
import perceptor.localization.LocalizationFilter;
import perceptor.localization.TriangleLocalization;

public class ObstacleAvoidance {

	public static Vector<Coordinate> Alternatives = new Vector<Coordinate>();
	public static Coordinate BestAlternative;

	/*
	 * This method is responsible for assign alternative routes to the agent if
	 * an obstacle closes his way to the target position. It is called every
	 * time the Obstacle perceptor is ready to give results from the scanning.
	 * Here it is checked if an obstacle block our route to the target position.
	 * If it does, we calculate possible way out coordinates in the field,
	 * considering all the possible obstacles, not only the obstacle which
	 * blocked our way.
	 */

	public static Coordinate CheckForObstacle(Coordinate Target,
			Vector<Landmark> obstacles2) {

		Coordinate MyPosition = new Coordinate(
				LocalizationFilter.MyFilteredPosition.getX(),
				LocalizationFilter.MyFilteredPosition.getY());

		double distance = TriangleLocalization.FindDistanceAmong2Coordinates(
				MyPosition, Target);
		double Angle = TriangleLocalization.FindAngleBetweenCoordinates(
				MyPosition, Target);

		final float DangerDist = (float) 0.6f;
		final Vector<DangerousObject> DangerousObjects = new Vector<DangerousObject>();

		for (int i = 0; i < obstacles2.size(); i++) {

			float theta = (float) Math.toDegrees(Math.asin(DangerDist
					/ obstacles2.elementAt(i).getDistance()));

			if (Double.isNaN(theta)) {
				theta = 100;
			}

			DangerousObject bt = new DangerousObject(
					(float) TriangleLocalization
							.NormalizeAngle((LocalizationFilter.MyFilteredPosition
									.getTheta()
									+ obstacles2.elementAt(i)
											.getHorizontal_Angle() - theta)),
					(float) TriangleLocalization
							.NormalizeAngle((LocalizationFilter.MyFilteredPosition
									.getTheta()
									+ obstacles2.elementAt(i)
											.getHorizontal_Angle() + theta)),
					(float) obstacles2.elementAt(i).getDistance());

			DangerousObjects.addElement(bt);
		}

		boolean InMyWay = false;
		for (int i = 0; i < DangerousObjects.size(); i++) {

			if (TriangleLocalization.CheckIfContained(DangerousObjects
					.elementAt(i).getThetaStart(), DangerousObjects
					.elementAt(i).getThetaEnd(), Angle)
					&& (DangerousObjects.elementAt(i).getDistance() < distance)) {
				InMyWay = true;

			}

		}

		if (InMyWay) {

			Vector<WayOut> WayOutAngles = WayOut(DangerousObjects);

			ObstacleAvoidance.Alternatives.removeAllElements();
			for (int i = 0; i < WayOutAngles.size(); i++) {

				Coordinate temp1 = TriangleLocalization
						.get_det_with_distance_angle(
								LocalizationFilter.MyFilteredPosition.getX(),
								LocalizationFilter.MyFilteredPosition.getY(),
								WayOutAngles.elementAt(i).getAngle(),
								WayOutAngles.elementAt(i).getDistance());

				ObstacleAvoidance.Alternatives.add(temp1);

			}
			double min = 1000;
			double cost = 0;
			int PosMin = 0;
			if (ObstacleAvoidance.Alternatives.size() == 0) {
				return null;
			}
			for (int i = 0; i < ObstacleAvoidance.Alternatives.size(); i++) {

				cost = TriangleLocalization.FindDistanceAmong2Coordinates(
						Target, ObstacleAvoidance.Alternatives.elementAt(i));
				cost += TriangleLocalization.FindDistanceAmong2Coordinates(
						LocalizationFilter.MyPosition,
						ObstacleAvoidance.Alternatives.elementAt(i));

				cost += Math.abs(Math.abs(LocalizationFilter.MyFilteredPosition
						.getTheta())
						- Math.abs(TriangleLocalization
								.FindAngleBetweenCoordinates(
										LocalizationFilter.MyPosition,
										ObstacleAvoidance.Alternatives
												.elementAt(i))));

				if (cost < min) {

					min = cost;
					PosMin = i;
				}

			}
			ObstacleAvoidance.BestAlternative = ObstacleAvoidance.Alternatives
					.elementAt(PosMin);
			ObstacleAvoidance.Alternatives.removeElementAt(PosMin);

			return ObstacleAvoidance.BestAlternative;

		} else {

			return null;
		}

	}

	public static Vector<WayOut> WayOut(Vector<DangerousObject> DangerousObjects) {

		Vector<WayOut> WayOutAngles = new Vector<WayOut>();

		// there is only one obstacle
		if (DangerousObjects.size() == 1) {

			WayOutAngles.add(new WayOut(
					DangerousObjects.elementAt(0).ThetaStart, DangerousObjects
							.elementAt(0).getDistance()));
			WayOutAngles.add(new WayOut(DangerousObjects.elementAt(0).ThetaEnd,
					DangerousObjects.elementAt(0).getDistance()));

			// there are more than one obstacles
		} else {
			for (int i = 0; i < DangerousObjects.size(); i++) {

				boolean flagStart = true;
				boolean flagEnd = true;

				for (int j = 0; j < DangerousObjects.size(); j++) {

					if (i != j) {

						if (TriangleLocalization.CheckIfContained(
								DangerousObjects.elementAt(j).getThetaStart(),
								DangerousObjects.elementAt(j).getThetaEnd(),
								DangerousObjects.elementAt(i).getThetaStart())) {

							flagStart = false;

						}

						if (TriangleLocalization.CheckIfContained(
								DangerousObjects.elementAt(j).getThetaStart(),
								DangerousObjects.elementAt(j).getThetaEnd(),
								DangerousObjects.elementAt(i).getThetaEnd())) {

							flagEnd = false;

						}

					}

				}

				if (flagEnd) {

					WayOutAngles.add(new WayOut(DangerousObjects.elementAt(i)
							.getThetaEnd(), DangerousObjects.elementAt(i)
							.getDistance()));

				}

				if (flagStart) {

					WayOutAngles.add(new WayOut(DangerousObjects.elementAt(i)
							.getThetaStart(), DangerousObjects.elementAt(i)
							.getDistance()));

				}
			}
		}

		return WayOutAngles;

	}

}