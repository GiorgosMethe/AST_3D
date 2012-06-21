/***********************************************************************************
 * Technical University of Crete
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

import agent.Constraints;
import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;

public class SupportStrategicPositions {

	public static Coordinate[] Calculate(Coordinate Ball) {

		Coordinate[] NewCoordinates = new Coordinate[10];

		Coordinate CoordinateOfInterest;

		double Theta=0,Theta1=0,Theta2=0,distance1=0,distance2=0;

		if(Ball.X>=0){

			Theta=TriangleLocalization.FindAngleBetweenCoordinates(Ball, Constraints.OpponentGoal);
			distance1 = 1;
			distance2 = 2;
			CoordinateOfInterest = TriangleLocalization.get_det_with_distance_angle(Ball.X, Ball.Y, Theta+Theta1, distance1);
			
			Theta1=90;
			Theta2=-90;
			
			while(!ProperSupportPosition(TriangleLocalization.get_det_with_distance_angle(CoordinateOfInterest.X, CoordinateOfInterest.Y, Theta+Theta1, distance2))){
				Theta1 -= 10;
			}
			
			while(!ProperSupportPosition(TriangleLocalization.get_det_with_distance_angle(CoordinateOfInterest.X, CoordinateOfInterest.Y, Theta+Theta2, distance2))){
				Theta2 += 10;
			}
			

		}else{
			
			Theta=TriangleLocalization.FindAngleBetweenCoordinates(Ball, Constraints.OwnGoal);
			distance1 = 1;
			distance2 = 2;
			CoordinateOfInterest = TriangleLocalization.get_det_with_distance_angle(Ball.X, Ball.Y, Theta+Theta1, distance1);
			
			Theta1=90;
			Theta2=-90;
			
			while(!ProperSupportPosition(TriangleLocalization.get_det_with_distance_angle(CoordinateOfInterest.X, CoordinateOfInterest.Y, Theta+Theta1, distance2))){
				Theta1 += 10;
			}
			
			while(!ProperSupportPosition(TriangleLocalization.get_det_with_distance_angle(CoordinateOfInterest.X, CoordinateOfInterest.Y, Theta+Theta2, distance2))){
				Theta2 -= 10;
			}
			
			
			
		}

		NewCoordinates[0] = TriangleLocalization.get_det_with_distance_angle(CoordinateOfInterest.X, CoordinateOfInterest.Y, Theta+Theta1, distance2);
		NewCoordinates[1] = TriangleLocalization.get_det_with_distance_angle(CoordinateOfInterest.X, CoordinateOfInterest.Y, Theta+Theta2, distance2);



		return NewCoordinates;

	}
	
	public static boolean ProperSupportPosition(Coordinate spot){
		
		if(Math.abs(spot.X)<(Constraints.FieldLength/2 - 1)){		
			if(Math.abs(spot.Y)<(Constraints.FieldWidth/2 -1)){	
				
				return true;
				
			}		
		}
		
		
		return false;	
		
	}

}
