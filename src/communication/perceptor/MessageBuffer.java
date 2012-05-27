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
package communication.perceptor;

import communication.effector.HearMessage;

import worldState.TeamState;


public class MessageBuffer {

	public static float[] DistancesBuffer =new float[8];


	@SuppressWarnings("static-access")
	public static void UpdateBuffer(HearMessage msg){
	
		if(!msg.getMsg().equalsIgnoreCase("")){
			String[] splittedMsg = msg.getMsg().split("%");
			if(splittedMsg[1].equalsIgnoreCase(TeamState.getTeamSide())){
				
				DistancesBuffer[Integer.parseInt(splittedMsg[2])]=Float.parseFloat(splittedMsg[3]);

			}
		}

	}


	public static float[] getDistancesBuffer() {
		return DistancesBuffer;
	}


	public static void setDistancesBuffer(float[] distancesBuffer) {
		DistancesBuffer = distancesBuffer;
	}




}
