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
package coordination.action;

import java.util.Vector;

public class ActionTable {

	/*
	 * The results of coordination function are saved in this Array and then
	 * they are used by communication system in order to be send to agents
	 */
	public static Vector<ActionObject> CoordinateActions = new Vector<ActionObject>();

}
