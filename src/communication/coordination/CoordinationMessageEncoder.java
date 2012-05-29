/**
 * 
 */
package communication.coordination;

import coordination.SoccerFieldCoordinateValue;
import localization.LocalizationResults;
import agent.AgentType;

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
public class CoordinationMessageEncoder {
	
	public static String Create(){
		
		String message = "";
		String type  = "c"+",";
		
		message += type + Integer.toString(AgentType.getPlayerNum())+",";
		
		message += Integer.toString((int) Math.rint(LocalizationResults.getCurrent_location().X))+",";
		message += Integer.toString((int) Math.rint(LocalizationResults.getCurrent_location().Y))+",";
		
		message += Integer.toString((int) Math.rint(LocalizationResults.getBall_location().X))+",";
		message += Integer.toString((int) Math.rint(LocalizationResults.getBall_location().Y));
			
		
		return message;
		
	}

}
