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

public class Check4Change {

	public static boolean check(String name){
		
		if(MotionPlaying.getMotionName()==null||MotionPlaying.getMotionName().equalsIgnoreCase("")){
			
			return true;	
			
		}else{
			
			if(!MotionPlaying.getMotionName().equalsIgnoreCase(name)){
				
				return false;
				
			}
			
		}
		
		return true;	
		
	}
	
}
