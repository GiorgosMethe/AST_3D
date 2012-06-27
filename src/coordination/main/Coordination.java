/**
 * 
 */
package coordination.main;

import coordination.TeamRoles.RoleAssignmentFunction;
import coordination.active.ActiveCoordination;
import coordination.communication.message.CoordinationMessageUpdate;
import coordination.strategy.ActivePositions;
import coordination.strategy.TeamFormation;
import coordination.support.SupportCoordination;

/***********************************************************************************
 * Copyright 2012, Technical University of Crete Academic Year 2011-2012
 * 
 * Thesis Project
 * 
 * @author Methenitis Georgios Student ID:2006030085
 * 
 *         Abstract: Player Behavior and Team Strategy for the RoboCup 3D
 *         Simulation League Start date: 25-04-2012 End date : xx-xx-2012
 ***********************************************************************************/
public class Coordination {

	/*
	 * Here is the main coordination function, coordination administrator
	 * calculates the actions which maximize team reward
	 */

	public static long a, b;

	public static void MakeCoordination() {

		/*
		 * Admin agent updates his belief for the position of the ball and the
		 * players' position
		 */

		if (CoordinationRun.getStep() == 1) {

			a = System.currentTimeMillis();

			CoordinationBeliefs
					.UpdateBeliefs(CoordinationMessageUpdate.CoordinationVector);

			CoordinationRun.setStep(2);

			/*
			 * Players are going to be splitted in three coordination subsets.
			 * 
			 * Three vectors will be returned from this function. Each one of
			 * them will have a subset of agents which is going to coordinate
			 * together.
			 */
		} else if (CoordinationRun.getStep() == 2) {

			CoordinationSplitter
					.Split(CoordinationMessageUpdate.CoordinationVector);

			CoordinationRun.setStep(3);

			
			
			
			
			
			
			/*
			 * positions for active players are going to be calculated in
			 * relation with the ball position
			 * 
			 * Furthermore, a whole and independent team formation is going
			 * to be calculated
			 */
		} else if (CoordinationRun.getStep() == 3) {

			
			ActivePositions.Calculate(CoordinationBeliefs.Ball);

			TeamFormation.Calculate(CoordinationBeliefs.Ball);
			
			CoordinationRun.setStep(4);

			
			
			
			
			
			
			/*
			 * This function is called in order to find actions for all active
			 * agents which are going to minimize the global cost.
			 */

		} else if (CoordinationRun.getStep() == 4) {

			ActiveCoordination.Coordinate(CoordinationSplitter.ActiveSubset,
					ActivePositions.ActivePositions, CoordinationBeliefs.Ball);
			
			RoleAssignmentFunction.AssignRolesForActivePlayers();
			
			CoordinationMessageUpdate.CoordinationVector.removeAllElements();

			b = System.currentTimeMillis();

			System.out.println("coordination time: " + (b - a) + "ms");

			CoordinationRun.setStep(0);
			


		} else {

		}

	}

}
