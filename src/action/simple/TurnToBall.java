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
