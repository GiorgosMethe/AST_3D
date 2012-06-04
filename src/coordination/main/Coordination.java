/**
 * 
 */
package coordination.main;

import java.util.Vector;

import coordination.action.ActionObject;
import coordination.action.ActionValue;
import coordination.communication.CoordinationMessage;

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
public class Coordination {

	public static void MakeCoordination(
			Vector<CoordinationMessage> coordinationVector) {

		/*
		 * Here is the main coordination function, coordination administrator
		 * calculates the actions which maximize team reward
		 */

		double max = -100;
		int player = 0;
		for (int i = 0; i < coordinationVector.size(); i++) {

			System.out.println(player);
			double value4Goal = ActionValue.Calculate("GoKickBallToGoal",
					coordinationVector.elementAt(i));

			if (value4Goal > max) {
				max = value4Goal;
				player = coordinationVector.elementAt(i).getNumber();
			}

		}

		System.out.println("o " + player + "exei mikroteri value");

		/*
		 * This is the end of coordination function Coordination admin should
		 * have decided action for all field player; now these actions will be
		 * sent to field players
		 */
		ActionTable.CoordinateActions.removeAllElements();
		for (int j = 0; j < coordinationVector.size(); j++) {
			ActionObject ActionObject = null;

			if (coordinationVector.elementAt(j).getNumber() == player) {
				ActionObject = new ActionObject(coordinationVector.elementAt(j)
						.getNumber(), "GoKickBallToGoal", 0, 0, 0);
			} else {
				ActionObject = new ActionObject(coordinationVector.elementAt(j)
						.getNumber(), "", 0, 0, 0);
			}

			ActionTable.CoordinateActions.add(ActionObject);

		}

	}

}
