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
package coordination.communication.message;

import java.util.Vector;

import perceptor.localization.Coordinate;
import coordination.main.Coordination;
import coordination.main.CoordinationRun;

public class CoordinationVectorUpdate {

	public static Vector<CoordinationMessage> CoordinationVector = new Vector<CoordinationMessage>();

	public static void update(Vector<String> CoordinationMessage) {

		Coordination.roboviz = false;

		CoordinationVector.clear();

		int type = 0;
		int number = 0;
		int ballX = 0, ballY = 0;
		int playerX = 0, playerY = 0;
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

					ballX = Integer.parseInt(cmarray[4]);
					ballY = Integer.parseInt(cmarray[5]);

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

				} catch (Exception e) {
					System.err.println("error in coordination message update");
				}

				System.out.print(number + "b ");

			} else if (cmarray[0].equalsIgnoreCase("x")) {

				try {

					type = 3;

					number = Integer.parseInt(cmarray[1]);

				} catch (Exception e) {
					System.err.println("error in coordination message update");
				}

				System.out.print(number + "x ");

			} else {
				System.out.println("Unknown coordination message");
			}

			CoordinationMessage temp = new CoordinationMessage(type, number,
					new Coordinate(playerX, playerY), new Coordinate(ballX,
							ballY), ballDistance, ballTheta, 0);

			CoordinationVector.add(temp);

		}
		System.out.println("");

		CoordinationRun.setStep(1);

	}

}
