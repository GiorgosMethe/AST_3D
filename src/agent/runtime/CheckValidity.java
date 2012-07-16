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
