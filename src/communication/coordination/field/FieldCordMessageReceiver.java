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

package communication.coordination.field;

import action.handler.ActionHandler;
import agent.AgentType;
import agent.Constraints;
import communication.utils.MessageType;
import connection.utils.ServerCyrcles;


public class FieldCordMessageReceiver {

	public static void MessageHandler(String msg) {

		if (msg.startsWith("s,")) {

			StartMsgHandler(msg);

		} else if (msg.startsWith("e,")) {

			EndMsgHandler(msg);

		} else if (msg.startsWith("a,")) {

			ActionMsgHandler(msg);

		} else {

		}

	}

	private static void StartMsgHandler(String msg) {

		String[] splittedMsg = msg.split(",");

		int flag = Constraints.CoordinationPlayer;
		boolean result = flag == (Integer.parseInt(splittedMsg[1]));

		if (result) {

			MessageType.setType(4);

		}

	}

	private static void EndMsgHandler(String msg) {

		MessageType.setType(8);
		
	}

	private static void ActionMsgHandler(String msg) {

		String[] splittedMsg = msg.split(",");

		int flag = AgentType.getPlayerNum();
		boolean me = flag == (Integer.parseInt(splittedMsg[1]));

		if (me) {

			ActionHandler.HandleActionMessage(msg);

		}

	}

}
