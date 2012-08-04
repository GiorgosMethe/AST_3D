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
package coordination.communication.admin;

import communication.utils.MessageType;

public class AdminCordMessageReceiver {

	public static void MessageHandler(String msg) {
		
		System.out.println("message "+msg);

		if (msg.startsWith("i,")) {

			InitReceiver(msg);

		} else if ((msg.startsWith("c,")) || (msg.startsWith("l,"))
				|| (msg.startsWith("b,")) || (msg.startsWith("x,"))) {

			CoordinationReceiver(msg);

		} else {

		}

	}

	public static void InitReceiver(String msg) {

		String[] splittedMsg = msg.split(",");

		boolean result = AdminMessageBuffer.addInit(Integer
				.parseInt(splittedMsg[1]));

		if (result) {

			System.out.println("phra ta init messages");
			MessageType.setType(2);

		}

	}

	public static void CoordinationReceiver(String msg) {

		String[] splittedMsg = msg.split(",");

		boolean result = AdminMessageBuffer.addC(
				Integer.parseInt(splittedMsg[1]), msg);

		if (result) {

			System.out.println("phra ta coord messages");

			// coordination end message
			MessageType.setType(6);

			// from now on, only admin can send messages
			MessageType.setCommunicationType(1);

		}

	}

}
