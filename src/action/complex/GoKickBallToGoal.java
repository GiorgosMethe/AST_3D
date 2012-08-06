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

import motion.old.CurrentMotion;
import motion.old.MotionController;
import motion.utils.MotionTrigger;
import perceptor.joints.HingeJointPerceptor;
import perceptor.localization.TriangleLocalization;
import perceptor.vision.Ball;
import perceptor.vision.Vision;
import action.fsm.GKBGDstates;
import action.simple.WalkToBall;
import action.vision.FindOpponentsGoal;
import action.vision.HeadMovement;
import action.vision.VisionType;

public class GoKickBallToGoal {

	public static float angle = 0, angleSum = 0;
	public static double turn = 0;

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

			VisionType.setType(8);

			double[] OppGoal = FindOpponentsGoal.Act();

			if (!Double.isNaN(OppGoal[0])) {

				GKBGDstates.setAngleFromPost1(OppGoal[0]);
				GKBGDstates.setDistanceFromPost1(OppGoal[2]);

			}
			if (!Double.isNaN(OppGoal[1])) {

				GKBGDstates.setAngleFromPost2(OppGoal[1]);
				GKBGDstates.setDistanceFromPost2(OppGoal[2]);
			}

			if (!Double.isNaN(GKBGDstates.getAngleFromPost1())
					&& !Double.isNaN(GKBGDstates.getAngleFromPost2())) {

				GKBGDstates.setAngle(TriangleLocalization.FindAngleAVG(
						GKBGDstates.getAngleFromPost1(),
						GKBGDstates.getAngleFromPost2()));

				GKBGDstates
						.setDistance((GKBGDstates.getDistanceFromPost1() + GKBGDstates
								.getDistanceFromPost2()) / 2);
				GKBGDstates.setState("Start2");
				VisionType.setType(1);
			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start2")) {

			VisionType.setType(1);
			if (HeadMovement.HeadAtBall) {

				if (GKBGDstates.getTimeout() < 10) {
					GKBGDstates.setTimeout(GKBGDstates.getTimeout() + 1);
				} else {

					GKBGDstates.setState("Start3");
					GKBGDstates.setTimeout(0);
					angleSum = 0;
					angle = 0;
				}

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start3")) {

			VisionType.setType(1);
			if (CurrentMotion.CurrentMotionPlaying
					.equalsIgnoreCase("TurnLeft40")
					|| CurrentMotion.CurrentMotionPlaying
							.equalsIgnoreCase("TurnRight40")) {
				if (angleSum == 0) {
					turn = MotionController.hardnessNormal;
				}
				angleSum += 1;

				if (angleSum == 72) {

					angleSum = 0;

					angle += 3 + 46 * (turn - 0.3) / 0.7;

				}

			}

			float threshold = 0;

			if (GKBGDstates.getDistance() < 3) {
				threshold = 25;
			} else if (GKBGDstates.getDistance() < 8) {
				threshold = 10;
			} else if (GKBGDstates.getDistance() < 12) {
				threshold = 20;
			} else {
				threshold = 40;
			}
			if ((Math.abs(Math.abs(GKBGDstates.getAngle()) - Math.abs(angle))) > threshold) {

				if (GKBGDstates.getAngle() < 0) {

					if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) < -10) {

						MotionTrigger.setMotion("TurnRight40");

						MotionTrigger.setTurn((float) Math.min(
								(HingeJointPerceptor.getHj1() + Ball
										.getAngleX()),
								Math.abs(GKBGDstates.getAngle()) - angle));

					} else {
						MotionTrigger.setMotion("SideStepLeft");
					}

				} else {

					if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > 10) {

						MotionTrigger.setMotion("TurnLeft40");
						MotionTrigger.setTurn((float) Math.min(
								(HingeJointPerceptor.getHj1() + Ball
										.getAngleX()),
								Math.abs(GKBGDstates.getAngle()) - angle));

					} else {
						MotionTrigger.setMotion("SideStepRight");
					}

				}

			} else {

				GKBGDstates.setState("Start4");
				GKBGDstates.setAngleFromPost1(Double.NaN);
				GKBGDstates.setAngleFromPost2(Double.NaN);

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start4")) {

			if (GKBGDstates.getDistance() < 2.5f) {
				if (KickBallNormal.Act()) {
					GKBGDstates.setState("Start");
					return true;
				}
			} else {
				if (KickBallStrong.Act()) {
					GKBGDstates.setState("Start");
					return true;
				}
			}

		}

		return false;
	}
}
