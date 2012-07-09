package behavior.goalie;

import perceptor.localization.Coordinate;
import perceptor.worldstate.TeamState;
import action.complex.GoKickBallToGoal;
import action.complex.WalkToCompleteCoordinate;
import action.vision.MovingObject;
import action.vision.WatchBallMovement;
import agent.constraints.Constraints;

public class Goalie {

	public static void Act() {

		MovingObject MovingBall = WatchBallMovement.Watch();

		if (MovingBall != null) {
			System.out.println("Ball " + MovingBall.getObject().getX() + "  "
					+ MovingBall.getObject().getX());
			System.out.println("Angle " + MovingBall.getMovingAngle());
			System.out.println("Speed " + MovingBall.getSpeed());
		}

	}

	public static boolean ActLikeDefender() {

		return false;

	}

	public static boolean BallAtBox(Coordinate Ball) {

		if (TeamState.getTeamSide().equalsIgnoreCase("left")) {

			if (Ball.getX() < -8.5f && Math.abs(Ball.getY()) < 2) {

				return true;

			} else {

				return false;
			}

		} else {

			if (Ball.getX() > 8.5f && Math.abs(Ball.getY()) < 2) {

				return true;

			} else {

				return false;
			}

		}

	}

	public static boolean ClearBallFromBox() {

		return GoKickBallToGoal.Act();

	}

	public static boolean returnToInitPosition() {

		if (TeamState.getTeamSide().equalsIgnoreCase("left")) {
			return WalkToCompleteCoordinate.Act(Constraints.OwnGoal, 0);
		} else {
			return WalkToCompleteCoordinate.Act(Constraints.OwnGoal, 180);
		}

	}

}
