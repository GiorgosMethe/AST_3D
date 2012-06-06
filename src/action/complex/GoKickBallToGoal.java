/**
 * 
 */
package action.complex;

import localization.Coordinate;
import localization.LocalizationResults;
import localization.TriangleLocalization;
import motion.old.MotionTrigger;
import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;
import action.fsm.GKBGDstates;
import action.simple.WalkToBallForKick;
import action.vision.VisionType;
import agent.Constraints;

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

			if (WalkToBallForKick.Act()) {

				GKBGDstates.setState("Start1");

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start1")) {

			VisionType.setType(4);

			if (GKBGDstates.getTimeout() < 40) {

				int timeout = GKBGDstates.getTimeout();
				GKBGDstates.setTimeout((timeout + 1));

			} else if (GKBGDstates.getTimeout() < 41) {

				int timeout = GKBGDstates.getTimeout();
				GKBGDstates.setTimeout((timeout + 1));
				GKBGDstates
						.setAngle((GKBGDstates.getAngle() + LocalizationResults
								.getBody_angle()));
				GKBGDstates.setX((GKBGDstates.getX() + LocalizationResults
						.getCurrent_location().getX()));
				GKBGDstates.setY((GKBGDstates.getY() + LocalizationResults
						.getCurrent_location().getY()));

			} else {

				GKBGDstates.setAngle((GKBGDstates.getAngle() / 1));
				GKBGDstates.setX((GKBGDstates.getX() / 1));
				GKBGDstates.setY((GKBGDstates.getY() / 1));
				GKBGDstates.setState("Start2");
				GKBGDstates.setTimeout(0);
			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start2")) {

			Coordinate agent = new Coordinate(GKBGDstates.getX(),
					GKBGDstates.getY());
			double AngleFromGoal = TriangleLocalization
					.FindAngleBetweenCoordinates(agent,
							Constraints.OpponentGoal);
			GKBGDstates.setAngleFromGoal(AngleFromGoal);
			GKBGDstates.setState("Start3");

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start3")) {

			System.out.println("mpala :"
					+ (Math.abs(GKBGDstates.getAngle()
							- GKBGDstates.getAngleFromGoal())));

			if (Math.abs(GKBGDstates.getAngle()
					- GKBGDstates.getAngleFromGoal()) > 20) {

				if (((GKBGDstates.getAngle() - GKBGDstates.getAngleFromGoal()) > 0)
						&& (GKBGDstates.getAngle() - GKBGDstates
								.getAngleFromGoal()) < 180) {

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

				GKBGDstates.setAngle(0);
				GKBGDstates.setX(0);
				GKBGDstates.setY(0);
				GKBGDstates.setAngleFromGoal(0);
				GKBGDstates.setState("Start1");

			} else {

				MotionTrigger.setMotion("");
				GKBGDstates.setAngle(0);
				GKBGDstates.setX(0);
				GKBGDstates.setY(0);
				GKBGDstates.setAngleFromGoal(0);
				GKBGDstates.setState("Start4");

			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start4")) {

			VisionType.setType(1);

			if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) < -8) {

				MotionTrigger.setMotion("SideStepRight");
				return false;

			} else if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > 8) {

				MotionTrigger.setMotion("SideStepLeft");
				return false;

			} else {

				MotionTrigger.setMotion("");
				GKBGDstates.setState("Start5");
			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start5")) {

			if (GoKickBallDynamic.Act()) {
				GKBGDstates.setAngle(0);
				GKBGDstates.setX(0);
				GKBGDstates.setY(0);
				GKBGDstates.setAngleFromGoal(0);
				GKBGDstates.setState("Start6");
			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("Start6")) {

			if (GKBGDstates.getTimeout() < 100) {
				int timeout = GKBGDstates.getTimeout();
				GKBGDstates.setTimeout((timeout + 1));

			} else {
				GKBGDstates.setTimeout(0);
				GKBGDstates.setState("Start");
			}

		}

		return false;

	}

}
