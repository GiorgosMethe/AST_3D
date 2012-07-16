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
package agent.type;

public class AgentType {

	public static String PlayerPos;
	public static int PlayerNum;

	public static String getPlayerPos() {
		return PlayerPos;
	}

	public static void setPlayerPos(String playerPos) {
		PlayerPos = playerPos;
	}

	public static int getPlayerNum() {
		return PlayerNum;
	}

	public static void setPlayerNum(int playerNum) {
		PlayerNum = playerNum;
	}

}
