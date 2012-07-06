package coordination.test;

import java.util.Vector;

import perceptor.localization.TriangleLocalization;

public class MappingCost {

	public static double calculate(Vector<Mapping> map) {

		double cost = 0;

		for (int agentNum = 0; agentNum < map.size(); agentNum++) {

			cost += TriangleLocalization.FindDistanceAmong2Coordinates(
					NewAlgorithm.agentPosition[map.elementAt(agentNum)
							.getAgent() - 2], NewAlgorithm.Position[map
							.elementAt(agentNum).getPosition() - 2]);

		}

		// for (int q = 0; q < map.size(); q++) {
		// for (int r = q + 1; r < map.size(); r++) {
		//
		// cost -= 2 * TriangleLocalization.FindDistanceAmong2Coordinates(
		// NewAlgorithm.Position[map.elementAt(q).getAgent()-1],
		// NewAlgorithm.Position[map.elementAt(r).getAgent()-1]);
		//
		//
		//
		// Coordinate Agent1 =
		// NewAlgorithm.agentPosition[map.elementAt(q).getAgent()-1];
		//
		// Coordinate Agent2 =
		// NewAlgorithm.agentPosition[map.elementAt(q).getAgent()-1];
		//
		// com.vividsolutions.jts.geom.Coordinate interceptionPoint =
		// GeometricUtils
		// .FindIntersection(Agent1,NewAlgorithm.Position[map.elementAt(q).getAgent()-1],
		// Agent2, NewAlgorithm.Position[map.elementAt(r).getAgent()-1]);
		//
		// if (interceptionPoint != null) {
		//
		// double distanceFromAgent1 = TriangleLocalization
		// .FindDistanceAmong2Coordinates(Agent1,
		// new Coordinate(interceptionPoint.x,
		// interceptionPoint.y));
		//
		// double distanceFromAgent2 = TriangleLocalization
		// .FindDistanceAmong2Coordinates(Agent2,
		// new Coordinate(interceptionPoint.x,
		// interceptionPoint.y));
		//
		// cost += 2;
		//
		// if (Math.abs(distanceFromAgent1 - distanceFromAgent2) < 1.5) {
		//
		// cost += 100;
		//
		// }
		//
		// } else {
		//
		// double distance = GeometricUtils.FindDistance(Agent1,
		// NewAlgorithm.Position[map.elementAt(q).getAgent()-1], Agent2,
		// NewAlgorithm.Position[map.elementAt(r).getAgent()-1]);
		//
		// cost -= distance;
		//
		// }
		//
		//
		//
		// }
		// }

		return cost;

	}

}
