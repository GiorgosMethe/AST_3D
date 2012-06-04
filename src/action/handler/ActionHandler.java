/**
 * 
 */
package action.handler;

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
public class ActionHandler {

	public static void HandleActionMessage(String actionMessage) {

		String[] splittedMsg = actionMessage.split(",");

		System.out.println("eimai o " + splittedMsg[1]);
		System.out.println("kai 8a kanw "
				+ ActionTranslator.FromIDToAction(Integer
						.parseInt(splittedMsg[2])));

	}

}
