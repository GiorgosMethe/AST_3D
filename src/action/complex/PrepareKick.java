package action.complex;

import motion.utils.MotionTrigger;
import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;
import action.vision.HeadMovement;

public class PrepareKick {

	public static boolean Act() {

		if (HeadMovement.HeadAtBall) {

			if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) < -12) {

				MotionTrigger.setMotion("SideStepRight");
				return false;

			} else if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > -5) {

				MotionTrigger.setMotion("SideStepLeft");
				return false;

			} else {

				MotionTrigger.setMotion("");
				return true;
			}
		} else {
			return false;
		}

	}

}
