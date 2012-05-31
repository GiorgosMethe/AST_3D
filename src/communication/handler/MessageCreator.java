/**
 * 
 */
package communication.handler;

import perceptor.vision.Ball;
import localization.LocalizationResults;
import agent.AgentType;

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
public class MessageCreator {


	public static String CreateStartMessage(){


		String message = "";
		message = "i"+","+AgentType.PlayerNum;

		return message;
	}

	public static String CreateStartCoordinationMessage1(){

		String message = "";
		message = "s1"+","+AgentType.PlayerNum;

		return message;
	}

	public static String CreateStartCoordinationMessage2(){

		String message = "";
		message = "s2"+","+AgentType.PlayerNum;

		return message;
	}

	public static String CreateEndCoordinationMessage(){

		String message = "";
		message = "e"+","+AgentType.PlayerNum;

		return message;
	}

	public static String CreateCoordinationMessage1(){

		String message = "";
		String type  = "c1"+",";

		message += type + Integer.toString(AgentType.getPlayerNum())+",";

		message += Integer.toString((int) Math.rint(LocalizationResults.getCurrent_location().X))+",";
		message += Integer.toString((int) Math.rint(LocalizationResults.getCurrent_location().Y))+",";

		message += Integer.toString((int) Math.rint(LocalizationResults.getBall_location().X))+",";
		message += Integer.toString((int) Math.rint(LocalizationResults.getBall_location().Y));


		return message;

	}

	public static String CreateCoordinationMessage2(){

		String message = "";
		String type  = "c2"+",";

		message += type + Integer.toString(AgentType.getPlayerNum())+",";

		message += Integer.toString((int) Math.rint(Ball.getDistance()))+",";
		message += Integer.toString((int) Math.rint(Ball.getAngleX()))+",";

		message += Integer.toString((int) Math.rint(LocalizationResults.getBody_angle()));


		return message;

	}

}
