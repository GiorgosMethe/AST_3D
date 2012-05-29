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
package communication.handler;


import communication.coordination.CoordinationMessageCoder;

import agent.AgentType;
import connection.Connection;
public class SendMessage {
	
	
	/*
	 * Class creates the communication effector of the agents.
	 * There are several types of messages
	 * type 1: starts the communication between the players
	 * type 2: sends coordination values
	 */
	public String Say(int type, Connection con){
		
		String message = "";
		
		if(type ==1){
			
			
			
			
			
		}else if(type == 2){
			
			message = "(say"+" "+CoordinationMessageCoder.Create()+")";
			
			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}
		

		}else{
			
			
			
		}
		
		
		return "";
		
	}
	

}