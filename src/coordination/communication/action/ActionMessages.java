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
package coordination.communication.action;

public class ActionMessages {

	public static int timeout;

	public static int player;

	public static int getTimeout() {
		return timeout;
	}

	public static void setTimeout(int timeout) {
		ActionMessages.timeout = timeout;
	}

	public static int getPlayer() {
		return player;
	}

	public static void setPlayer(int player) {
		ActionMessages.player = player;
	}

}
