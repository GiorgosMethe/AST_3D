/**
 * 
 */
package communication.coordination.field;

import agent.Constraints;

import communication.handler.MessageType;

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
public class FieldCordMessageReceiver {
	
	
	public static void MessageHandler(String msg){


		if(msg.startsWith("s1,")){

			StartReceiver1(msg);

		}else if(msg.startsWith("s2,")){

			StartReceiver2(msg);

		}else if(msg.startsWith("e,")){

			StartReceiverEnd(msg);

		}else{

			

		}

	}


	public static void StartReceiver1(String msg){

		String[] splittedMsg = msg.split(",");

		int flag = Constraints.CoordinationPlayer;
		boolean result = flag==(Integer.parseInt(splittedMsg[1]));

		if(result){

			MessageType.setType(4);

		}

	}
	
	public static void StartReceiverEnd(String msg){

		String[] splittedMsg = msg.split(",");

		int flag = Constraints.CoordinationPlayer;
		boolean result = flag==(Integer.parseInt(splittedMsg[1]));

		if(result){

			MessageType.setType(8);

		}

	}
	
	public static void StartReceiver2(String msg){

		String[] splittedMsg = msg.split(",");

		int flag = Constraints.CoordinationPlayer;
		boolean result = flag==(Integer.parseInt(splittedMsg[1]));

		if(result){

			MessageType.setType(5);

		}

	}
	
	
	
	
	
	
	
	
	

}
