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


import agent.AgentType;

import communication.FieldFunctions.MessageCreator;
import communication.coordination.CoordinationMessageCreator;

import connection.Connection;
public class SayEffector {


	/*
	 * Class creates the communication effector of the agents.
	 * There are several types of messages
	 * type 1: starts the communication between the players
	 * type 2: admin sends to start coordination message 1
	 * type 3: admin sends to start coordination message 2
	 * type 4: coordination message 1
	 * type 5: coordination message 2
	 * type 6: stop coordination messages
	 * type 7: message which indicates fall of the player
	 * type 8: Idle
	 */
	public String Say(int type, Connection con){

		String message = "";

		if(type ==1){

			message = "(say"+" "+MessageCreator.CreateStartMessage()+")";
			
			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}

		}else if(type == 2){

			message = "(say"+" "+MessageCreator.CreateStartCoordinationMessage1()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}
			
		}else if(type == 3){

			message = "(say"+" "+MessageCreator.CreateStartCoordinationMessage2()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}


		}else if(type == 4){

			message = "(say"+" "+CoordinationMessageCreator.Create1()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}
			
		}else if(type == 5){

			message = "(say"+" "+CoordinationMessageCreator.Create2()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}

		}else if(type == 6){

			message = "(say"+" "+MessageCreator.CreateEndCoordinationMessage()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}

		}else if(type == 7){

			message = "";
			/*
			 * 
			 * 
			 * needs something
			 * 
			 * 
			 */

		}else if(type == 8){

			message = "";

		}else{

			System.err.println("invalid message type");
			System.exit(1);

		}


		return "";

	}


}