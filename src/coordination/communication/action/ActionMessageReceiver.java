/**
 * 
 */
package coordination.communication.action;

import action.handler.ActionHandler;
import coordination.action.ActionObject;
import coordination.action.ActionTranslator;

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
public class ActionMessageReceiver {

	public static void HandleActionMessage(String actionMessage) {

		String[] splittedMsg = actionMessage.split(",");
		ActionObject Action = null;

		if (splittedMsg.length > 2) {

			if (splittedMsg[2] != null) {

				String action = ActionTranslator.FromIDToAction(Integer
						.parseInt(splittedMsg[2]));

				if (action.equalsIgnoreCase("GoKickBallToGoal")) {

					Action = new ActionObject(Integer.parseInt(splittedMsg[1]),
							action, 0, 0, 0, 0);

				} else if (action.equalsIgnoreCase("WalkToCoordinate")) {

					Action = new ActionObject(Integer.parseInt(splittedMsg[1]),
							action, Double.parseDouble(splittedMsg[3]),
							Double.parseDouble(splittedMsg[4]), 0, 0);

				}

			}

			ActionHandler.Handle(Action);

		}
	}

}
