/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/
package communication.utils;

import agent.constraints.Constraints;
import agent.values.AgentType;
import connection.utils.ServerCyrcles;

public class MessagePerCycle {

	/*
	 * @number, who tries to send
	 * 
	 * @type, who can send, type 0 for all players, type 1 only for admin
	 */
	public static boolean PerNumCircles(int number, int type) {

		int MaxNum = Constraints.numberPlayers;

		if (MessageType.getCommunicationType() == 1) {

			if (ServerCyrcles.getGameCyrcles() % 2 == 0) {

				if (AgentType.getPlayerNum() == Constraints.CoordinationPlayer) {

					return true;

				} else {

					return false;

				}

			}

			return false;

		} else {

			if (ServerCyrcles.getGameCyrcles() % 10 == 0) {

				if (WhoSent.getCounter() > MaxNum - 1) {
					WhoSent.setCounter(1);
				} else {
					WhoSent.setCounter((WhoSent.getCounter() + 1));
				}

				if (AgentType.getPlayerNum() == WhoSent.getCounter()) {
					return true;
				} else {
					return false;
				}
			} else {

				return false;
			}

		}

	}
}