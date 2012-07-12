package coordination.support;

import java.util.Vector;

import perceptor.localization.TriangleLocalization;
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

		// System.out.println("@@@@@@@@@ paixtes "
		// + CoordinationSplitter.SupportSubset.size());
		// System.out.println("@@@@@@@@@ theseis "
		// + SupportPositions.SupportPositionsVector.size());

		OptimizedSupportMap = PositionCombination(
				SupportPositions.SupportPositionsVector,
				CoordinationSplitter.SupportSubset, CoordinationBeliefs.Ball);

		// System.out.println("optimized Support positions");
		// System.out.println("-------------------");
		for (int i = 0; i < OptimizedSupportMap.size(); i++) {

			// System.out.println("bazw paikth "
			// + OptimizedSupportMap.elementAt(i).getAgent().getNumber());
			// System.out.println("bazw x "
			// + OptimizedSupportMap.elementAt(i).getPosition().getX());
			// System.out.println("bazw y "
			// + OptimizedSupportMap.elementAt(i).getPosition().getY());

			ActionObject a = new ActionObject(OptimizedSupportMap.elementAt(i)
					.getAgent().getNumber(), "WalkToCoordinate",
					OptimizedSupportMap.elementAt(i).getPosition().getX(),
					OptimizedSupportMap.elementAt(i).getPosition().getY(),
					TriangleLocalization.FindAngleBetweenCoordinates(
							OptimizedSupportMap.elementAt(i).getPosition(),
							CoordinationBeliefs.Ball), 0);

			ActionTable.CoordinateActions.addElement(a);

		}

	}

	/*
	 * This is the function which calculate the cost of every mapping the player
	 * of the support sub set can have. The mapping with the minimun cost will
	 * be return to the above function.
	 */

	@SuppressWarnings("unchecked")
	public static Vector<PositionMap> PositionCombination(
			Vector<perceptor.localization.Coordinate> SupportPositionsVector,
			Vector<CoordinationMessage> SupportSubset,
			perceptor.localization.Coordinate ball) {

		Vector<Vector<Vector<PositionMap>>>[] BestRoleMap = (Vector<Vector<Vector<PositionMap>>>[]) java.lang.reflect.Array
				.newInstance(Vector.class, SupportSubset.size());

		for (int i = 0; i < SupportPositionsVector.size(); i++) {

			BestRoleMap[i] = new Vector<Vector<Vector<PositionMap>>>();
			Vector<Vector<PositionMap>> Map = new Vector<Vector<PositionMap>>();
			for (int j = 0; j < SupportSubset.size(); j++) {

				Vector<PositionMap> RoleMap = new Vector<PositionMap>();
				Vector<PositionMap> BestMapMinCost = new Vector<PositionMap>();
				Vector<PositionMap> BestMapMinCost1 = new Vector<PositionMap>();
				double min = 1000;

				if (i >= 1) {

					for (int rr = 0; rr < BestRoleMap[i - 1].size(); rr++) {

						for (int h = 0; h < BestRoleMap[i - 1].elementAt(rr)
								.size(); h++) {

							if (BestRoleMap[i - 1].elementAt(rr).elementAt(h)
									.size() == 1) {

								Vector<PositionMap> RoleMap1 = new Vector<PositionMap>();
								for (int h1 = 0; h1 < BestRoleMap[i - 1]
										.elementAt(rr).elementAt(h).size(); h1++) {

									if (BestRoleMap[i - 1].elementAt(rr)
											.elementAt(h).elementAt(h1)
											.getAgent().getNumber() != SupportSubset
											.elementAt(j).getNumber()
											&& !TriangleLocalization.equal(
													BestRoleMap[i - 1]
															.elementAt(rr)
															.elementAt(h)
															.elementAt(h1)
															.getPosition(),
													SupportPositionsVector
															.elementAt(i))) {

										RoleMap1.add(new PositionMap(
												SupportSubset.elementAt(j),
												SupportPositionsVector
														.elementAt(i)));
										RoleMap1.add(new PositionMap(
												BestRoleMap[i - 1]
														.elementAt(rr)
														.elementAt(h)
														.elementAt(h1)
														.getAgent(),
												BestRoleMap[i - 1]
														.elementAt(rr)
														.elementAt(h)
														.elementAt(h1)
														.getPosition()));
										Map.add(RoleMap1);

									}
								}

							} else if (BestRoleMap[i - 1].elementAt(rr)
									.elementAt(h).size() > 1) {

								boolean isSubset = true;
								for (int h1 = 0; h1 < BestRoleMap[i - 1]
										.elementAt(rr).elementAt(h).size(); h1++) {

									if (BestRoleMap[i - 1].elementAt(rr)
											.elementAt(h).elementAt(h1)
											.getAgent() == SupportSubset
											.elementAt(j)
											|| BestRoleMap[i - 1].elementAt(rr)
													.elementAt(h).elementAt(h1)
													.getPosition() == SupportPositionsVector
													.elementAt(i)) {

										isSubset = false;

									}

								}

								if (isSubset) {

									Vector<PositionMap> RoleMap1 = new Vector<PositionMap>();
									RoleMap1.add(new PositionMap(SupportSubset
											.elementAt(j),
											SupportPositionsVector.elementAt(i)));
									for (int h1 = 0; h1 < BestRoleMap[i - 1]
											.elementAt(rr).elementAt(h).size(); h1++) {

										RoleMap1.add(new PositionMap(
												BestRoleMap[i - 1]
														.elementAt(rr)
														.elementAt(h)
														.elementAt(h1)
														.getAgent(),
												BestRoleMap[i - 1]
														.elementAt(rr)
														.elementAt(h)
														.elementAt(h1)
														.getPosition()));

									}

									double cost = SupportPositionMapCost
											.calculate(RoleMap1,
													CoordinationBeliefs.Ball);

									if (cost < min) {

										min = cost;
										BestMapMinCost.removeAllElements();
										BestMapMinCost = RoleMap1;

									}

								}

							}

						}

					}

					Map.add(BestMapMinCost1);
					Map.add(BestMapMinCost);

				} else {

					RoleMap.add(new PositionMap(SupportSubset.elementAt(j),
							SupportPositionsVector.elementAt(i)));
					Map.add(RoleMap);

				}

			}

			BestRoleMap[i].add(Map);

		}

		int k = BestRoleMap.length - 1;
		Vector<PositionMap> OptimizedSupportVector = null;
		double min = 1000;
		for (int i = 0; i < BestRoleMap[k].size(); i++) {
			for (int ii = 0; ii < BestRoleMap[k].elementAt(i).size(); ii++) {

				if (BestRoleMap[k].elementAt(i).elementAt(ii).size() != 0) {

					double cost = SupportPositionMapCost.calculate(
							BestRoleMap[k].elementAt(i).elementAt(ii),
							CoordinationBeliefs.Ball);
					if (cost < min) {
						min = cost;
						OptimizedSupportVector = new Vector<PositionMap>();
						OptimizedSupportVector.addAll(BestRoleMap[k].elementAt(
								i).elementAt(ii));
					}
				}

			}
		}

		// for (int h = 0; h < OptimizedSupportVector.size(); h++) {
		//
		// System.out.print("A "
		// + OptimizedSupportVector.elementAt(h).getAgent());
		// System.out
		// .print(" --> P "
		// + OptimizedSupportVector.elementAt(h).getPosition()
		// + " , ");
		//
		// }

		return OptimizedSupportVector;
	}

}