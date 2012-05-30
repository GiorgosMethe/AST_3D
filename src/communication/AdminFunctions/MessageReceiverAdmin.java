/**
 * 
 */
package communication.AdminFunctions;

import communication.AdminFunctions.MessageBuffer;
import communication.coordination.CoordinationMessageBuffer;
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
public class MessageReceiverAdmin {
	
	
	/*
	 * Method which handles the messages an admin agent hears
	 * 
	 */
	public static void MessageHandlerAdmin(String msg){
		
		
		if(msg.startsWith("i,")){
			
			InitReceiver(msg);
			
		}else if(msg.startsWith("c1,")){
			
			CoordinationReceiver1(msg);
			
		}else if(msg.startsWith("c2,")){
			
			CoordinationReceiver2(msg);
			
		}else{
			
			System.out.println("message from opponents");
			
		}
			
			
		
		
	}
	
	public static void CoordinationReceiver1(String msg){
		
		String[] splittedMsg = msg.split(",");
		
		boolean result = CoordinationMessageBuffer.CoordinationReceiver1(Integer.parseInt(splittedMsg[1]),msg);
		
		if(result){
			
			MessageType.setType(3);
			
		}
		
	}
	
	public static void CoordinationReceiver2(String msg){
		
		String[] splittedMsg = msg.split(",");
		
		boolean result = CoordinationMessageBuffer.CoordinationReceiver2(Integer.parseInt(splittedMsg[1]),msg);
		
		if(result){
			
			MessageType.setType(6);
			
		}
		
	}
	

	public static void InitReceiver(String msg){
		
		String[] splittedMsg = msg.split(",");
		
		boolean result = MessageBuffer.addInit(Integer.parseInt(splittedMsg[1]));
		
		if(result){
			
			MessageType.setType(2);
			
		}
		
	}
	

}
