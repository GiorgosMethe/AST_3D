package motion.xml.check;

import motion.xml.MotionPlaying;

public class CheckFallEnd {

	public static boolean Check() {

		if (MotionPlaying.getMotionName().equalsIgnoreCase("fall_right")
				|| MotionPlaying.getMotionName().equalsIgnoreCase("fall_left")) {

			if (MotionPlaying.getMotionPhase().equalsIgnoreCase("straighten")) {

				return true;

			}
		}
		return false;
	}

}
