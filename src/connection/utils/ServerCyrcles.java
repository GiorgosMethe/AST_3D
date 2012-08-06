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
package connection.utils;

public class ServerCyrcles {

	static int Cyrcles = 0;
	static int GameCyrcles = 0;
	public static float ServerStep = 20.0f;

	public static long a = 0, b = 0, Counter = 0, Sum = 0;

	public static int getCyrclesNow() {
		return Cyrcles;
	}

	public static void setCyrclesNow(int cyrcles) {

		Cyrcles = cyrcles;

	}

	public static int getGameCyrcles() {
		return GameCyrcles;
	}

	public static void setGameCyrcles(int gameCyrcles) {

		GameCyrcles = gameCyrcles;

	}

}
