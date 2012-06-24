/***********************************************************************************
 * Technical University of Crete Academic Year 2011-2012
 * 
 * Thesis Project
 * 
 * @author Methenitis Georgios Student ID:2006030085
 * 
 *         Abstract: Player Behavior and Team Strategy for the RoboCup 3D
 *         Simulation League Start date: 25-04-2012 End date : xx-xx-2012
 ***********************************************************************************/
package action.handler;

import coordination.action.ActionObject;

public class ActionPlaying {

	public static ActionObject ActionPlaying;

	public static ActionObject getActionPlaying() {
		return ActionPlaying;
	}

	public static void setActionPlaying(ActionObject actionPlaying) {
		ActionPlaying = actionPlaying;
	}

}
