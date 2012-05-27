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
package communication.effector;


import agent.AgentType;
import connection.Connection;
public class SendMessage {
	
	public String Say(String msg, Connection con){
		
		String message = "(say"+" "+msg+")";
		
		if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
			return message;
		}

		return "";

	}
	

}