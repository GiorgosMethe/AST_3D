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
package coordination.action;

public class ActionTranslator {

	public static String FromIDToAction(int type) {

		String Action = "";

		if (type == 0) {

			Action = "";

		} else if (type == 1) {

			Action = "GoKickBallToGoal";

		} else if (type == 2) {

			Action = "ClearBall";

		} else if (type == 3) {

			Action = "WalkToDirection";

		} else if (type == 4) {

			Action = "WalkToCoordinate";

		} else if (type == 5) {

			Action = "TurnToLocate";

		} else {

			Action = "";

		}

		return Action;

	}

	public static int FromActionToID(String name) {

		int type = 0;

		if (name.equalsIgnoreCase("GoKickBallToGoal")) {

			type = 1;

		} else if (name.equalsIgnoreCase("ClearBall")) {

			type = 2;

		} else if (name.equalsIgnoreCase("WalkToDirection")) {

			type = 3;

		} else if (name.equalsIgnoreCase("WalkToCoordinate")) {

			type = 4;

		} else if (name.equalsIgnoreCase("TurnToLocate")) {

			type = 5;

		} else {

		}

		return type;

	}
}
