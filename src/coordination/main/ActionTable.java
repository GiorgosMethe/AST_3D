/**
 * 
 */
package coordination.main;

import coordination.action.ActionObject;

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
public class ActionTable {
	
	/*
	 * The results of coordination function are saved in this Array and then they are used by communication system
	 * in order to be send to agents
	 */
	public static ActionObject[] CoordinateActions = new ActionObject[12];

	public static ActionObject[] getCoordinateActions() {
		return CoordinateActions;
	}

	public static void setCoordinateActions(ActionObject[] coordinateActions) {
		CoordinateActions = coordinateActions;
	}
	
	
	
	
	
	
	
	

}