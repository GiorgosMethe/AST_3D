package coordination.main;

import perceptor.worldstate.GameState;
import perceptor.worldstate.TeamState;

public class CoordinationType {

	public static void AssignCoordinationType() {

		if (TeamState.getTeamSide().equalsIgnoreCase("left")) {

			if (GameState.getGameState().equalsIgnoreCase("BeforeKickOff")) {

			} else if (GameState.getGameState().equalsIgnoreCase("PlayOn")) {

			} else if (GameState.getGameState().equalsIgnoreCase("Goal_Left")) {

			} else if (GameState.getGameState().equalsIgnoreCase("Goal_Right")) {

			} else if (GameState.getGameState().equalsIgnoreCase(
					"KickOff_Right")) {

			} else if (GameState.getGameState()
					.equalsIgnoreCase("KickOff_Left")) {

			} else if (GameState.getGameState().equalsIgnoreCase("KickInRight")) {

			} else if (GameState.getGameState().equalsIgnoreCase("KickInLeft")) {

			} else if (GameState.getGameState().equalsIgnoreCase(
					"goal_kick_right")) {

			} else if (GameState.getGameState().equalsIgnoreCase(
					"goal_kick_left")) {

			} else if (GameState.getGameState().equalsIgnoreCase(
					"corner_kick_right")) {

			} else if (GameState.getGameState().equalsIgnoreCase(
					"corner_kick_left")) {

			}

		} else {

			if (GameState.getGameState().equalsIgnoreCase("BeforeKickOff")) {

			} else if (GameState.getGameState().equalsIgnoreCase("PlayOn")) {

			} else if (GameState.getGameState().equalsIgnoreCase("Goal_Left")) {

			} else if (GameState.getGameState().equalsIgnoreCase("Goal_Right")) {

			} else if (GameState.getGameState().equalsIgnoreCase(
					"KickOff_Right")) {

			} else if (GameState.getGameState()
					.equalsIgnoreCase("KickOff_Left")) {

			} else if (GameState.getGameState().equalsIgnoreCase("KickInRight")) {

			} else if (GameState.getGameState().equalsIgnoreCase("KickInLeft")) {

			} else if (GameState.getGameState().equalsIgnoreCase(
					"goal_kick_right")) {

			} else if (GameState.getGameState().equalsIgnoreCase(
					"goal_kick_left")) {

			} else if (GameState.getGameState().equalsIgnoreCase(
					"corner_kick_right")) {

			} else if (GameState.getGameState().equalsIgnoreCase(
					"corner_kick_left")) {

			}

		}

	}

}
