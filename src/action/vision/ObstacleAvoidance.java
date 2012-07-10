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

	public static Coordinate CheckForObstacle(Coordinate Target) {

		Coordinate MyPosition = new Coordinate(
				LocalizationFilter.MyFilteredPosition.getX(),
				LocalizationFilter.MyFilteredPosition.getY());

		double distance = TriangleLocalization.FindDistanceAmong2Coordinates(
				MyPosition, Target);
		double Angle = TriangleLocalization.FindAngleBetweenCoordinates(
				MyPosition, Target);

		Vector<Landmark> Obstacles = ObstaclePerceptor.Obstacles;

		final float DangerDist = (float) 0.6f;
		final Vector<DangerousObject> DangerousObjects = new Vector<DangerousObject>();

		// find every pair of angles which are dangerous for the agent
		for (int i = 0; i < Obstacles.size(); i++) {

			float theta = (float) Math.toDegrees(Math.asin(DangerDist
					/ Obstacles.elementAt(i).getDistance()));

			DangerousObject bt = new DangerousObject(
					(float) (LocalizationFilter.MyFilteredPosition.getTheta()
							+ Obstacles.elementAt(i).getHorizontal_Angle() - theta),
					(float) (LocalizationFilter.MyFilteredPosition.getTheta()
							+ Obstacles.elementAt(i).getHorizontal_Angle() + theta),
					(float) Obstacles.elementAt(i).getDistance());

			DangerousObjects.addElement(bt);
		}

		boolean InMyWay = false;
		// check if an obstacle block our route
		for (int i = 0; i < DangerousObjects.size(); i++) {

			// There is an obstacle in agent's way
			if ((Angle > DangerousObjects.elementAt(i).getThetaStart())
					&& (Angle < DangerousObjects.elementAt(i).getThetaEnd() && distance > DangerousObjects
							.elementAt(i).getDistance())) {

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
			int PosMin = 0;
			for (int i = 0; i < ObstacleAvoidance.Alternatives.size(); i++) {

				if (TriangleLocalization.FindDistanceAmong2Coordinates(Target,
						ObstacleAvoidance.Alternatives.elementAt(i)) < min) {

					min = TriangleLocalization
							.FindDistanceAmong2Coordinates(Target,
									ObstacleAvoidance.Alternatives.elementAt(i));
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
			WayOutAngles.add(new WayOut(
					DangerousObjects.elementAt(0).ThetaStart, DangerousObjects
							.elementAt(0).getDistance()));

			// there are more than one obstacles
		} else {
			for (int i = 0; i < DangerousObjects.size(); i++) {

				boolean flagStart = true;
				boolean flagEnd = true;
				for (int j = 0; j < DangerousObjects.size(); j++) {

					if (i != j) {

						if ((DangerousObjects.elementAt(i).ThetaStart > DangerousObjects
								.elementAt(j).ThetaStart)
								&& (DangerousObjects.elementAt(i).ThetaStart < DangerousObjects
										.elementAt(j).ThetaEnd)) {

							flagStart = false;

						}

						if ((DangerousObjects.elementAt(i).ThetaEnd > DangerousObjects
								.elementAt(j).ThetaStart)
								&& (DangerousObjects.elementAt(i).ThetaEnd < DangerousObjects
										.elementAt(j).ThetaEnd)) {

							flagEnd = false;

						}

					}

				}

				if (flagEnd) {

					WayOutAngles.add(new WayOut(
							DangerousObjects.elementAt(i).ThetaEnd,
							DangerousObjects.elementAt(i).getDistance()));

				}

				if (flagStart) {

					WayOutAngles.add(new WayOut(
							DangerousObjects.elementAt(i).ThetaStart,
							DangerousObjects.elementAt(i).getDistance()));

				}
			}
		}

		return WayOutAngles;

	}

}
