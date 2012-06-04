/**
 * 
 */
package coordination.communication;

/***********************************************************************************
 * Copyright 2012, Technical University of Crete Academic Year 2011-2012
 * 
 * Thesis Project
 * 
 * @author Methenitis Georgios Student ID:2006030085
 * 
 *         Abstract: Player Behavior and Team Strategy for the RoboCup 3D
 *         Simulation League Start date: 25-04-2012 End date : xx-xx-2012
 ***********************************************************************************/
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
