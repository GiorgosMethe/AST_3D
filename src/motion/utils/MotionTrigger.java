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
package motion.utils;

public class MotionTrigger {

	public static String Motion;
	public static float Turn;

	public static String getMotion() {
		return Motion;
	}

	public static void setMotion(String motion) {
		Motion = motion;
	}

	public static float getTurn() {
		return Turn;
	}

	public static void setTurn(float turn) {
		Turn = turn;
	}
	
	
	
	

}
