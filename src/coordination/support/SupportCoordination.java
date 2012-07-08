package coordination.support;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import utils.math.Permutations;
import coordination.action.ActionObject;
import coordination.action.ActionTable;
import coordination.communication.message.CoordinationMessage;
import coordination.main.CoordinationBeliefs;
import coordination.main.CoordinationSplitter;
import coordination.mapping.PositionMap;
import coordination.mapping.SupportPositionMapCost;
import coordination.strategy.SupportPositions;

public class SupportCoordination {

	public static Vector<PositionMap> OptimizedSupportMap;

	/*
	 * This is the function which makes the coordination of the support players
	 */

	public static void Coordinate() {

		System.out.println("@@@@@@@@@ paixtes "
				+ CoordinationSplitter.SupportSubset.size());
		System.out.println("@@@@@@@@@ theseis "
				+ SupportPositions.SupportPositionsVector.size());

		OptimizedSupportMap = PositionCombination(
				SupportPositions.SupportPositionsVector,
				CoordinationSplitter.SupportSubset, CoordinationBeliefs.Ball);

		System.out.println("optimized Support positions");
		System.out.println("-------------------");
		for (int i = 0; i < OptimizedSupportMap.size(); i++) {

			System.out.println("bazw paikth "
					+ OptimizedSupportMap.elementAt(i).getAgent().getNumber());
			System.out.println("bazw x "
					+ OptimizedSupportMap.elementAt(i).getPosition().getX());
			System.out.println("bazw y "
					+ OptimizedSupportMap.elementAt(i).getPosition().getY());

			ActionObject a = new ActionObject(OptimizedSupportMap.elementAt(i)
					.getAgent().getNumber(), "WalkToCoordinate",
					OptimizedSupportMap.elementAt(i).getPosition().getX(),
					OptimizedSupportMap.elementAt(i).getPosition().getY(), 0, 0);

			ActionTable.CoordinateActions.addElement(a);

		}

	}

	/*
	 * This is the function which calculate the cost of every mapping the player
	 * of the support sub set can have. The mapping with the minimun cost will
	 * be return to the above function.
	 */

	public static Vector<PositionMap> PositionCombination(
			Vector<perceptor.localization.Coordinate> SupportPositionsVector,
			Vector<CoordinationMessage> SupportSubset,
			perceptor.localization.Coordinate ball) {

		Vector<PositionMap> Bestmap = new Vector<PositionMap>();

		float min = 1000;

		Integer[] PosiblePositions = new Integer[] { 0, 1, 2, 3, 4 };

		List<Integer> aList = Arrays.asList(PosiblePositions);

		Permutations<Integer> c = new Permutations<Integer>(aList,
				SupportSubset.size());

		while (c.hasNext()) {

			List<Integer> perm = c.next();
			Vector<PositionMap> map = new Vector<PositionMap>();

			/*
			 * players of the support subset will assigned different positions
			 * each time in order to find an optimized mapping.
			 */

			for (int i = 0; i < perm.size(); i++) {

				PositionMap temp = new PositionMap(SupportSubset.elementAt(i),
						SupportPositionsVector.elementAt(perm.get(i)));
				map.add(temp);

			}

			double cost = SupportPositionMapCost.calculate(map, ball);

			if (min > cost) {

				min = (float) cost;
				Bestmap.removeAllElements();
				for (int g = 0; g < map.size(); g++) {

					Bestmap.add(map.elementAt(g));

				}

			}

			map.clear();

		}

		return Bestmap;
	}

}