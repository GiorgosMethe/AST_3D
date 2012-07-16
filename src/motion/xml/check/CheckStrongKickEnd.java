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
