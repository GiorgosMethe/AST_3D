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
package perceptor.worldstate;

public class GameState {

	public static float gameTime;
	public static String gameState;

	public GameState(float gameTime, String gameState) {

		gameTime = GameState.gameTime;
		gameState = GameState.gameState;

	}

	public static float getGameTime() {
		return gameTime;
	}

	public static void setGameTime(float gameTime) {
		GameState.gameTime = gameTime;
	}

	public static String getGameState() {
		return gameState;
	}

	public static void setGameState(String gameState) {
		GameState.gameState = gameState;
	}

}
