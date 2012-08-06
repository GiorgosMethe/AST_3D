package action.simple;

import motion.utils.MotionTrigger;
import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;
import action.vision.HeadMovement;

public class PrepareKickOld {

	public static boolean Act() {

		if (HeadMovement.HeadAtBall) {

			if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) < -5) {

				MotionTrigger.setMotion("SideStepRight");
				return false;

			} else if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > 5) {

				MotionTrigger.setMotion("SideStepLeft");
				return false;

			} else {

				if ((Ball.RealDistance() > 0.79)) {

					MotionTrigger.setMotion("Forwards50");
					return false;
				} else {

					MotionTrigger.setMotion("");
					return true;
				}
			}

		}
		return false;

	}
}
