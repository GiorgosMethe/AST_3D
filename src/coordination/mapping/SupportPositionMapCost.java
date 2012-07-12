package coordination.mapping;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import utils.geometry.GeometricUtils;

public class SupportPositionMapCost {

	public static double calculate(Vector<PositionMap> map, Coordinate Ball) {

		double cost = 0;

		for (int agentNum = 0; agentNum < map.size(); agentNum++) {

			Coordinate Agent = map.elementAt(agentNum).getAgent().getPlayer();

			cost += 10 * TriangleLocalization.FindDistanceAmong2Coordinates(
					Agent, map.elementAt(agentNum).getPosition());

		}

		for (int q = 0; q < map.size(); q++) {
			for (int r = q + 1; r < map.size(); r++) {

				if (map.elementAt(r).getAgent().getType() == 0
						&& map.elementAt(q).getAgent().getType() == 1) {

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

						if (Math.abs(distanceFromAgent1 - distanceFromAgent2) < 1.5) {

							cost += 100;

						}

					}

				}

			}
		}

		return cost;

	}

}
