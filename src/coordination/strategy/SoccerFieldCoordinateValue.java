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
package coordination.strategy;

import perceptor.localization.Coordinate;
import perceptor.worldstate.TeamState;
import agent.constraints.Constraints;

public class SoccerFieldCoordinateValue {

	public static double Calculate(Coordinate Spot) {



		double AxisXvalue = Math.rint(Spot.getX());
		double AxisYvalue = Math.abs(Math.rint(Spot.getY()));

		double Value = AxisXvalue * (Constraints.FieldWidth / 2 - AxisYvalue);

		if(TeamState.getTeamSide().equalsIgnoreCase("left")){
			
			return Value;
			
		}else{
			
			return -Value;
			
		}
		
	}

}
