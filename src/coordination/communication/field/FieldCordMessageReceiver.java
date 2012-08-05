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
package coordination.communication.field;

import perceptor.worldstate.GameState;
import agent.constraints.Constraints;
import agent.type.AgentType;

import communication.utils.MessageType;
import connection.utils.ServerCyrcles;

import coordination.communication.action.ActionMessageReceiver;

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
		boolean me = (flag == (Integer.parseInt(splittedMsg[1])));

		if (me) {

			ActionMessageReceiver.HandleActionMessage(msg);

		}

	}

}
