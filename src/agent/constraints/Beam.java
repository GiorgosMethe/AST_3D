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
package agent.constraints;

import perceptor.localization.CompleteCoordinate;
import perceptor.localization.Coordinate;
import perceptor.localization.LocalizationFilter;
import perceptor.worldstate.GameState;
import agent.runtime.AgentRuntime;

public class Beam {

	public static String PreviousGameState = "BeforeKickOff";
	public static boolean Beamed = false;

	public static Coordinate playersInitPositions[] = new Coordinate[] {

	new Coordinate(-10.4, 0.0), new Coordinate(-8.5, -3.0),
			new Coordinate(-8.5, 3.0), new Coordinate(-8.5, 0.0),
			new Coordinate(-5, -1.0), new Coordinate(-5, 1.0),
			new Coordinate(-2, -2), new Coordinate(-2, 2),
			new Coordinate(-2, -0.0)

	};

	/*
	 * rcssserver 0.6.6 11 player 30x20 soccer field
	 * 
	 * public static Coordinate playersInitPositions[] = new Coordinate[] {
	 * 
	 * new Coordinate(-10.5, 0.0), new Coordinate(-8.5, -3.0), new
	 * Coordinate(-8.5, 3.0), new Coordinate(-9.0, 0.0), new Coordinate(-6.0,
	 * -1.0), new Coordinate(-6.0, 1.0), new Coordinate(-4.0, -1.0), new
	 * Coordinate(-4.0, 1.0), new Coordinate(-8.5, -3.0)
	 * 
	 * };
	 */

	public static String Init(int number) {

		String beam;
		String beamX = null;
		String beamY = null;
		String beamTheta = null;

		if (number >= 1 && number <= 9) {
			beamX = String.valueOf(playersInitPositions[(number - 1)].X);
			beamY = String.valueOf(playersInitPositions[(number - 1)].Y);
			beamTheta = "0.0";

			CompleteCoordinate a = new CompleteCoordinate(
					playersInitPositions[(number - 1)].X,
					playersInitPositions[(number - 1)].Y, 0);

			for (int i = 0; i < 10; i++) {

				LocalizationFilter.filter(a);

			}

		} else {

		}

		beam = beamX + " " + beamY + " " + beamTheta;

		return beam;
	}

	public static String BeamEffector() {

		String Beam = "";

		if (GameState.getGameState().equalsIgnoreCase("BeforeKickOff")) {

			if (!PreviousGameState.equalsIgnoreCase("BeforeKickOff")) {

				Beam = "(beam " + Init(AgentRuntime.num) + ")";

			}

		} else if (GameState.getGameState().equalsIgnoreCase("PlayOn")) {

			Beamed = false;

		} else if (GameState.getGameState().equalsIgnoreCase("Goal_Left")
				|| GameState.getGameState().equalsIgnoreCase("Goal_Right")) {

			if (!Beamed) {

				Beam = "(beam " + Init(AgentRuntime.num) + ")";
				Beamed = true;

			}

		} else if (GameState.getGameState().equalsIgnoreCase("KickOff_Right")
				|| GameState.getGameState().equalsIgnoreCase("KickOff_Left")) {

		}

		PreviousGameState = GameState.getGameState();

		return Beam;

	}

}
