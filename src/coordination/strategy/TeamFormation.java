package coordination.strategy;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import agent.constraints.Constraints;

public class TeamFormation {

	public static Coordinate[] TeamFormation = new Coordinate[10];

	public static void Calculate(Coordinate Ball) {

		/*
		 * Check if Ball coordination is out of field
		 */

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

		/*
		 * defenders positioning
		 */

		float distance = (float) (4 + 2 * (Ball.X / (Constraints.FieldLength / 2)));

		double theta = TriangleLocalization.FindAngleBetweenCoordinates(
				Constraints.OwnGoal, Ball);

		if (theta > 55) {
			theta = 55;
		} else if (theta < -55) {
			theta = -55;
		}

		TeamFormation[4] = TriangleLocalization.get_det_with_distance_angle(
				Constraints.OwnGoal.X, Constraints.OwnGoal.Y, theta,
				distance - 0.5);

		TeamFormation[3] = TriangleLocalization.get_det_with_distance_angle(
				Constraints.OwnGoal.X, Constraints.OwnGoal.Y, theta + 30,
				distance);

		TeamFormation[2] = TriangleLocalization.get_det_with_distance_angle(
				Constraints.OwnGoal.X, Constraints.OwnGoal.Y, theta - 30,
				distance);

		/*
		 * attackers and midfielders positioning for attack
		 */

		if (Ball.X >= 0) {

			float distance1 = (float) (3 - 2 * (SoccerFieldCoordinateValue
					.Calculate(Ball) / Constraints.MaxFieldSpotValue));
			float theta3 = 120;
			float theta4 = -120;
			TeamFormation[9] = new Coordinate(Ball.X - 0.5, Ball.Y);

			TeamFormation[8] = TriangleLocalization
					.get_det_with_distance_angle(TeamFormation[9].X,
							TeamFormation[9].Y, theta3, distance1);

			while (!ProperSupportPosition(TeamFormation[8])) {

				distance1 = (float) (distance1 - 0.01);
				TeamFormation[8] = TriangleLocalization
						.get_det_with_distance_angle(TeamFormation[9].X,
								TeamFormation[9].Y, ++theta3, distance1);

			}

			TeamFormation[7] = TriangleLocalization
					.get_det_with_distance_angle(TeamFormation[9].X,
							TeamFormation[9].Y, theta4, distance1);

			while (!ProperSupportPosition(TeamFormation[7])) {

				distance1 = (float) (distance1 - 0.01);

				TeamFormation[7] = TriangleLocalization
						.get_det_with_distance_angle(TeamFormation[9].X,
								TeamFormation[9].Y, --theta4, distance1);

			}

			Coordinate midfielfCenter = new Coordinate(TeamFormation[9].X - 4,
					TeamFormation[9].Y);

			TeamFormation[5] = TriangleLocalization
					.get_det_with_distance_angle(midfielfCenter.X,
							midfielfCenter.Y, -90, 1);

			TeamFormation[6] = TriangleLocalization
					.get_det_with_distance_angle(midfielfCenter.X,
							midfielfCenter.Y, 90, 1);

			while ((!ProperSupportPosition(TeamFormation[5]))
					|| (!ProperSupportPosition(TeamFormation[6]))) {

				if (TeamFormation[5].Y < 0 || TeamFormation[6].Y < 0) {
					midfielfCenter.setY((midfielfCenter.getY() + 1));
				} else if (TeamFormation[5].Y > 0 || TeamFormation[6].Y > 0) {
					midfielfCenter.setY((midfielfCenter.getY() - 1));
				}

				TeamFormation[5] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, -90, 1);

				TeamFormation[6] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, 90, 1);

			}

			/*
			 * attackers and midfielders positioning for defence
			 */
		} else {

			double theta1 = 0;
			float distance1 = (float) (3 - 2 * (SoccerFieldCoordinateValue
					.Calculate(Ball) / Constraints.MaxFieldSpotValue));
			float x = (float) ((float) 6 * (Ball.X / Constraints.FieldLength / 2));
			float theta3 = 120;
			float theta4 = -120;
			TeamFormation[9] = new Coordinate(x, Ball.Y);

			TeamFormation[8] = TriangleLocalization
					.get_det_with_distance_angle(TeamFormation[9].X,
							TeamFormation[9].Y, theta3, distance1);

			while (!ProperSupportPosition(TeamFormation[8])) {

				TeamFormation[8] = TriangleLocalization
						.get_det_with_distance_angle(TeamFormation[9].X,
								TeamFormation[9].Y, ++theta3, distance1);

			}

			TeamFormation[7] = TriangleLocalization
					.get_det_with_distance_angle(TeamFormation[9].X,
							TeamFormation[9].Y, theta4, distance1);

			while (!ProperSupportPosition(TeamFormation[7])) {

				TeamFormation[7] = TriangleLocalization
						.get_det_with_distance_angle(TeamFormation[9].X,
								TeamFormation[9].Y, --theta4, distance1);

			}

			if (TriangleLocalization.FindDistanceAmong2Coordinates(
					TeamFormation[9], Ball) < TriangleLocalization
					.FindDistanceAmong2Coordinates(TeamFormation[4], Ball)) {

				Coordinate midfielfCenter = new Coordinate(
						TeamFormation[9].X - 4, TeamFormation[9].Y);

				TeamFormation[5] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, -90, 1);

				TeamFormation[6] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, 90, 1);

				while ((!ProperSupportPosition(TeamFormation[5]))
						|| (!ProperSupportPosition(TeamFormation[6]))) {

					if (TeamFormation[5].Y < 0 || TeamFormation[6].Y < 0) {
						midfielfCenter.setY((midfielfCenter.getY() + 1));
					} else if (TeamFormation[5].Y > 0 || TeamFormation[6].Y > 0) {
						midfielfCenter.setY((midfielfCenter.getY() - 1));
					}

					TeamFormation[5] = TriangleLocalization
							.get_det_with_distance_angle(midfielfCenter.X,
									midfielfCenter.Y, -90, 1);

					TeamFormation[6] = TriangleLocalization
							.get_det_with_distance_angle(midfielfCenter.X,
									midfielfCenter.Y, 90, 1);

				}

			} else {

				Coordinate midfielfCenter = new Coordinate(
						TeamFormation[4].X + 2,
						(TeamFormation[4].Y * 0.4 + Ball.Y * 0.6));

				TeamFormation[5] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, -90, 1);

				TeamFormation[6] = TriangleLocalization
						.get_det_with_distance_angle(midfielfCenter.X,
								midfielfCenter.Y, 90, 1);

				while ((!ProperSupportPosition(TeamFormation[5]))
						|| (!ProperSupportPosition(TeamFormation[6]))) {

					if (TeamFormation[5].Y < 0 || TeamFormation[6].Y < 0) {
						midfielfCenter.setY((midfielfCenter.getY() + 1));
					} else if (TeamFormation[5].Y > 0 || TeamFormation[6].Y > 0) {
						midfielfCenter.setY((midfielfCenter.getY() - 1));
					}

					TeamFormation[5] = TriangleLocalization
							.get_det_with_distance_angle(midfielfCenter.X,
									midfielfCenter.Y, -90, 1);

					TeamFormation[6] = TriangleLocalization
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
