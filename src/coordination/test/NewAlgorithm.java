package coordination.test;

import java.util.Vector;

public class NewAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] position = new Integer[] { 1, 2, 3, 4, 5 };
		Integer[] agent = new Integer[] { 1, 2, 3, 4, 5 };

		Vector<Vector<Vector<Mapping>>>[] BestRoleMap = (Vector<Vector<Vector<Mapping>>>[]) java.lang.reflect.Array
				.newInstance(Vector.class, 5);

		for (int i = 0; i < position.length; i++) {

			BestRoleMap[i] = new Vector<Vector<Vector<Mapping>>>();
			Vector<Vector<Mapping>> Map = new Vector<Vector<Mapping>>();
			for (int j = 0; j < agent.length; j++) {

				Vector<Mapping> RoleMap = new Vector<Mapping>();

				if (i >= 1) {

					for (int rr = 0; rr < BestRoleMap[i - 1].size(); rr++) {

						for (int h = 0; h < BestRoleMap[i - 1].elementAt(rr)
								.size(); h++) {

							if (BestRoleMap[i - 1].elementAt(rr).elementAt(h)
									.size() == 1) {

								for (int h1 = 0; h1 < BestRoleMap[i - 1]
										.elementAt(rr).elementAt(h).size(); h1++) {

									if (BestRoleMap[i - 1].elementAt(rr)
											.elementAt(h).elementAt(h1)
											.getAgent() != agent[j]
											&& BestRoleMap[i - 1].elementAt(rr)
													.elementAt(h).elementAt(h1)
													.getPosition() != position[i]) {

										Vector<Mapping> RoleMap1 = new Vector<Mapping>();

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

							} else if (BestRoleMap[i - 1].elementAt(rr)
									.elementAt(h).size() > 1) {

								Vector<Mapping> RoleMap1 = new Vector<Mapping>();
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

									}

								}

								System.out.println(RoleMap1.size());
								Map.add(RoleMap1);

							}
						}
					}

				} else {

					RoleMap.add(new Mapping(agent[j], position[i]));
					Map.add(RoleMap);

				}

			}
			
			
			BestRoleMap[i].add(Map);

		}

		for (int k = 0; k < BestRoleMap.length; k++) {
			for (int i = 0; i < BestRoleMap[k].size(); i++) {

				for (int ii = 0; ii < BestRoleMap[k].elementAt(i).size(); ii++) {
					System.out.println();
					for (int h = 0; h < BestRoleMap[k].elementAt(i)
							.elementAt(ii).size(); h++) {
						System.out.print("A "
								+ BestRoleMap[k].elementAt(i).elementAt(ii)
										.elementAt(h).getAgent());
						System.out.print(" --> P "
								+ BestRoleMap[k].elementAt(i).elementAt(ii)
										.elementAt(h).getPosition() + " , ");

					}

				}

			}
		}

	}

}
