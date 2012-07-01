/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/
package motion.xml;

public class GetMotion {

	public static Motion Get(String name) {

		if (name.equalsIgnoreCase("walk_fine")) {
			Motion mot = XMLMotionStorage.getWalk_fine();
			return mot;
		} else if (name.equalsIgnoreCase("strafe_left")) {
			Motion mot = XMLMotionStorage.getStrafe_left();
			return mot;
		} else if (name.equalsIgnoreCase("strafe_right")) {
			Motion mot = XMLMotionStorage.getStrafe_right();
			return mot;
		} else if (name.equalsIgnoreCase("turn_left")) {
			Motion mot = XMLMotionStorage.getTurn_left();
			return mot;
		} else if (name.equalsIgnoreCase("turn_right")) {
			Motion mot = XMLMotionStorage.getTurn_right();
			return mot;
		} else if (name.equalsIgnoreCase("rigth_front_front_kick")) {
			Motion mot = XMLMotionStorage.getRigth_front_front_kick();
			return mot;
		} else if (name.equalsIgnoreCase("strong_right_kick")) {
			Motion mot = XMLMotionStorage.getRight_strong_kick();
			return mot;
		} else if (name.equalsIgnoreCase("stand_back")) {
			Motion mot = XMLMotionStorage.getStand_back();
			return mot;
		} else if (name.equalsIgnoreCase("stand_front")) {
			Motion mot = XMLMotionStorage.getStand_front();
			return mot;
		}

		return null;
	}

}
