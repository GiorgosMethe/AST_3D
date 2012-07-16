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
package communication.utils;

import agent.constraints.Constraints;
import agent.type.AgentType;
import coordination.action.ActionTable;
import coordination.communication.action.ActionMessages;

public class SayEffector {

	/*
	 * Class creates the communication message of the agents. There are several
	 * types of messages
	 * 
	 * type 1: starts the communication between the players type 2: (admin)
	 * sends to start coordination message 1 type 3: (admin) sends back action
	 * messages type 4: coordination message type 5: empty type 6: (admin) sends
	 * to stop coordination messages type 7: message which indicates fall of the
	 * player type 8: Idle
	 */
	public static String Say(int type) {

		String message = "";

		if (type == 1) {

			message = "(say" + " " + MessageCreator.CreateStartMessage() + ")";

			if (MessagePerCycle.PerNumCircles(AgentType.getPlayerNum(),
					MessageType.getCommunicationType()) == true) {
				return message;
			}

		} else if (type == 2) {

			message = "(say" + " "
					+ MessageCreator.CreateStartCoordinationMessage() + ")";

			if (MessagePerCycle.PerNumCircles(AgentType.getPlayerNum(),
					MessageType.getCommunicationType()) == true) {
				return message;
			}

		} else if (type == 3) {

			if (ActionMessages.getPlayer() < ActionTable.CoordinateActions
					.size()) {

				if (MessagePerCycle.PerNumCircles(AgentType.getPlayerNum(),
						MessageType.getCommunicationType()) == true) {
					message = "(say"
							+ " "
							+ MessageCreator.CreateActionMessage(ActionMessages
									.getPlayer()) + ")";
					ActionMessages.setPlayer((ActionMessages.getPlayer() + 1));
					return message;
				}

			} else {

				ActionTable.CoordinateActions.removeAllElements();
				MessageType.setType(2);
				ActionMessages.setPlayer(0);
				MessageType.setCommunicationType(0);

			}

		} else if (type == 4) {

			message = "(say" + " " + MessageCreator.CreateCoordinationMessage()
					+ ")";

			if (MessagePerCycle.PerNumCircles(AgentType.getPlayerNum(),
					MessageType.getCommunicationType()) == true) {

				return message;
			}

		} else if (type == 5) {

			message = "";

			/*
			 * type 6: this is an administrator message in order to stop agents
			 * from sending coordination messages to him
			 */
		} else if (type == 6) {

			if (ActionMessages.getTimeout() == 0) {

				MessageType.setType(3);
				ActionMessages.setTimeout(Constraints.CoordinationTimeout);

			} else {

				if (MessagePerCycle.PerNumCircles(AgentType.getPlayerNum(),
						MessageType.getCommunicationType()) == true) {
					ActionMessages
							.setTimeout((ActionMessages.getTimeout() - 1));
					message = "(say" + " "
							+ MessageCreator.CreateEndCoordinationMessage()
							+ ")";
					return message;
				}
			}

		} else if (type == 7) {

			message = "";
			/*
			 * 
			 * 
			 * needs something
			 */

		} else if (type == 8) {

			message = "";

		} else {

			System.err.println("invalid message type");
			System.exit(1);

		}

		return "";

	}

}
