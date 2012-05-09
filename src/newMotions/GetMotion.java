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
package newMotions;

public class GetMotion {
	
	public static Motion Get(String name){
		
		if(name.equalsIgnoreCase("walk_fine")){
			Motion mot=NewMotionStorage.getWalk_fine();
			return mot;
		}else if(name.equalsIgnoreCase("strafe_left")){
			Motion mot=NewMotionStorage.getStrafe_left();
			return mot;
		}else if(name.equalsIgnoreCase("strafe_right")){
			Motion mot=NewMotionStorage.getStrafe_right();
			return mot;
		}else if(name.equalsIgnoreCase("turn_left")){
			Motion mot=NewMotionStorage.getTurn_left();
			return mot;
		}else if(name.equalsIgnoreCase("turn_right")){
			Motion mot=NewMotionStorage.getTurn_right();
			return mot;
		}else if(name.equalsIgnoreCase("rigth_front_front_kick")){
			Motion mot=NewMotionStorage.getRigth_front_front_kick();
			return mot;
		}
		
		
		
		return null;		
	}

}
