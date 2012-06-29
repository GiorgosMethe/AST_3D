package coordination.TeamRoles;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import coordination.main.CoordinationBeliefs;
import coordination.main.CoordinationSplitter;
import coordination.strategy.TeamFormation;

public class RoleAssignmentFunction {

	public static Vector<Role> ActiveRoles = new Vector<Role>();
	public static Vector<Role> SupportRoles = new Vector<Role>();

	public static void AssignRolesForPlayers() {

		ActiveRoles.clear();
		SupportRoles.clear();

		int roleArray[] = { 0, 0, 2, 3, 4, 5, 6, 7, 8, 9 };

		Coordinate Ball = CoordinationBeliefs.Ball;

		for (int i = 2; i < TeamFormation.TeamFormation.length; i++) {
			for (int j = i; j > 2; j--) {
				if (TriangleLocalization.FindDistanceAmong2Coordinates(
						TeamFormation.TeamFormation[j - 1], Ball) > TriangleLocalization
						.FindDistanceAmong2Coordinates(
								TeamFormation.TeamFormation[j], Ball)) {
					Coordinate swap = TeamFormation.TeamFormation[j];
					int swap1 = roleArray[j];
					TeamFormation.TeamFormation[j] = TeamFormation.TeamFormation[j - 1];
					roleArray[j] = roleArray[j - 1];
					TeamFormation.TeamFormation[j - 1] = swap;
					roleArray[j - 1] = swap1;
				}
			}
		}

		int role = 2;
		for (int i = 0; i < CoordinationSplitter.ActiveSubset.size(); i++) {

			System.out.println("act paixths: "+CoordinationSplitter.ActiveSubset.elementAt(i).getNumber());
			System.out.println("rolos: "+roleArray[role]);
			
			ActiveRoles.add(new Role(CoordinationSplitter.ActiveSubset
					.elementAt(i), roleArray[role]));
			role++;

		}

		for (int i = 0; i < CoordinationSplitter.SupportSubset.size(); i++) {

			System.out.println("su paixths: "+CoordinationSplitter.SupportSubset.elementAt(i).getNumber());
			System.out.println("rolos: "+roleArray[role]);
			
			SupportRoles.add(new Role(CoordinationSplitter.SupportSubset
					.elementAt(i), roleArray[role]));
			role++;

		}


		for (int i = 0; i < CoordinationSplitter.InactiveSubset.size(); i++) {

			System.out.println("in paixths: "+CoordinationSplitter.InactiveSubset.elementAt(i).getNumber());
			System.out.println("rolos: "+roleArray[role]);
			
			SupportRoles.add(new Role(CoordinationSplitter.InactiveSubset
					.elementAt(i), roleArray[role]));
			role++;

		}


	}

}
