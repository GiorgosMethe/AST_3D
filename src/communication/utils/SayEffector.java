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
package communication.utils;

import agent.AgentType;
import agent.Constraints;
import connection.Connection;
import coordination.communication.ActionMessages;



public class SayEffector {


	/*
	 * Class creates the communication message of the agents.
	 * There are several types of messages
	 * type 1: starts the communication between the players
	 * type 2: (admin) sends to start coordination message 1
	 * type 3: (admin) sends back action messages
	 * type 4: coordination message 1
	 * type 5: empty
	 * type 6: (admin) sends to stop coordination messages
	 * type 7: message which indicates fall of the player
	 * type 8: Idle
	 */
	public String Say(int type, Connection con){

		String message = "";

		if(type ==1){

			message = "(say"+" "+MessageCreator.CreateStartMessage()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum(),MessageType.getCommunicationType())==true){
				return message;
			}

		}else if(type == 2){

			message = "(say"+" "+MessageCreator.CreateStartCoordinationMessage()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum(),MessageType.getCommunicationType())==true){
				return message;
			}

			
		}else if(type == 3){
			
			
			
			
			if(ActionMessages.getPlayer()<Constraints.numberPlayers+1){

				if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum(),MessageType.getCommunicationType())==true){
					message = "(say"+" "+MessageCreator.CreateActionMessage(ActionMessages.getPlayer())+")";
					ActionMessages.setPlayer((ActionMessages.getPlayer()+1));
					return message;
				}
				
			}else{
						
				MessageType.setType(2);
				ActionMessages.setPlayer(2);
				MessageType.setCommunicationType(0);				
				
			}


		}else if(type == 4){

			message = "(say"+" "+MessageCreator.CreateCoordinationMessage()+")";

			if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum(),MessageType.getCommunicationType())==true){
				return message;
			}

		}else if(type == 5){

			message = "";


			/*
			 * type 6: this is an administrator message in order to stop agents from sending
			 * coordination messages to him
			 */
		}else if(type == 6){

			if(ActionMessages.getTimeout()==0){

				MessageType.setType(3);
				ActionMessages.setTimeout(Constraints.CoordinationTimeout);

			}else{

				if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum(),MessageType.getCommunicationType())==true){
					ActionMessages.setTimeout((ActionMessages.getTimeout()-1));
					message = "(say"+" "+MessageCreator.CreateEndCoordinationMessage()+")";
					return message;
				}
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