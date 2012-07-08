/**
 * 
 */
package action.complex;

import motion.old.MotionTrigger;
import motion.xml.MotionPlaying;
import perceptor.joints.HingeJointPerceptor;
import perceptor.localization.TriangleLocalization;
import perceptor.vision.Ball;
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

		if (GKBGDstates.getState().equalsIgnoreCase("Start")) {

			if (WalkToBall.Act()) {

				GKBGDstates.setAngleFromPost1(Double.NaN);
				GKBGDstates.setAngleFromPost2(Double.NaN);
				GKBGDstates.setState("Start1");

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start1")) {

			double a = FindOpponentsGoal.Act()[0];
			double b = FindOpponentsGoal.Act()[1];
			VisionType.setType(6);

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

					System.out.println("den einai nan kamia");
					VisionType.setType(1);
					GKBGDstates.setState("Start2");
					GKBGDstates.setTimeout(0);
					GKBGDstates.setAngle(TriangleLocalization.FindAngleAVG(
							GKBGDstates.getAngleFromPost1(),
							GKBGDstates.getAngleFromPost2()));
					System.out.println("a " + GKBGDstates.getAngleFromPost1()
							+ "   b " + GKBGDstates.getAngleFromPost2());
					System.out.println(TriangleLocalization.FindAngleAVG(
							GKBGDstates.getAngleFromPost1(),
							GKBGDstates.getAngleFromPost2()));

				} else {

					if (GKBGDstates.getTimeout() > 80) {
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

				if (GKBGDstates.getTimeout() > 80) {
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

				if (Math.abs(GKBGDstates.getAngle()) < 45) {
					GKBGDstates.setMoveTimeout(50);
				} else if (Math.abs(GKBGDstates.getAngle()) < 90) {
					GKBGDstates.setMoveTimeout(70);
				} else {
					GKBGDstates.setMoveTimeout(100);
				}
				System.out.println("stamathse");
				GKBGDstates.setState("Start3");

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start3")) {

			if (Math.abs(GKBGDstates.getAngle()) > 10) {

				if (GKBGDstates.getAngle() < 0) {

					if ((Math.abs(Ball.getAngleX()
							+ HingeJointPerceptor.getHj1())) > 5) {

						if ((Ball.getAngleX() + HingeJointPerceptor.getHj1()) > 0) {
							MotionTrigger.setMotion("TurnLeft40");
						} else {
							MotionTrigger.setMotion("TurnRight40");
						}

					} else {

						MotionTrigger.setMotion("SideStepLeft");

					}
				} else {

					if ((Math.abs(Ball.getAngleX()
							+ HingeJointPerceptor.getHj1())) > 5) {

						if ((Ball.getAngleX() + HingeJointPerceptor.getHj1()) > 0) {
							MotionTrigger.setMotion("TurnLeft40");
						} else {
							MotionTrigger.setMotion("TurnRight40");
						}

					} else {

						MotionTrigger.setMotion("SideStepRight");

					}

				}

				GKBGDstates.setState("Start4");

			} else {

				GKBGDstates.setState("Start5");

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start4")) {

			if (GKBGDstates.getTimeout() > GKBGDstates.getMoveTimeout()) {

				if (MotionPlaying.getMotionName() == null) {

					GKBGDstates.setTimeout(0);
					GKBGDstates.setState("Start1");

				} else {

					MotionTrigger.setMotion("");
				}

			} else {

				GKBGDstates.setState("Start3");
				GKBGDstates.setTimeout((GKBGDstates.getTimeout() + 1));

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start5")) {

			if (GoKickBallDynamic.Act()) {

				GKBGDstates.setState("Start");
			}

		}

		return false;
	}

}
