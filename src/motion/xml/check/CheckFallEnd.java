/*******************************************************************************
 * Technical University of Crete
 * 
 * Thesis Project
 * 
 * Author:	Methenitis K. Georgios
 * 
 * Abstract  : Player Behavior and Team Strategy 
 * 			for the RoboCup 3D Simulation League
 * 
 * Date:  		July 2012
 ******************************************************************************/
package motion.xml.check;

import motion.xml.MotionPlaying;

public class CheckFallEnd {

	public static boolean Check() {

		if (MotionPlaying.getMotionName() != null) {

			if (MotionPlaying.getMotionName().equalsIgnoreCase("fall_right")
					|| MotionPlaying.getMotionName().equalsIgnoreCase(
							"fall_left")) {

				if (MotionPlaying.getMotionPhase().equalsIgnoreCase(
						"straighten")) {

					return true;

				}
			}

		}
		return false;
	}

}
