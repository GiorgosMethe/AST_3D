/**
 * 
 */
package communication.utils;

/***********************************************************************************
 * Copyright 2012, Technical University of Crete Academic Year 2011-2012
 * 
 * Thesis Project
 * 
 * @author Methenitis Georgios Student ID:2006030085
 * 
 *         Abstract: Player Behavior and Team Strategy for the RoboCup 3D
 *         Simulation League Start date: 25-04-2012 End date : xx-xx-2012
 ***********************************************************************************/
public class MessageType {

	/*
	 * This class holds the type of message a player should send in the next
	 * server cycle type 1: starts the communication between the players type 2:
	 * admin sends to start coordination message 1 type 3: admin sends to start
	 * coordination message 2 type 4: coordination message 1 type 5:
	 * coordination message 2 type 6: stop coordination messages type 7: message
	 * which indicates fall of the player type 8: Idle
	 */

	public static int type;
	public static int communicationType;

	public static int getCommunicationType() {
		return communicationType;
	}

	public static void setCommunicationType(int communicationType) {
		MessageType.communicationType = communicationType;
	}

	public static int getType() {
		return type;
	}

	public static void setType(int type) {
		MessageType.type = type;
	}

}
