package action.complex;

import motion.old.MotionTrigger;
import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;

public class PrepareKick {

	public static boolean Act() {

		if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) < -10) {

			MotionTrigger.setMotion("SideStepRight");
			return false;

		} else if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > -5) {

			MotionTrigger.setMotion("SideStepLeft");
			return false;

		} else {

			MotionTrigger.setMotion("");
			return true;
		}

	}

}
