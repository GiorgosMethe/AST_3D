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
package coordination.TeamRoles;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import coordination.action.ActionObject;
import coordination.action.ActionTable;
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

		Coordinate[] TeamFormationTemp = TeamFormation.TeamFormation.clone();

		for (int i = 2; i < TeamFormationTemp.length; i++) {
			for (int j = i; j > 2; j--) {
				if (TriangleLocalization.FindDistanceAmong2Coordinates(
						TeamFormationTemp[j - 1], Ball) > TriangleLocalization
						.FindDistanceAmong2Coordinates(TeamFormationTemp[j],
								Ball)) {
					Coordinate swap = TeamFormationTemp[j];
					int swap1 = roleArray[j];
					TeamFormationTemp[j] = TeamFormationTemp[j - 1];
					roleArray[j] = roleArray[j - 1];
					TeamFormationTemp[j - 1] = swap;
					roleArray[j - 1] = swap1;
				}
			}
		}

		int role = 2;
		for (int i = 0; i < CoordinationSplitter.ActiveSubset.size(); i++) {

			ActiveRoles.add(new Role(CoordinationSplitter.ActiveSubset
					.elementAt(i), roleArray[role]));
			role++;

		}

		for (int i = 0; i < CoordinationSplitter.SupportSubset.size(); i++) {

			SupportRoles.add(new Role(CoordinationSplitter.SupportSubset
					.elementAt(i), roleArray[role]));
			role++;

		}

		for (int i = 0; i < CoordinationSplitter.InactiveSubset.size(); i++) {

			ActionObject a = new ActionObject(
					CoordinationSplitter.InactiveSubset.elementAt(i)
							.getNumber(), "TurnToLocate", 0, 0, 0, 0);

			ActionTable.CoordinateActions.addElement(a);

		}

	}

}
