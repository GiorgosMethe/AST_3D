/**
 * 
 */
package coordination.communication;

import java.util.Vector;

import coordination.main.Coordination;

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
public class CoordinationMessageUpdate {

	public static void update(Vector<String> CoordinationMessage) {

		Vector<CoordinationMessage> CoordinationVector = new Vector<CoordinationMessage>();

		int number = 0;
		int playerX = 0, playerY = 0;
		int ballDistance = 0, ballTheta = 0;

		for (int i = 0; i < CoordinationMessage.size(); i++) {

			String[] cmarray = CoordinationMessage.elementAt(i).split(",");

			try {

				number = Integer.parseInt(cmarray[1]);

				playerX = Integer.parseInt(cmarray[2]);
				playerY = Integer.parseInt(cmarray[3]);

				ballDistance = Integer.parseInt(cmarray[4]);
				ballTheta = Integer.parseInt(cmarray[5]);

			} catch (Exception e) {
				System.err.println("error in coordination message update");
			}

			CoordinationMessage cm = new CoordinationMessage(number, playerX,
					playerY, ballDistance, ballTheta);
			CoordinationVector.addElement(cm);

		}

		Coordination.MakeCoordination(CoordinationVector);

	}

}
