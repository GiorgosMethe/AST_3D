/**
 * 
 */
package communication.handler;

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
public class MessageType {
	
	/*
	 * This class holds the type of message
	 * a player should send in the next server cycle
	 * type 1: start coordination message
	 * type 2: admin message to field player to start sending coordination messages
	 * type 3: coordination message 
	 * type 4: stop coordination message
	 * type 5: only for coordination admin, he sends the actions to each agent
	 * in order to maximize the team's payoff value
	 * 
	 */
	
	
	public static int type;

	public static int getType() {
		return type;
	}

	public static void setType(int type) {
		MessageType.type = type;
	}
	
	

}
