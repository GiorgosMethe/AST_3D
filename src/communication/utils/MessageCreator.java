/**
 * 
 */
package communication.utils;

import localization.LocalizationResults;
import perceptor.vision.Ball;
import agent.AgentType;
import coordination.action.ActionTranslator;
import coordination.main.ActionTable;

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
public class MessageCreator {

	public static String CreateStartMessage() {

		String message = "";
		message = "i" + "," + AgentType.PlayerNum;

		return message;
	}

	public static String CreateStartCoordinationMessage() {

		String message = "";
		message = "s" + "," + AgentType.PlayerNum;

		return message;
	}

	public static String CreateEndCoordinationMessage() {

		String message = "";
		message = "e" + "," + AgentType.PlayerNum;

		return message;
	}

	public static String CreateCoordinationMessage() {

		String message = "";
		String type = "c" + ",";

		message += type + Integer.toString(AgentType.getPlayerNum()) + ",";

		message += Integer.toString((int) Math.rint(LocalizationResults
				.getCurrent_location().X)) + ",";
		message += Integer.toString((int) Math.rint(LocalizationResults
				.getCurrent_location().Y)) + ",";

		message += Integer.toString((int) Math.rint(Ball.getDistance())) + ",";
		message += Integer.toString((int) Math.rint(Ball.getAngleX()));

		return message;

	}

	/*
	 * this function helps admin to send the selected actions to each agent
	 * 
	 * @player admin wants to create the action message for this player
	 */
	public static String CreateActionMessage(int player) {

		String message = "";
		message += "a" + ",";

		for (int i = 0; i < ActionTable.CoordinateActions.size(); i++) {

			if (ActionTable.CoordinateActions.elementAt(i).number == player) {

				// player number
				message += String.valueOf(player) + ",";

				String ActionName = ActionTable.CoordinateActions.elementAt(i).action;
				int type = ActionTranslator.FromActionToID(ActionName);

				// action id
				message += type + ",";

				double p1 = ActionTable.CoordinateActions.elementAt(i).parametres1;
				double p2 = ActionTable.CoordinateActions.elementAt(i).parametres1;
				double p3 = ActionTable.CoordinateActions.elementAt(i).parametres1;

				String ps1 = String.valueOf((int) Math.rint(p1));
				String ps2 = String.valueOf((int) Math.rint(p2));
				String ps3 = String.valueOf((int) Math.rint(p3));

				// parameters
				message += ps1 + "," + ps2 + "," + ps3;

			}
		}

		return message;

	}

}
