package coordination.strategy;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import agent.constraints.Constraints;

public class TeamFormationTest {

	/**
	 * @param args
	 * @throws Exception
	 */

	public static Coordinate[] NewCoordinates = new Coordinate[10];
	public static Coordinate Ball = new Coordinate(0, 0);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Ball = new Coordinate(10, 4);

		if (Ball.X > Constraints.FieldLength / 2) {
			Ball.setX(Constraints.FieldLength / 2);
		} else if (Ball.X < (-Constraints.FieldLength / 2)) {
			Ball.setX((-Constraints.FieldLength / 2));
		}

		if (Ball.Y > Constraints.FieldWidth / 2) {
			Ball.setY(Constraints.FieldWidth / 2);
		} else if (Ball.Y < (-Constraints.FieldWidth / 2)) {
			Ball.setY((-Constraints.FieldWidth / 2));
		}

		// Defence line

		float distance = (float) (4 + 2 * (Ball.X / (Constraints.FieldLength / 2)));

		double theta = TriangleLocalization.FindAngleBetweenCoordinates(
				Constraints.OwnGoal, Ball);

		if (theta > 55) {
			theta = 55;
		} else if (theta < -55) {
			theta = -55;
		}

		NewCoordinates[4] = TriangleLocalization.get_det_with_distance_angle(
				Constraints.OwnGoal.X, Constraints.OwnGoal.Y, theta,
				distance - 0.5);

		NewCoordinates[2] = TriangleLocalization.get_det_with_distance_angle(
				Constraints.OwnGoal.X, Constraints.OwnGoal.Y, theta + 30,
				distance);

		NewCoordinates[3] = TriangleLocalization.get_det_with_distance_angle(
				Constraints.OwnGoal.X, Constraints.OwnGoal.Y, theta - 30,
				distance);

		// Attacking positions for attack and defence

