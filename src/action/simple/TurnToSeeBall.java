package action.simple;

import motion.utils.MotionTrigger;
import perceptor.vision.Ball;
import perceptor.vision.Vision;

public class TurnToSeeBall {

	public static boolean Act() {

		if (Vision.isiSee()) {
			if (Ball.isSeeTheBall()) {

				MotionTrigger.setMotion("");
				return true;
			} else {

				MotionTrigger.setMotion("TurnRight40");
				return false;
			}

		} else {

			return false;

		}

	}

}
