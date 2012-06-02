/**
 * 
 */
package coordination;

import java.util.Vector;

import agent.Constraints;

import localization.Coordinate;
import localization.TriangleLocalization;

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
		

		for(int i=0;i<coordinationVector.size();i++){
			
			System.out.println(coordinationVector.elementAt(i).number+" Value::"+BehaviorValues.Calculate("GoKickBallToGoal", coordinationVector.elementAt(i)));
					
		}
		
		
	}

}
