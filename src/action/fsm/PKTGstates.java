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
package action.fsm;

import perceptor.localization.CompleteCoordinate;
import perceptor.localization.Coordinate;

public class PKTGstates {

	public static int timeout;

	public static Coordinate ProperPositionToWalk;
	public static CompleteCoordinate result;

	public static int getTimeout() {
		return timeout;
	}

	public static void setTimeout(int timeout) {
		PKTGstates.timeout = timeout;
	}

	public static Coordinate getProperPositionToWalk() {
		return ProperPositionToWalk;
	}

	public static void setProperPositionToWalk(Coordinate properPositionToWalk) {
		ProperPositionToWalk = properPositionToWalk;
	}

	public static CompleteCoordinate getResult() {
		return result;
	}

	public static void setResult(CompleteCoordinate result) {
		PKTGstates.result = result;
	}

}
