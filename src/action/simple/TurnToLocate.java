package action.simple;

import motion.old.MotionTrigger;
import perceptor.localization.LocalizationResults;
import perceptor.vision.Ball;
import action.vision.VisionType;

public class TurnToLocate {

	public static boolean Act() {

		if (LocalizationResults.isKnowMyPosition() && Ball.isSeeTheBall()) {

			VisionType.setType(4);
			MotionTrigger.setMotion("");
			return true;

		} else {

			VisionType.setType(4);
			MotionTrigger.setMotion("TurnRight40");
			return false;

		}

	}

}
