/**
 * 
 */
package coordination.main;

import java.util.Vector;

import localization.Coordinate;
import localization.TriangleLocalization;
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
public class CoordinationBeliefs {

	public static Coordinate Ball;

	public static void UpdateBeliefs(
			Vector<CoordinationMessage> coordinationVector) {

		/*
		 * Here, we are making the collection of player thoughts
		 * 
		 * These thought will be used in order to locate the ball and the
		 * position of every player in the field
		 */
		for (int i = 0; i < coordinationVector.size(); i++) {

			if (!Double.isNaN(coordinationVector.elementAt(i).getPlayerX())) {

				if (!Double.isNaN(coordinationVector.elementAt(i).getPlayerY())) {


					if (!Double.isNaN(coordinationVector.elementAt(i)
							.getBallDistance())) {

						if (!Double.isNaN(coordinationVector.elementAt(i)
								.getBallTheta())) {

							Coordinate a = TriangleLocalization
									.get_det_with_distance_angle(
											coordinationVector.elementAt(i)
													.getPlayerX(),
											coordinationVector.elementAt(i)
													.getPlayerY(),
											coordinationVector.elementAt(i)
													.getBallTheta(),
											coordinationVector.elementAt(i)
													.getBallDistance());

							BallObservationFilter.AddSample(a);

						}
					}

				}

			}

		}

		CoordinationBeliefs.Ball = BallObservationFilter.update();

	}

}
