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


import communication.coordination.CoordinationMessageEncoder;
import communication.oFunctions.MessageEncoder;


import agent.AgentType;
import connection.Connection;
public class SendMessage {


	/*
	 * Class creates the communication effector of the agents.
	 * There are several types of messages
	 * type 1: starts the communication between the players
	 * type 2: admin sends to start coordination
	 * type 3: coordination messages
	 * type 4: stop coordination messages
	 * type 5: message which indicates fall of the player
	 * type 6: Idle
	 */
	public String Say(int type, Connection con){

		String message = "";

		if(type ==1){

			message = "(say"+" "+MessageEncoder.CreateStartMessage()+")";
			
			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}

		}else if(type == 2){

			message = "(say"+" "+MessageEncoder.CreateStartCoordinationMessage()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}


		}else if(type == 3){

			message = "(say"+" "+CoordinationMessageEncoder.Create()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}

		}else if(type == 4){

			message = "(say"+" "+MessageEncoder.CreateEndCoordinationMessage()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
				return message;
			}

		}else if(type == 5){

			message = "";
			/*
			 * 
			 * 
			 * needs something
			 * 
			 * 
			 */

		}else if(type == 6){

			message = "";

		}else{

			System.err.println("invalid message type");
			System.exit(1);

		}


		return "";

	}


}