/**
 * 
 */
package coordination.main;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;

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
	
	private static double distance2;
	private static double realDistance;
	private static int distance1;

	public static void UpdateBeliefs(
			Vector<CoordinationMessage> coordinationVector) {

		/*
		 * Here, we are making the collection of player perceptions
		 * 
		 * These thought will be used in order to locate the ball
		 * in the field
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


		/*
		 * We have to find the agent's real distance from the ball 
		 */

		for(int i=0;i<coordinationVector.size();i++){

			//agent sees the ball directly
			if(!Double.isNaN(coordinationVector.elementAt(i).getBallDistance())){

				//distance can be also calculated indirectly
				if((!Double.isNaN(coordinationVector.elementAt(i).getPlayerX()))&&
						(!Double.isNaN(coordinationVector.elementAt(i).getPlayerY()))){

					distance1 = coordinationVector.elementAt(i).getBallDistance();
					distance2 = TriangleLocalization.FindDistanceAmong2Coordinates(
							new Coordinate(coordinationVector.elementAt(i).getPlayerX(),
									coordinationVector.elementAt(i).getPlayerY()), 
									CoordinationBeliefs.Ball);

					realDistance = (distance1 + distance2)/2;

				}

				//agent doesn't see the ball directly
			}else{

				//distance can be only calculated indirectly
				if((!Double.isNaN(coordinationVector.elementAt(i).getPlayerX()))&&
						(!Double.isNaN(coordinationVector.elementAt(i).getPlayerY()))){

					distance2 = TriangleLocalization.FindDistanceAmong2Coordinates(
							new Coordinate(coordinationVector.elementAt(i).getPlayerX(),
									coordinationVector.elementAt(i).getPlayerY()), 
									CoordinationBeliefs.Ball);

					realDistance = distance2;


				}else{

					realDistance = 5;


				}


			}


			coordinationVector.elementAt(i).setBallDistance((int) realDistance);


		}

	}

}
