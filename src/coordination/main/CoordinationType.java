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
package coordination.main;

import perceptor.worldstate.GameState;
import perceptor.worldstate.TeamState;

public class CoordinationType {

	public static String Type;

	public static void AssignCoordinationType() {

		if (TeamState.getTeamSide().equalsIgnoreCase("left")) {

			if (GameState.getGameState().equalsIgnoreCase("BeforeKickOff")) {

				CoordinationType.Type = "PassiveWait";

			} else if (GameState.getGameState().equalsIgnoreCase("PlayOn")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase("Goal_Left")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase("Goal_Right")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase(
					"KickOff_Right")) {

				CoordinationType.Type = "Support";

			} else if (GameState.getGameState()
					.equalsIgnoreCase("KickOff_Left")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase("KickInRight")) {

				CoordinationType.Type = "Support";

			} else if (GameState.getGameState().equalsIgnoreCase("KickInLeft")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase(
					"goal_kick_right")) {

				CoordinationType.Type = "Support";

			} else if (GameState.getGameState().equalsIgnoreCase(
					"goal_kick_left")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase(
					"corner_kick_right")) {

				CoordinationType.Type = "Support";

			} else if (GameState.getGameState().equalsIgnoreCase(
					"corner_kick_left")) {

				CoordinationType.Type = "Active";

			}

		} else {

			if (GameState.getGameState().equalsIgnoreCase("BeforeKickOff")) {

				CoordinationType.Type = "PassiveWait";

			} else if (GameState.getGameState().equalsIgnoreCase("PlayOn")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase("Goal_Left")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase("Goal_Right")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase(
					"KickOff_Right")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState()
					.equalsIgnoreCase("KickOff_Left")) {

				CoordinationType.Type = "Support";

			} else if (GameState.getGameState().equalsIgnoreCase("KickInRight")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase("KickInLeft")) {

				CoordinationType.Type = "Support";

			} else if (GameState.getGameState().equalsIgnoreCase(
					"goal_kick_right")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase(
					"goal_kick_left")) {

				CoordinationType.Type = "Support";

			} else if (GameState.getGameState().equalsIgnoreCase(
					"corner_kick_right")) {

				CoordinationType.Type = "Active";

			} else if (GameState.getGameState().equalsIgnoreCase(
					"corner_kick_left")) {

				CoordinationType.Type = "Support";

			}

		}

	}

}
