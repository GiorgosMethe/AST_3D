/**
 * 
 */
package coordination.action;

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
public class ActionTranslator {
	
	public static String FromTypeToString(int type){
		
		String Action = ""; 
		
		if(type==1){
			
			Action = "GoKickBallToGoal";
			
		}
		
		
		
		
		
		return Action;
	
	}

	public static int FromStringToType(String name){
		
		int type = 0;
		
		if(name.equalsIgnoreCase("GoKickBallToGoal")){
			
			type = 1;
			
		}
		
		
		
		
		return type;
		
	}
}
