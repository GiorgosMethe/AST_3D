/**
 * 
 */
package communication.utils;

import perceptor.localization.LocalizationResults;
import perceptor.vision.Ball;
import agent.values.AgentType;
import coordination.action.ActionTable;
import coordination.action.ActionTranslator;

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
		String type = "";

		// agent know his position and the ball position
		if (!Double.isNaN(LocalizationResults.getBall_location().X)
				&& !Double.isNaN(LocalizationResults.getBall_location().Y)
				&& !Double.isNaN(LocalizationResults.getCurrent_location().X)
				&& !Double.isNaN(LocalizationResults.getCurrent_location().Y)) {

			type = "c" + ",";

			// player number
			message += type + Integer.toString(AgentType.getPlayerNum()) + ",";

			// player position
			message += Integer.toString((int) Math.rint(LocalizationResults
					.getCurrent_location().X)) + ",";
			message += Integer.toString((int) Math.rint(LocalizationResults
					.getCurrent_location().Y)) + ",";

			// ball position
			message += Integer.toString((int) Math.rint(LocalizationResults
					.getBall_location().X)) + ",";
			message += Integer.toString((int) Math.rint(LocalizationResults
					.getBall_location().Y));

			// agent only see the ball
		} else if (Ball.isSeeTheBall()) {

			type = "b" + ",";

			// player number
			message += type + Integer.toString(AgentType.getPlayerNum()) + ",";

			// player position
			message += Integer.toString((int) Math.rint(LocalizationResults
					.getCurrent_location().X)) + ",";
			message += Integer.toString((int) Math.rint(LocalizationResults
					.getCurrent_location().Y)) + ",";

			// ball position
			message += Integer.toString((int) Math.rint(Ball.getDistance()))
					+ ",";
			message += Integer.toString((int) Math.rint(Ball.getAngleX()));

			// agent has complete unawareness of his environment
		} else {

			type = "x" + ",";

			// player number
			message += type + Integer.toString(AgentType.getPlayerNum());

		}

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

		// player number
		message += String.valueOf(player) + ",";

		for (int i = 0; i < ActionTable.CoordinateActions.size(); i++) {

			if (ActionTable.CoordinateActions.elementAt(i).number == player) {

				String ActionName = ActionTable.CoordinateActions.elementAt(i).action;
				int type = ActionTranslator.FromActionToID(ActionName);

				// action id
				message += type + ",";

				double p1 = ActionTable.CoordinateActions.elementAt(i).parametres1;
				double p2 = ActionTable.CoordinateActions.elementAt(i).parametres1;

				String ps1 = String.valueOf((int) Math.rint(p1));
				String ps2 = String.valueOf((int) Math.rint(p2));

				// parameters
				message += ps1 + "," + ps2;

			}
		}

		return message;

	}

}
