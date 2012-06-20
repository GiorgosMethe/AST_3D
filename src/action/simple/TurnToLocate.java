package action.simple;

import motion.old.MotionTrigger;
import perceptor.localization.LocalizationResults;
import perceptor.vision.Vision;

public class TurnToLocate {

	public static boolean Act() {

		if (Vision.isiSee() == true) {

			if ((!Double.isNaN(LocalizationResults.getBody_angle()))
					&& (!Double.isNaN(LocalizationResults.getCurrent_location()
							.getX()))
					&& (!Double.isNaN(LocalizationResults.getCurrent_location()
							.getY()))) {

				MotionTrigger.setMotion("");
				return true;

			} else {

				MotionTrigger.setMotion("TurnRight40");
				return false;

			}
		}
		return false;
	}

}
