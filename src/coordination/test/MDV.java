package coordination.test;

import java.util.Vector;

public class MDV {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vector<Vector<Mapping>>[] BestRoleMap = (Vector<Vector<Mapping>>[]) java.lang.reflect.Array
				.newInstance(Vector.class, 3);

		Vector<Mapping> mapping = new Vector<Mapping>();
		Vector<Vector<Mapping>> dataNumber = new Vector<Vector<Mapping>>();

		mapping.add(new Mapping(0, 1));
		mapping.add(new Mapping(1, 2));
		mapping.add(new Mapping(2, 3));
		mapping.add(new Mapping(3, 4));

		dataNumber.add(mapping);

		BestRoleMap[0] = dataNumber;

		for (int i = 0; i < dataNumber.size(); i++) {

			for (int j = 0; j < dataNumber.elementAt(i).size(); j++) {

				System.out.print("A "
						+ BestRoleMap[0].elementAt(i).elementAt(j).getAgent());
				System.out.println(" --> P "
						+ BestRoleMap[0].elementAt(i).elementAt(j)
								.getPosition());
				System.out.println(" , ");

			}

		}

	}

}
