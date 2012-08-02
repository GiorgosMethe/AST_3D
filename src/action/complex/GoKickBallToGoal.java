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
package action.complex;

import motion.utils.MotionTrigger;
import motion.xml.MotionPlaying;
import perceptor.joints.HingeJointPerceptor;
import perceptor.localization.LocalizationFilter;
import perceptor.localization.LocalizationResults;
import perceptor.localization.TriangleLocalization;
import perceptor.vision.Ball;
import perceptor.vision.Vision;
import action.fsm.GKBGDstates;
import action.simple.WalkToBall;
import action.vision.FindOpponentsGoal;
import action.vision.HeadMovement;
import action.vision.VisionType;
import agent.constraints.Constraints;

public class GoKickBallToGoal {

	public static float angle = 0, angleSum = 0;

	public static boolean Act() {

		if (Vision.isiSee()) {

			if (Ball.isSeeTheBall()) {
				if (Ball.RealDistance() > 1) {
					GKBGDstates.setState("Start");
				}

			}

		}

		if (GKBGDstates.getState().equalsIgnoreCase("Start")) {

			if (WalkToBall.Act()) {

				GKBGDstates.setDistance(Ball.RealDistance());
				GKBGDstates.setAngleFromPost1(Double.NaN);
				GKBGDstates.setAngleFromPost2(Double.NaN);
				GKBGDstates.setAngle(180);
				GKBGDstates.setTimeout(0);
				GKBGDstates.setMoveTimeout(0);
				GKBGDstates.setState("Start1");

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start1")) {

			if (LocalizationResults.isKnowMyPosition()
					&& LocalizationFilter.qe.size() >= 8) {

				VisionType.setType(1);
				GKBGDstates.setState("Start2");
				GKBGDstates.setAngle(TriangleLocalization
						.FindAngleBetweenCoordinates(
								LocalizationFilter.MyPosition,
								Constraints.OpponentGoal)
						- LocalizationFilter.MyFilteredPosition.getTheta());
				GKBGDstates.setDistance(TriangleLocalization
						.FindDistanceAmong2Coordinates(
								LocalizationFilter.MyPosition,
								Constraints.OpponentGoal));

			} else {

				VisionType.setType(7);

				double[] OppGoal = FindOpponentsGoal.Act();

				if (!Double.isNaN(OppGoal[0])) {
					GKBGDstates.setAngleFromPost1(OppGoal[0]);
					GKBGDstates.setDistance(OppGoal[2]);

				}
				if (!Double.isNaN(OppGoal[1])) {
					GKBGDstates.setAngleFromPost2(OppGoal[1]);
					GKBGDstates.setDistance(OppGoal[2]);
				}

				if (!Double.isNaN(GKBGDstates.getAngleFromPost1())
						&& !Double.isNaN(GKBGDstates.getAngleFromPost2())) {

					GKBGDstates.setAngle(TriangleLocalization.FindAngleAVG(
							GKBGDstates.getAngleFromPost1(),
							GKBGDstates.getAngleFromPost2()));
					GKBGDstates.setState("Start2");
					VisionType.setType(1);
				}

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start2")) {

			if (HeadMovement.HeadAtBall) {

				angleSum = 0;
				GKBGDstates.setState("Start3");

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start3")) {

			if (MotionPlaying.getMotionName() != null) {
				if (MotionPlaying.getMotionName().equalsIgnoreCase("turn_left")
						|| MotionPlaying.getMotionName().equalsIgnoreCase(
								"turn_right")) {

					if (MotionPlaying.getMotionPhase().equalsIgnoreCase(
							"start_big_turning_right")
							|| MotionPlaying.getMotionPhase().equalsIgnoreCase(
									"start_big_turning_left")) {

						angleSum += 1;

					}

				}
			}

			if (Math.abs(GKBGDstates.getAngle()) > 10) {

				if (GKBGDstates.getAngle() < 0) {

					if ((Math.abs(Ball.getAngleX()
							+ HingeJointPerceptor.getHj1())) > 2) {

						MotionTrigger.setMotion("TurnRight40");

					} else {

						MotionTrigger.setMotion("SideStepLeft");

					}

				} else {

					if ((Math.abs(Ball.getAngleX()
							+ HingeJointPerceptor.getHj1())) > 2) {

						MotionTrigger.setMotion("TurnLeft40");

					} else {

						MotionTrigger.setMotion("SideStepRight");

					}

				}

				GKBGDstates.setState("Start1");
				GKBGDstates.setAngleFromPost1(Double.NaN);
				GKBGDstates.setAngleFromPost2(Double.NaN);

			} else {
				GKBGDstates.setState("Start4");

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start4")) {

			if (GoKickBallDynamic.Act()) {
				GKBGDstates.setState("Start");
				return true;
			}

		}

		return false;
	}
}
