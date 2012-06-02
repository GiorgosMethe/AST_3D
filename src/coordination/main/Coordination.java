/**
 * 
 */
package coordination.main;

import java.util.Vector;

import coordination.action.ActionObject;
import coordination.action.ActionValue;
import coordination.communication.CoordinationMessage;

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
public class Coordination {
	
	
	public static void MakeCoordination(Vector<CoordinationMessage> coordinationVector){
			
		int max = -100;
		int player = 0;
		for(int i=0;i<coordinationVector.size();i++){
			
			double value4Goal = ActionValue.Calculate("GoKickBallToGoal", coordinationVector.elementAt(i));
			
			if(value4Goal>max){
				player = coordinationVector.elementAt(i).getNumber();
			}
					
		}
		
		ActionObject ActionObject = new ActionObject("GoKickBallToGoal", 0, 0, 0);
		
		ActionTable.CoordinateActions[player]= ActionObject;
		
		
		
		
	}

}
