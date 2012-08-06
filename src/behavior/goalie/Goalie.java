/*******************************************************************************
 * Technical University of Crete
 * 
 * Thesis Project
 * 
 * Author:	Methenitis K. Georgios
 * 
 * Abstract  : Player Behavior and Team Strategy 
 * 			for the RoboCup 3D Simulation League
 * 
 * Date:  		July 2012
 ******************************************************************************/
package behavior.goalie;

import motion.utils.MotionTrigger;
import motion.xml.check.CheckFallEnd;
import perceptor.localization.BallLocalizationFilter;
import perceptor.localization.Coordinate;
import perceptor.localization.LocalizationResults;
import perceptor.localization.TriangleLocalization;
import perceptor.worldstate.TeamState;
import utils.geometry.GeometricUtils;
import action.complex.GoKickBallToGoal;
import action.complex.WalkToCompleteCoordinate;
import action.vision.MovingObject;
import action.vision.VisionType;
import action.vision.WatchBallMovement;
import agent.constraints.Constraints;

public class Goalie {

	public static String state = "Start";

	public static void Act() {

		if (Goalie.state.equalsIgnoreCase("Start")) {

			if (returnToInitPosition()) {

				Goalie.state = "GuardState";

			}

		} else if (Goalie.state.equalsIgnoreCase("GuardState")) {

			VisionType.setType(1);

			MovingObject MovingBall = WatchBallMovement.Watch();

			if (MovingBall != null) {

				isDangerous(MovingBall);

			}

		} else if (Goalie.state.equalsIgnoreCase("Fall_left")) {

			MotionTrigger.setMotion("fall_left");
			if (CheckFallEnd.Check()) {

				Goalie.state = "Start";
				MotionTrigger.setMotion("");

			}

		} else if (Goalie.state.equalsIgnoreCase("Fall_right")) {

			MotionTrigger.setMotion("fall_right");
			if (CheckFallEnd.Check()) {

				Goalie.state = "Start";
				MotionTrigger.setMotion("");

			}

		} else if (Goalie.state.equalsIgnoreCase("Libero")) {

			if (!BallAtBoxRealCoordinationMap(BallLocalizationFilter.MyFilteredBallPosition)) {

				Goalie.state = "Start";

			}

			if (GoKickBallToGoal.Act()) {

				System.out
						.println("telos klotsia @@@@@@@@@@@@@@@@@@@@@@!!!!!!!!!!!!!!!!");

				Goalie.state = "Libero";

			}
		}

	}

	public static boolean ActLikeDefender() {

		return false;

	}

	public static boolean isDangerous(MovingObject movingBall) {

		Coordinate GoalLineStart = new Coordinate(0, 7);
		Coordinate GoalLineEnd = new Coordinate(0, -7);

		Coordinate BallLineStart = new Coordinate(
				movingBall.getObject().getX(), movingBall.getObject().getY());
		Coordinate BallLineEnd = TriangleLocalization
				.get_det_with_distance_angle(BallLineStart.getX(),
						BallLineStart.getY(), movingBall.getMovingAngle(), 10);

		com.vividsolutions.jts.geom.Coordinate interceptionPoint = GeometricUtils
				.FindIntersection(GoalLineStart, GoalLineEnd, BallLineStart,
						BallLineEnd);

		if (interceptionPoint != null) {

			System.out.println(interceptionPoint.x + " " + interceptionPoint.y
					+ " speed" + movingBall.Speed);

			if (interceptionPoint.y > 0 && interceptionPoint.y < 2) {

				if (((movingBall.getSpeed() * 1) - (1 / 2 * (-10) * 1)) > (TriangleLocalization
						.FindDistanceAmong2Coordinates(new Coordinate(
								interceptionPoint.x, interceptionPoint.y),
								movingBall.getObject()))) {

					MotionTrigger.setMotion("fall_left");
					Goalie.state = "Fall_left";
					return true;

				}

			} else if (interceptionPoint.y < 0 && interceptionPoint.y > -2) {

				if (((movingBall.getSpeed() * 1) - (1 / 2 * (-10) * 1)) > (TriangleLocalization
						.FindDistanceAmong2Coordinates(new Coordinate(
								interceptionPoint.x, interceptionPoint.y),
								movingBall.getObject()))) {

					MotionTrigger.setMotion("fall_right");
					Goalie.state = "Fall_right";
					return true;

				}

			} else {

			}

		} else {

			if (BallAtBox(movingBall.getObject())) {

				System.out.println("Ball not moving fast");
				double min = 1000;

				for (int i = 0; i < LocalizationResults.getRivals().size(); i++) {

					Coordinate Opponent = TriangleLocalization
							.get_det_with_distance_angle(
									0,
									0,
									LocalizationResults.getRivals()
											.elementAt(i).getHorizontal_Angle(),
									LocalizationResults.getRivals()
											.elementAt(i).getDistance());

					double distance = TriangleLocalization
							.FindDistanceAmong2Coordinates(
									movingBall.getObject(), Opponent);

					if (distance < min) {

						min = distance;

					}

				}

				for (int i = 0; i < LocalizationResults.getCoplayers().size(); i++) {

					Coordinate Opponent = TriangleLocalization
							.get_det_with_distance_angle(
									0,
									0,
									LocalizationResults.getCoplayers()
											.elementAt(i).getHorizontal_Angle(),
									LocalizationResults.getCoplayers()
											.elementAt(i).getDistance());

					double distance = TriangleLocalization
							.FindDistanceAmong2Coordinates(
									movingBall.getObject(), Opponent);

					if (distance < min) {

						min = distance;

					}

				}

				// Ball in our box and opponent agent probably close to the
				if (min < 2) {

					System.out.println("Players near");
					// wait at guard state

				} else {

					System.out.println("Players far");
					// Goalie needs to act as libero in this situation
					Goalie.state = "Libero";

				}

			}

		}

		return false;

	}

	public static boolean BallAtBoxRealCoordinationMap(Coordinate Ball) {

		if (TeamState.getTeamSide().equalsIgnoreCase("left")) {

			if (Ball.getX() < -8.5 && Math.abs(Ball.getY()) < 2) {

				return true;

			} else {

				return false;
			}

		} else {

			if (Ball.getX() > 8.5 && Math.abs(Ball.getY()) < 2) {

				return true;

			} else {

				return false;
			}

		}

	}

	public static boolean BallAtBox(Coordinate Ball) {

		if (TeamState.getTeamSide().equalsIgnoreCase("left")) {

			if (Ball.getX() < 2 && Math.abs(Ball.getY()) < 2) {

				return true;

			} else {

				return false;
			}

		} else {

			if (Ball.getX() < 2 && Math.abs(Ball.getY()) < 2) {

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
			return WalkToCompleteCoordinate.Act(new Coordinate(
					Constraints.OwnGoal.X + 0.5f, Constraints.OwnGoal.Y), 0);
		} else {
			return WalkToCompleteCoordinate.Act(Constraints.OwnGoal, 180);
		}

	}

}
