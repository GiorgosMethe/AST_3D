/**
 * 
 */
package communication.coordination.admin;

import communication.utils.MessageType;

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
public class AdminCordMessageReceiver {

	public static void MessageHandler(String msg) {

		if (msg.startsWith("i,")) {

			InitReceiver(msg);

		} else if (msg.startsWith("c,")) {

			CoordinationReceiver(msg);

		} else {

		}

	}

	public static void InitReceiver(String msg) {

		String[] splittedMsg = msg.split(",");

		boolean result = AdminMessageBuffer.addInit(Integer
				.parseInt(splittedMsg[1]));

		if (result) {

			MessageType.setType(2);

		}

	}

	public static void CoordinationReceiver(String msg) {

		String[] splittedMsg = msg.split(",");

		boolean result = AdminMessageBuffer.addC(
				Integer.parseInt(splittedMsg[1]), msg);

		if (result) {

			// coordination end message
			MessageType.setType(6);

			// from now on, only admin can send messages
			MessageType.setCommunicationType(1);

		}

	}

}
