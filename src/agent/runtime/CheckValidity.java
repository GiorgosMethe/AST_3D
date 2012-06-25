/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/

package agent.runtime;

import agent.constraints.Constraints;

public class CheckValidity {

	public void Number(final int number) {

		if (number > Constraints.numberPlayers) {
			System.err.println("error number (1-" + Constraints.numberPlayers
					+ ")");
			System.exit(1);
		}

	}

}
