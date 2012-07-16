package coordination.communication.action;

import action.handler.ActionHandler;
import coordination.action.ActionObject;
import coordination.action.ActionTranslator;

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
							action, Double.parseDouble(splittedMsg[3]),
							Double.parseDouble(splittedMsg[4]), 0, 0);

				} else if (action.equalsIgnoreCase("WalkToCoordinate")) {

					Action = new ActionObject(Integer.parseInt(splittedMsg[1]),
							action, Double.parseDouble(splittedMsg[3]),
							Double.parseDouble(splittedMsg[4]),
							Double.parseDouble(splittedMsg[5]), 0);

				}

			} else {

				Action = null;

			}

			ActionHandler.Handle(Action);

		}
	}

}
