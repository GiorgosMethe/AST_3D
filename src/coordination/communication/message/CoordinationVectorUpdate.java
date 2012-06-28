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
public class CoordinationVectorUpdate {

	public static Vector<CoordinationMessage> CoordinationVector = new Vector<CoordinationMessage>();

	public static void update(Vector<String> CoordinationMessage) {

		int type = 0;
		int number = 0;
		int playerX = 0, playerY = 0;
		int ballX = 0, ballY = 0;
		int ballDistance = 0, ballTheta = 0;

		System.out.println("");

		for (int i = 0; i < CoordinationMessage.size(); i++) {

			String[] cmarray = CoordinationMessage.elementAt(i).split(",");

			if (cmarray[0].equalsIgnoreCase("c")) {

				try {

					type = 0;

					number = Integer.parseInt(cmarray[1]);

					playerX = Integer.parseInt(cmarray[2]);
					playerY = Integer.parseInt(cmarray[3]);

					ballTheta = Integer.parseInt(cmarray[4]);
					ballDistance = Integer.parseInt(cmarray[5]);

				} catch (Exception e) {
					System.err.println("error in coordination message update");
				}
				System.out.print(number + "c ");

			} else if (cmarray[0].equalsIgnoreCase("l")) {

				try {

					type = 1;

					number = Integer.parseInt(cmarray[1]);

					playerX = Integer.parseInt(cmarray[2]);
					playerY = Integer.parseInt(cmarray[3]);

					// ballTheta = Integer.parseInt(String.valueOf(Double.NaN));
					// ballDistance =
					// Integer.parseInt(String.valueOf(Double.NaN));

				} catch (Exception e) {
					System.err.println("error in coordination message update");
				}
				System.out.print(number + "l ");

			} else if (cmarray[0].equalsIgnoreCase("b")) {

				try {

					type = 2;

					number = Integer.parseInt(cmarray[1]);

					ballTheta = Integer.parseInt(cmarray[2]);
					ballDistance = Integer.parseInt(cmarray[3]);

					// playerX = Integer.parseInt(String.valueOf(Double.NaN));
					// playerY = Integer.parseInt(String.valueOf(Double.NaN));

				} catch (Exception e) {
					System.err.println("error in coordination message update");
				}

				System.out.print(number + "b ");

			} else if (cmarray[0].equalsIgnoreCase("x")) {

				try {

					type = 3;

					number = Integer.parseInt(cmarray[1]);

					// playerX = Integer.parseInt(String.valueOf(Double.NaN));
					// playerY = Integer.parseInt(String.valueOf(Double.NaN));

					// ballDistance =
					// Integer.parseInt(String.valueOf(Double.NaN));
					// ballTheta = Integer.parseInt(String.valueOf(Double.NaN));

				} catch (Exception e) {
					System.err.println("error in coordination message update");
				}

				System.out.print(number + "x ");

			} else {
				System.out.println("Unknown coordination message");
			}

			CoordinationMessage temp = new CoordinationMessage(type, number,
					new Coordinate(playerX, playerY), ballDistance, ballTheta,
					0);

			CoordinationVector.add(temp);

		}
		System.out.println("");

		CoordinationRun.setStep(1);

	}

}
