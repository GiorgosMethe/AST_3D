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
package action.simple;

import motion.utils.MotionTrigger;
import perceptor.joints.HingeJointPerceptor;
import perceptor.localization.BallPosition;
import perceptor.localization.TriangleLocalization;

public class TurnToBall {

	public static boolean Act() {

		if (TurnToSeeBall.Act() == true) {

			if (Math.abs(HingeJointPerceptor.getHj1())
					+ Math.abs(BallPosition.getAngle()) > 20) {

				if (HingeJointPerceptor.getHj1() > 0) {

					MotionTrigger.setMotion("TurnLeft40");
					MotionTrigger.setTurn((float) (Math.abs(HingeJointPerceptor.getHj1())
							+ Math.abs(BallPosition.getAngle())));
					return false;

				} else {

					MotionTrigger.setMotion("TurnRight40");
					MotionTrigger.setTurn((float) (Math.abs(HingeJointPerceptor.getHj1())
							+ Math.abs(BallPosition.getAngle())));
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
