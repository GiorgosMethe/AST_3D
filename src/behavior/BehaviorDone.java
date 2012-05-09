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

package behavior;

public class BehaviorDone {
	
	public static String name;
	public static boolean behaviorDone;

	
	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		BehaviorDone.name = name;
	}

	public static boolean isBehaviorDone() {
		return behaviorDone;
	}

	public static void setBehaviorDone(boolean behaviorDone) {
		BehaviorDone.behaviorDone = behaviorDone;
	}
	
	

}
