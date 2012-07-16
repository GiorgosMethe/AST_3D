/*******************************************************************************
 * Technical University of Crete
 * 
 * Thesis Project
 * 
 * Author:	Methenitis K. Georgios
 * 
 * Abstract  : Player Behavior and Team Strategy 
 * 			for the RoboCup 3D Simulation League
 * 
 * Date:  		July 2012
 ******************************************************************************/
package communication.utils;

import perceptor.localization.BallLocalizationFilter;
import perceptor.localization.LocalizationFilter;
import perceptor.vision.Ball;
import action.sensor.CheckIfFall;
import agent.type.AgentType;
import coordination.action.ActionTable;
import coordination.action.ActionTranslator;

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

		if (!CheckIfFall.fallen) {

			// agent know his position and the ball position
			if (LocalizationFilter.qe.size() >= 5
					&& BallLocalizationFilter.qe.size() >= 5) {

				type = "c" + ",";

				// player number
				message += type + Integer.toString(AgentType.getPlayerNum())
						+ ",";

				// player position
				message += Integer.toString((int) Math
						.rint(LocalizationFilter.MyPosition.getX())) + ",";
				message += Integer.toString((int) Math
						.rint(LocalizationFilter.MyPosition.getY())) + ",";

				// ball position elements
				message += Integer.toString((int) Math
						.rint(BallLocalizationFilter.MyFilteredBallPosition
								.getX()))
						+ ",";
				message += Integer.toString((int) Math
						.rint(BallLocalizationFilter.MyFilteredBallPosition
								.getY()));

				// agent only see the ball
			} else if (LocalizationFilter.qe.size() >= 5
					&& BallLocalizationFilter.qe.size() <= 5
					&& !Ball.isSeeTheBall()) {

				type = "l" + ",";

				// player number
				message += type + Integer.toString(AgentType.getPlayerNum())
						+ ",";

				// player position
				message += Integer.toString((int) Math
						.rint(LocalizationFilter.MyPosition.getX())) + ",";
				message += Integer.toString((int) Math
						.rint(LocalizationFilter.MyPosition.getY()));

			} else if (LocalizationFilter.qe.size() <= 5 && Ball.isSeeTheBall()) {

				type = "b" + ",";

				// player number
				message += type + Integer.toString(AgentType.getPlayerNum())
						+ ",";

				// ball position elements
				message += Integer.toString((int) Math.rint(Ball.getAngleX()))
						+ ",";
				message += Integer
						.toString((int) Math.rint(Ball.getDistance()));

				// agent has complete unawareness of his environment
			} else if (LocalizationFilter.qe.size() <= 5
					&& !Ball.isSeeTheBall()) {

				type = "x" + ",";

				// player number
				message += type + Integer.toString(AgentType.getPlayerNum());

			}

		} else {

			/*
			 * Agent probably is fallen down. He is going to send error messages
			 * in order coordination admin not to include him in coordination
			 */
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
	// public static String CreateActionMessage(int player) {
	//
	// String message = "";
	// message += "a" + ",";
	//
	// // player number
	// message += String.valueOf(player) + ",";
	//
	// for (int i = 0; i < ActionTable.CoordinateActions.size(); i++) {
	//
	// if (ActionTable.CoordinateActions.elementAt(i).number == player) {
	//
	// String ActionName = ActionTable.CoordinateActions.elementAt(i).action;
	// int type = ActionTranslator.FromActionToID(ActionName);
	//
	// // action id
	// message += type + ",";
	//
	// double p1 = ActionTable.CoordinateActions.elementAt(i).parametres1;
	// double p2 = ActionTable.CoordinateActions.elementAt(i).parametres2;
	// double p3 = ActionTable.CoordinateActions.elementAt(i).parametres3;
	//
	// String ps1 = String.valueOf((int) Math.rint(p1));
	// String ps2 = String.valueOf((int) Math.rint(p2));
	// String ps3 = String.valueOf((int) Math.rint(p3));
	//
	// // parameters
	// message += ps1 + "," + ps2 + "," + ps3;
	// System.out.println("--msg: "+message);
	//
	// }
	// }
	//
	// return message;
	//
	// }

	public static String CreateActionMessage(int player) {

		String message = "";
		message += "a" + ",";

		// player number
		message += String.valueOf(ActionTable.CoordinateActions
				.elementAt(player).number) + ",";

		String ActionName = ActionTable.CoordinateActions.elementAt(player).action;
		int type = ActionTranslator.FromActionToID(ActionName);

		// action id
		message += type + ",";

		double p1 = ActionTable.CoordinateActions.elementAt(player).parametres1;
		double p2 = ActionTable.CoordinateActions.elementAt(player).parametres2;
		double p3 = ActionTable.CoordinateActions.elementAt(player).parametres3;

		String ps1 = String.valueOf((int) Math.rint(p1));
		String ps2 = String.valueOf((int) Math.rint(p2));
		String ps3 = String.valueOf((int) Math.rint(p3));

		// parameters
		message += ps1 + "," + ps2 + "," + ps3;

		System.out.println("--msg: " + message);

		return message;

	}

}
