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

public class CFstates {

	public static String State;
	public static int CheckFRPtimer;

	public static String getState() {
		return State;
	}

	public static void setState(String state) {
		State = state;
	}

	public static int getCheckFRPtimer() {
		return CheckFRPtimer;
	}

	public static void setCheckFRPtimer(int checkFRPtimer) {
		CheckFRPtimer = checkFRPtimer;
	}

}
