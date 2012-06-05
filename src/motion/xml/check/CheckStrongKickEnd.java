package motion.xml.check;

import motion.xml.MotionPlaying;

public class CheckStrongKickEnd {

	public static boolean Check() {

		if (MotionPlaying.getMotionPhase() != null) {

			if (MotionPlaying.getMotionPhase().equalsIgnoreCase(
					"rigth_high_kick8")) {

				return true;

			}

		}

		return false;

	}

}
