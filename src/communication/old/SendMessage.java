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
package communication.old;


import perceptor.vision.Ball;
import worldState.TeamState;
import agent.AgentType;
import behavior.old.BehaviorStateMachine;
import connection.Connection;
public class SendMessage {
	
	public void Say(String type, Connection con){
		
		String message="";
		String coderMessage="";
		
		if(type.equalsIgnoreCase("distance")){
			coderMessage=DistanceMessageCoder();
		}
		message = "(say"+" "+coderMessage+")";
		
		if(MessagePerCycle.PerNumCircles(AgentType.getPlayerNum())==true){
			con.sendMessage(message);
		}
		
	}
	
	public String DistanceMessageCoder(){
		String message="";
		
		if(BehaviorStateMachine.getName().equalsIgnoreCase("Fallen")){
			Ball.setDistance(100);
		}
		message="d%"+TeamState.getTeamSide()+"%"+Integer.toString(AgentType.getPlayerNum())+"%"+Float.toString(Ball.getDistance());
		
		
		return message;
		
	}
	
}