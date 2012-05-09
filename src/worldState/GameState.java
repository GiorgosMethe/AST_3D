/***********************************************************************************
 * 				  Copyright 2012, Technical University of Crete				       *
 * 							 Academic Year 2011-2012					           *
 ***********************************************************************************
 * 								Thesis Project								       *
 ***********************************************************************************
 * @author Methenitis Georgios													   *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League*
 * Start date: 25-04-2012														   *																	 
 * End date  : xx-xx-2012														   *																			   *
 ***********************************************************************************/
package worldState;

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
