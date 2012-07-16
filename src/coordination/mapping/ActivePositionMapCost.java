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
package coordination.mapping;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import utils.geometry.GeometricUtils;
import coordination.strategy.SoccerFieldCoordinateValue;

public class ActivePositionMapCost {

	public static double calculate(Vector<PositionMap> map, Coordinate Ball) {

		double cost = 0;

		for (int agentNum = 0; agentNum < map.size(); agentNum++) {

			Coordinate Agent = map.elementAt(agentNum).getAgent().getPlayer();

			/*
			 * -Total distance agents are going to travel
			 * 
			 * -Positive cost
			 * 
			 * -Agents will try to minimize this cost
			 */

			cost += TriangleLocalization.FindDistanceAmong2Coordinates(Agent,
					map.elementAt(agentNum).getPosition());

			/*
			 * - Is good for agents to go to positions which have a better
			 * soccer field value
			 * 
			 * - Negative cost
			 * 
			 * - Agents will try to maximize this cost
			 */

			if (perceptor.vision.Ball.BallAtOpponentsHalf(Ball)) {
				cost -= SoccerFieldCoordinateValue.Calculate(map.elementAt(
						agentNum).getPosition()) / 7;
			} else {
				cost += SoccerFieldCoordinateValue.Calculate(map.elementAt(
						agentNum).getPosition()) / 7;
			}

		}

		for (int q = 0; q < map.size(); q++) {
			for (int r = q + 1; r < map.size(); r++) {

				/*
				 * - Is good for agents to go to positions which not have a
				 * short distance with each other agents
				 * 
				 * - Negative cost
				 * 
				 * - Agents will try to maximize this cost
				 */

				cost -= TriangleLocalization.FindDistanceAmong2Coordinates(map
						.elementAt(q).getPosition(), map.elementAt(r)
						.getPosition());

				/*
				 * - Is good for agents to go to positions which not have the
				 * same Y axis value. We want agents to be stretch into the
				 * field
				 * 
				 * - Negative cost
				 * 
				 * - Agents will try to maximize this cost
				 */
				cost -= Math.abs(map.elementAt(q).getPosition().getY()
						- map.elementAt(r).getPosition().getY());

				if ((map.elementAt(r).getAgent().getType() == 0 || map
						.elementAt(r).getAgent().getType() == 1)
						&& (map.elementAt(q).getAgent().getType() == 0 || map
								.elementAt(q).getAgent().getType() == 1)) {

					/*
					 * - Is good for agents to follow roots which have not any
					 * intreceptions with other agent's routes
					 * 
					 * - Positive cost
					 * 
					 * - Agents will try to minimize or not eliminate this cost
					 * completely
					 */

					Coordinate Agent1 = map.elementAt(q).getAgent().getPlayer();

					Coordinate Agent2 = map.elementAt(r).getAgent().getPlayer();

					com.vividsolutions.jts.geom.Coordinate interceptionPoint = GeometricUtils
							.FindIntersection(Agent1, map.elementAt(q)
									.getPosition(), Agent2, map.elementAt(r)
									.getPosition());

					if (interceptionPoint != null) {

						double distanceFromAgent1 = TriangleLocalization
								.FindDistanceAmong2Coordinates(Agent1,
										new Coordinate(interceptionPoint.x,
												interceptionPoint.y));

						double distanceFromAgent2 = TriangleLocalization
								.FindDistanceAmong2Coordinates(Agent2,
										new Coordinate(interceptionPoint.x,
												interceptionPoint.y));

						/*
						 * There is an interception but is not sure that will
						 * cause any collision
						 */
						cost += 2;

						if (Math.abs(distanceFromAgent1 - distanceFromAgent2) < 1.5) {

							/*
							 * Intereception point propably will cause collision
							 * We give plenty of cost to this situation in order
							 * not to be selected by agants.
							 */

							cost += 100;

						}

					} else {

						/*
						 * - Is good for agents to follow routes which have
						 * enough space beteween other agents' routes
						 * 
						 * - Negative cost
						 * 
						 * - Agents will try to maximize this cost
						 */

						double distance = GeometricUtils.FindDistance(Agent1,
								map.elementAt(q).getPosition(), Agent2, map
										.elementAt(r).getPosition());

						cost -= distance;

					}

				}

			}
		}

		return cost;

	}

}
