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
package motion.xml;

public class MotionPlaying {

	public static String MotionName;
	public static String MotionPhase;
	public static int StartCyrcle;

	public static String getMotionName() {
		return MotionName;
	}

	public static void setMotionName(String motionName) {
		MotionName = motionName;
	}

	public static String getMotionPhase() {
		return MotionPhase;
	}

	public static void setMotionPhase(String motionPhase) {
		MotionPhase = motionPhase;
	}

	public static int getStartCyrcle() {
		return StartCyrcle;
	}

	public static void setStartCyrcle(int startCyrcle) {
		StartCyrcle = startCyrcle;
	}

}
