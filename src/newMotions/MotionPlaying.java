/***********************************************************************************
 * 				  Copyright 2012, Technical University of Crete				       *
 * 							 Academic Year 2011-2012					           *
 ***********************************************************************************
 * 								Thesis Project								       *
 ***********************************************************************************
 * @author Methenitis Georgios													   *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League*
 * Start date: 25-04-2012														   *																	 
 * End date  : xx-xx-2012														   *																			   *
 ***********************************************************************************/
package newMotions;

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
