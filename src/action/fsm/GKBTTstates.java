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

public class GKBTTstates {

	public static String State;
	public static int timeout;

	public static String getState() {
		return State;
	}

	public static void setState(String state) {
		State = state;
	}

	public static int getTimeout() {
		return timeout;
	}

	public static void setTimeout(int timeout) {
		GKBTTstates.timeout = timeout;
	}

}
