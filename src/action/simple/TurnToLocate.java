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
import perceptor.localization.LocalizationFilter;
import perceptor.localization.LocalizationResults;
import perceptor.vision.Ball;
import action.vision.VisionType;

public class TurnToLocate {

	public static boolean Act() {

		if (LocalizationFilter.qe.size()>7 ) {

			VisionType.setType(6);
			MotionTrigger.setMotion("");
			return true;

		} else {

			VisionType.setType(6);
			MotionTrigger.setMotion("TurnRight40");
			return false;

		}

	}

}
