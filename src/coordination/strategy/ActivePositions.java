/***********************************************************************************
 * Technical University of Crete
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
package coordination.strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import agent.constraints.Constraints;
import coordination.main.CoordinationBeliefs;

public class ActivePositions {

	public static Vector<Coordinate> ActivePositions = new Vector<Coordinate>();

	public static void Calculate(Coordinate Ball) {

		ActivePositions.removeAllElements();

		float distance;
		float Theta = 0;

		distance = 2;
		Theta = 0;
		for (int i = 0; i < 16; i++) {

			Coordinate a = TriangleLocalization.get_det_with_distance_angle(
					Ball.X, Ball.Y, Theta, distance);
			Theta += 30;

			if (ProperSupportPosition(a)) {

				ActivePositions.add(a);

			}
		}

		distance = 2.5f;
		Theta = 15;
		for (int i = 0; i < 16; i++) {

			Coordinate a = TriangleLocalization.get_det_with_distance_angle(
					Ball.X, Ball.Y, Theta, distance);
			Theta += 30;

			if (ProperSupportPosition(a)) {

				ActivePositions.add(a);

			}
		}

		final Comparator<Coordinate> POSITIVE_ORDER = new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate e1, Coordinate e2) {
				boolean Cmp = SoccerFieldCoordinateValue.Calculate(e1) >= SoccerFieldCoordinateValue
						.Calculate(e2);
				if (Cmp != true) {
					return 1;
				} else {
					return 0;
				}
			}
		};

		final Comparator<Coordinate> NEGATIVE_ORDER = new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate e1, Coordinate e2) {
				boolean Cmp = SoccerFieldCoordinateValue.Calculate(e1) <= SoccerFieldCoordinateValue
						.Calculate(e2);
				if (Cmp != true) {
					return 1;
				} else {
					return 0;
				}
			}
		};

		// sort ActivePositions
		if (CoordinationBeliefs.Ball.X >= 0) {
			Collections.sort(ActivePositions, POSITIVE_ORDER);
		} else {
			Collections.sort(ActivePositions, NEGATIVE_ORDER);
		}

		for (int i = 0; i < ActivePositions.size(); i++) {

			if (i > 9) {
				ActivePositions.removeElementAt(i);

			}
		}

	}

	public static boolean ProperSupportPosition(Coordinate spot) {

		if ((Math.abs(spot.X) < ((Constraints.FieldLength / 2) - 0.5))
				&& (Math.abs(spot.Y) < (Constraints.FieldWidth / 2) - 0.5)) {

			return true;

		}

		return false;

	}

}
