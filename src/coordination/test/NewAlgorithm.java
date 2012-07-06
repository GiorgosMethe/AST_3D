package coordination.test;

import java.util.Vector;

import perceptor.localization.Coordinate;

public class NewAlgorithm {

	public static Coordinate[] agentPosition = new Coordinate[] {
			new Coordinate(-8.5, -3.0), new Coordinate(-8.5, 3.0),
			new Coordinate(-9.0, 0.0), new Coordinate(-6.0, -1.0),
			new Coordinate(-6.0, 1.0), new Coordinate(-4.0, -2),
			new Coordinate(-4.0, 2), new Coordinate(-3, -0.0) };

	public static Coordinate[] Position = new Coordinate[] {
			new Coordinate(8.5, 3.0), new Coordinate(8.5, -3.0),
			new Coordinate(9.0, 0.0), new Coordinate(6.0, 1.0),
			new Coordinate(6.0, -1.0), new Coordinate(4.0, 2),
			new Coordinate(4.0, -2), new Coordinate(3, -0.0) };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int counter = 0;

		Integer[] position = new Integer[] { 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer[] agent = new Integer[] { 2, 3, 4, 5, 6, 7, 8, 9 };

		Vector<Vector<Vector<Mapping>>>[] BestRoleMap = (Vector<Vector<Vector<Mapping>>>[]) java.lang.reflect.Array
				.newInstance(Vector.class, 8);

		for (int i = 0; i < position.length; i++) {

			BestRoleMap[i] = new Vector<Vector<Vector<Mapping>>>();
			Vector<Vector<Mapping>> Map = new Vector<Vector<Mapping>>();
			for (int j = 0; j < agent.length; j++) {

				Vector<Mapping> RoleMap = new Vector<Mapping>();
				Vector<Mapping> BestMapMinCost = new Vector<Mapping>();
				Vector<Mapping> BestMapMinCost1 = new Vector<Mapping>();
				double min = 1000;

				if (i >= 1) {

					for (int rr = 0; rr < BestRoleMap[i - 1].size(); rr++) {

						for (int h = 0; h < BestRoleMap[i - 1].elementAt(rr)
								.size(); h++) {

							if (BestRoleMap[i - 1].elementAt(rr).elementAt(h)
									.size() == 1) {

								Vector<Mapping> RoleMap1 = new Vector<Mapping>();
								for (int h1 = 0; h1 < BestRoleMap[i - 1]
										.elementAt(rr).elementAt(h).size(); h1++) {

									if (BestRoleMap[i - 1].elementAt(rr)
											.elementAt(h).elementAt(h1)
											.getAgent() != agent[j]
											&& BestRoleMap[i - 1].elementAt(rr)
													.elementAt(h).elementAt(h1)
													.getPosition() != position[i]) {

										RoleMap1.add(new Mapping(agent[j],
												position[i]));
										RoleMap1.add(new Mapping(
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

								double cost = MappingCost.calculate(RoleMap1);
								counter++;
								if (cost < min) {

									min = cost;
									BestMapMinCost.removeAllElements();
									BestMapMinCost = RoleMap1;

								}

							} else if (BestRoleMap[i - 1].elementAt(rr)
									.elementAt(h).size() > 1) {

								boolean isSubset = true;
								for (int h1 = 0; h1 < BestRoleMap[i - 1]
										.elementAt(rr).elementAt(h).size(); h1++) {

									if (BestRoleMap[i - 1].elementAt(rr)
											.elementAt(h).elementAt(h1)
											.getAgent() == agent[j]
											|| BestRoleMap[i - 1].elementAt(rr)
													.elementAt(h).elementAt(h1)
													.getPosition() == position[i]) {

										isSubset = false;

									}

								}

								if (isSubset) {

									Vector<Mapping> RoleMap1 = new Vector<Mapping>();
									RoleMap1.add(new Mapping(agent[j],
											position[i]));
									for (int h1 = 0; h1 < BestRoleMap[i - 1]
											.elementAt(rr).elementAt(h).size(); h1++) {

										RoleMap1.add(new Mapping(
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

										counter++;

									}

									double cost = MappingCost
											.calculate(RoleMap1);
									counter++;
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

					RoleMap.add(new Mapping(agent[j], position[i]));
					Map.add(RoleMap);

				}

			}

			BestRoleMap[i].add(Map);

		}

		int k = BestRoleMap.length - 1;
		Vector<Mapping> OptimizedSupportVector = null;
		double min = 1000;
		for (int i = 0; i < BestRoleMap[k].size(); i++) {
			for (int ii = 0; ii < BestRoleMap[k].elementAt(i).size(); ii++) {

				if (BestRoleMap[k].elementAt(i).elementAt(ii).size() != 0) {

					double cost = MappingCost.calculate(BestRoleMap[k]
							.elementAt(i).elementAt(ii));
					if (cost < min) {
						min = cost;
						OptimizedSupportVector = new Vector<Mapping>();
						OptimizedSupportVector.addAll(BestRoleMap[k].elementAt(
								i).elementAt(ii));
					}
				}

			}
		}

		for (int h = 0; h < OptimizedSupportVector.size(); h++) {

			System.out.print("A "
					+ OptimizedSupportVector.elementAt(h).getAgent());
			System.out
					.print(" --> P "
							+ OptimizedSupportVector.elementAt(h).getPosition()
							+ " , ");

		}

		System.out.println("Iterations:" + counter);

	}

}
