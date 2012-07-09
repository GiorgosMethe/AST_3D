/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/

package action.simple;

import motion.utils.MotionTrigger;
import perceptor.joints.HingeJointPerceptor;
import perceptor.localization.BallPosition;

public class TurnToBall {

	public static boolean Act() {

		if (TurnToSeeBall.Act() == true) {

			if (Math.abs(HingeJointPerceptor.getHj1())
					+ Math.abs(BallPosition.getAngle()) > 20) {

				if (HingeJointPerceptor.getHj1() > 0) {

					MotionTrigger.setMotion("TurnLeft40");
					return false;

				} else {

					MotionTrigger.setMotion("TurnRight40");
					return false;

				}

			} else {

				MotionTrigger.setMotion("");
				return true;

			}

		} else {
			return false;
		}

	}

}
