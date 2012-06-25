/**
 * 
 */
package coordination.communication.message;

import java.util.Vector;

import perceptor.localization.Coordinate;
import coordination.main.CoordinationRun;

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

	public static Vector<CoordinationMessage> CoordinationVector = new Vector<CoordinationMessage>();

	public static void update(Vector<String> CoordinationMessage) {

		int type = 0;
		int number = 0;
		int playerX = 0, playerY = 0;
		int ballX = 0, ballY = 0;
		int ballDistance = 0, ballTheta = 0;

		for (int i = 0; i < CoordinationMessage.size(); i++) {

			String[] cmarray = CoordinationMessage.elementAt(i).split(",");

			if (cmarray[0].equalsIgnoreCase("c")) {

				try {

					type = 0;

					number = Integer.parseInt(cmarray[1]);

					playerX = Integer.parseInt(cmarray[2]);
					playerY = Integer.parseInt(cmarray[3]);

					ballX = Integer.parseInt(cmarray[4]);
					ballY = Integer.parseInt(cmarray[5]);

				} catch (Exception e) {
					System.err.println("error in coordination message update");
				}

			} else if (cmarray[0].equalsIgnoreCase("b")) {

				try {

					type = 1;

					number = Integer.parseInt(cmarray[1]);

					playerX = Integer.parseInt(cmarray[2]);
					playerY = Integer.parseInt(cmarray[3]);

					ballDistance = Integer.parseInt(cmarray[4]);
					ballTheta = Integer.parseInt(cmarray[5]);

				} catch (Exception e) {
					System.err.println("error in coordination message update");
				}

			} else if (cmarray[0].equalsIgnoreCase("x")) {

				try {

					type = 2;

					number = Integer.parseInt(cmarray[1]);

				} catch (Exception e) {
					System.err.println("error in coordination message update");
				}

			} else {
				System.out.println("Unknown coordination message");
			}

			if (type == 0) {

				CoordinationMessage cm = new CoordinationMessage(0, number,
						new Coordinate(playerX, playerY), new Coordinate(ballX,
								ballY), ballDistance, ballTheta, 0);

				CoordinationVector.addElement(cm);

			} else if (type == 1) {

				CoordinationMessage cm = new CoordinationMessage(1, number,
						new Coordinate(Double.NaN, Double.NaN), new Coordinate(
								Double.NaN, Double.NaN), ballDistance,
						ballTheta, 0);

				CoordinationVector.addElement(cm);

			} else {

				CoordinationMessage cm = new CoordinationMessage(2, number,
						new Coordinate(Double.NaN, Double.NaN), new Coordinate(
								Double.NaN, Double.NaN), ballDistance,
						ballTheta, 0);

				CoordinationVector.addElement(cm);

			}

		}

		CoordinationRun.setStep(1);

	}

}
