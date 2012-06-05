package motion.xml.check;

import motion.xml.MotionPlaying;

public class CheckKickEnd {

	public static boolean Check() {

		if (MotionPlaying.getMotionPhase() != null) {

			if (MotionPlaying.getMotionPhase().equalsIgnoreCase(
					"rigth_front_front_kick5")) {

				return true;

			}

		}

		return false;

	}

}
