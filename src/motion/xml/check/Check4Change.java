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

public class Check4Change {

	public static boolean check(String name) {

		if (MotionPlaying.getMotionName() == null
				|| MotionPlaying.getMotionName().equalsIgnoreCase("")) {

			return true;

		} else {

			if (!MotionPlaying.getMotionName().equalsIgnoreCase(name)) {

				return false;

			}

		}

		return true;

	}

}