		if (Ball.X >= 0) {

			double theta1 = 0;
			float distance1 = (float) (3 - 2 * (SoccerFieldCoordinateValue
					.Calculate(Ball) / Constraints.MaxFieldSpotValue));
			float theta3 = 120;
			float theta4 = -120;
			NewCoordinates[9] = new Coordinate(Ball.X - 0.5, Ball.Y);

			NewCoordinates[7] = TriangleLocalization
					.get_det_with_distance_angle(NewCoordinates[9].X,
							NewCoordinates[9].Y, theta3, distance1);

			while (!ProperSupportPosition(NewCoordinates[7])) {

				distance1 = (float) (distance1 - 0.01);
				NewCoordinates[7] = TriangleLocalization
						.get_det_with_distance_angle(NewCoordinates[9].X,
								NewCoordinates[9].Y, ++theta3, distance1);

			}

			NewCoordinates[8] = TriangleLocalization
					.get_det_with_distance_angle(NewCoordinates[9].X,
							NewCoordinates[9].Y, theta4, distance1);

			while (!ProperSupportPosition(NewCoordinates[8])) {

				distance1 = (float) (distance1 - 0.01);

				NewCoordinates[8] = TriangleLocalization
						.get_det_with_distance_angle(NewCoordinates[9].X,
								NewCoordinates[9].Y, --theta4, distance1);

			}

			Coordinate midfielfCenter = new Coordinate(NewCoordinates[9].X - 4,
					NewCoordinates[9].Y);

			NewCoordinates[5] = TriangleLocalization
					.get_det_with_distance_angle(midfielfCenter.X,
							midfielfCenter.Y, -90, 1);

			NewCoordinates[6] = TriangleLocalization
					.get_det_with_distance_angle(midfielfCenter.X,
							midfielfCenter.Y, 90, 1);

			while ((!ProperSupportPosition(NewCoordinates[5]))
					|| (!ProperSupportPosition(NewCoordinates[6]))) {

				if (NewCoordinates[5].Y < 0 || NewCoordinates[6].Y < 0) {
					midfielfCenter.setY((midfielfCenter.getY() + 1));
				} else if (NewCoordinates[5].Y > 0 || NewCoordinates[6].Y > 0) {
					midfielfCenter.setY((midfielfCenter.getY() - 1));
				}

				NewCoordinates[5] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, -90, 1);

				NewCoordinates[6] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, 90, 1);

			}

		} else {

			double theta1 = 0;
			float distance1 = (float) (3 - 2 * (SoccerFieldCoordinateValue
					.Calculate(Ball) / Constraints.MaxFieldSpotValue));
			float x = (float) ((float) 6 * (Ball.X / Constraints.FieldLength / 2));
			float theta3 = 120;
			float theta4 = -120;
			NewCoordinates[9] = new Coordinate(x, Ball.Y);

			NewCoordinates[7] = TriangleLocalization
					.get_det_with_distance_angle(NewCoordinates[9].X,
							NewCoordinates[9].Y, theta3, distance1);

			while (!ProperSupportPosition(NewCoordinates[7])) {

				NewCoordinates[7] = TriangleLocalization
						.get_det_with_distance_angle(NewCoordinates[9].X,
								NewCoordinates[9].Y, ++theta3, distance1);

			}

			NewCoordinates[8] = TriangleLocalization
					.get_det_with_distance_angle(NewCoordinates[9].X,
							NewCoordinates[9].Y, theta4, distance1);

			while (!ProperSupportPosition(NewCoordinates[8])) {

				NewCoordinates[8] = TriangleLocalization
						.get_det_with_distance_angle(NewCoordinates[9].X,
								NewCoordinates[9].Y, --theta4, distance1);

			}

			if (TriangleLocalization.FindDistanceAmong2Coordinates(
					NewCoordinates[9], Ball) < TriangleLocalization
					.FindDistanceAmong2Coordinates(NewCoordinates[4], Ball)) {

				Coordinate midfielfCenter = new Coordinate(
						NewCoordinates[9].X - 4, NewCoordinates[9].Y);

				NewCoordinates[5] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, -90, 1);

				NewCoordinates[6] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, 90, 1);

				while ((!ProperSupportPosition(NewCoordinates[5]))
						|| (!ProperSupportPosition(NewCoordinates[6]))) {

					if (NewCoordinates[5].Y < 0 || NewCoordinates[6].Y < 0) {
						midfielfCenter.setY((midfielfCenter.getY() + 1));
					} else if (NewCoordinates[5].Y > 0
							|| NewCoordinates[6].Y > 0) {
						midfielfCenter.setY((midfielfCenter.getY() - 1));
					}

					NewCoordinates[5] = TriangleLocalization
							.get_det_with_distance_angle(midfielfCenter.X,
									midfielfCenter.Y, -90, 1);

					NewCoordinates[6] = TriangleLocalization
							.get_det_with_distance_angle(midfielfCenter.X,
									midfielfCenter.Y, 90, 1);

				}

			} else {

				Coordinate midfielfCenter = new Coordinate(
						NewCoordinates[4].X + 2,
						(NewCoordinates[4].Y * 0.4 + Ball.Y * 0.6));

				NewCoordinates[5] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, -90, 1);

				NewCoordinates[6] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, 90, 1);

				while ((!ProperSupportPosition(NewCoordinates[5]))
						|| (!ProperSupportPosition(NewCoordinates[6]))) {

					if (NewCoordinates[5].Y < 0 || NewCoordinates[6].Y < 0) {
						midfielfCenter.setY((midfielfCenter.getY() + 1));
					} else if (NewCoordinates[5].Y > 0
							|| NewCoordinates[6].Y > 0) {
						midfielfCenter.setY((midfielfCenter.getY() - 1));
					}

					NewCoordinates[5] = TriangleLocalization
							.get_det_with_distance_angle(midfielfCenter.X,
									midfielfCenter.Y, -90, 1);

					NewCoordinates[6] = TriangleLocalization
							.get_det_with_distance_angle(midfielfCenter.X,
									midfielfCenter.Y, 90, 1);

				}

			}

		}

	}

	public static boolean ProperSupportPosition(Coordinate spot) {

		if ((Math.abs(spot.X) < ((Constraints.FieldLength / 2) - 0.5))
				&& (Math.abs(spot.Y) < (Constraints.FieldWidth / 2) - 0.5)) {

			return true;

		}

		return false;

	}

}
