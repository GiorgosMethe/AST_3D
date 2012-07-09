/**
 * 
 */
package action.complex;

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

/***********************************************************************************
 * Copyright 2012, Technical University of Crete Academic Year 2011-2012
 * 
 * Thesis Project
 * 
 * @author Methenitis Georgios Student ID:2006030085
 * 
 *         Abstract: Player Behavior and Team Strategy for the RoboCup 3D
 *         Simulation League Start date: 25-04-2012 End date : xx-xx-2012
 ***********************************************************************************/
public class GoKickBallToGoal {

	public static boolean Act() {

		System.out.println("eketeleia   " + GKBGDstates.getState());

		if (Vision.isiSee()) {

			if (Ball.isSeeTheBall()) {
				if (Ball.RealDistance() > GKBGDstates.getDistance() + 0.05
						&& !GKBGDstates.getState().equalsIgnoreCase("Start")
						&& !GKBGDstates.getState().equalsIgnoreCase("Start4")) {
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

			double a = FindOpponentsGoal.Act()[0];
			double b = FindOpponentsGoal.Act()[1];

			if (!Double.isNaN(a) || !Double.isNaN(b)) {

				if (!Double.isNaN(a) && Double.isNaN(b)) {

					GKBGDstates.setAngleFromPost1(a);
				} else if (!Double.isNaN(b) && Double.isNaN(a)) {

					GKBGDstates.setAngleFromPost2(b);
				} else {

					GKBGDstates.setAngleFromPost1(a);
					GKBGDstates.setAngleFromPost2(b);
				}

				if (!Double.isNaN(GKBGDstates.getAngleFromPost1())
						&& !Double.isNaN(GKBGDstates.getAngleFromPost2())) {

					VisionType.setType(1);
					GKBGDstates.setState("Start2");
					GKBGDstates.setTimeout(0);
					GKBGDstates.setAngle(TriangleLocalization.FindAngleAVG(
							GKBGDstates.getAngleFromPost1(),
							GKBGDstates.getAngleFromPost2()));

				} else {

					if (GKBGDstates.getTimeout() > 50) {
						VisionType.setType(1);
						GKBGDstates.setState("Start2");
						if (!Double.isNaN(GKBGDstates.getAngleFromPost1())) {
							GKBGDstates.setAngle(GKBGDstates
									.getAngleFromPost1());
						} else {
							GKBGDstates.setAngle(GKBGDstates
									.getAngleFromPost2());
						}
						GKBGDstates.setTimeout(0);

					} else {
						GKBGDstates.setTimeout((GKBGDstates.getTimeout() + 1));

					}

				}

			} else {

				VisionType.setType(6);

				if (GKBGDstates.getTimeout() > 50) {
					VisionType.setType(1);
					GKBGDstates.setState("Start2");
					GKBGDstates.setAngle(180);
					GKBGDstates.setTimeout(0);

				} else {
					GKBGDstates.setTimeout((GKBGDstates.getTimeout() + 1));

				}
			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start2")) {

			if (HeadMovement.HeadAtBall) {

				GKBGDstates.setState("Start3");
				System.out.println(GKBGDstates.getAngle());

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start3")) {

			if (Math.abs(GKBGDstates.getAngle()) > 13) {

				if (GKBGDstates.getAngle() < 0) {

					if ((Math.abs(Ball.getAngleX()
							+ HingeJointPerceptor.getHj1())) > 5) {

						MotionTrigger.setMotion("TurnRight40");

					} else {

						MotionTrigger.setMotion("SideStepLeft");

					}
				} else {

					if ((Math.abs(Ball.getAngleX()
							+ HingeJointPerceptor.getHj1())) > 5) {

						MotionTrigger.setMotion("TurnLeft40");

					} else {

						MotionTrigger.setMotion("SideStepRight");

					}

				}

				GKBGDstates.setTimeout(0);
				GKBGDstates.setMoveTimeout(0);
				GKBGDstates.setAngleFromPost1(Double.NaN);
				GKBGDstates.setAngleFromPost2(Double.NaN);
				GKBGDstates.setState("Start1");

			} else {

				GKBGDstates.setTimeout(0);
				GKBGDstates.setMoveTimeout(0);
				GKBGDstates.setAngleFromPost1(Double.NaN);
				GKBGDstates.setAngleFromPost2(Double.NaN);
				MotionTrigger.setMotion("");
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