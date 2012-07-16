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
package action.simple;

import motion.utils.MotionTrigger;
import motion.xml.MotionPlaying;
import action.fsm.SUstates;

public class StandUp {

	public static boolean Act() {

		if (SUstates.getState().equalsIgnoreCase("Start")) {

			if (MotionPlaying.getMotionName() == null) {

				SUstates.setState("StandUp");

			} else {

				MotionTrigger.setMotion("");
			}

		} else if (SUstates.getState().equalsIgnoreCase("StandUp")) {

			MotionTrigger.setMotion("stand_back");
			SUstates.setState("w8ToEnd");

		} else if (SUstates.getState().equalsIgnoreCase("w8ToEnd")) {

			MotionTrigger.setMotion("");

			if (MotionPlaying.getMotionName() == null) {

				SUstates.setState("Finish");

			}

		} else if (SUstates.getState().equalsIgnoreCase("Finish")) {

			SUstates.setState("Start");
			return true;

		}

		return false;

	}

}
