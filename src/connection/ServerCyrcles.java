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
package connection;
public class ServerCyrcles {
	
	
	static int Cyrcles=0;
	static int GameCyrcles=0;
	
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
