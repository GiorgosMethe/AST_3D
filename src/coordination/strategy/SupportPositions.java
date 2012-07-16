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
package coordination.strategy;

import java.util.Vector;

import perceptor.localization.Coordinate;
import coordination.TeamRoles.RoleAssignmentFunction;

public class SupportPositions {

	public static Vector<Coordinate> SupportPositionsVector = new Vector<Coordinate>();

	public static void Calculate() {

		SupportPositionsVector.removeAllElements();

		for (int i = 0; i < RoleAssignmentFunction.SupportRoles.size(); i++) {

			SupportPositionsVector
					.add(TeamFormation.TeamFormation[RoleAssignmentFunction.SupportRoles
							.elementAt(i).getRole()]);

		}

	}
}
