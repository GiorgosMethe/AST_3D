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

		double value = SoccerFieldCoordinateValue.Calculate(Ball);


		double Theta=0,Theta1=0,Theta2=0,Offset1=0,Offset2=0;

		if(Ball.X>=0){

			Theta=TriangleLocalization.FindAngleBetweenCoordinates(Ball, Constraints.OpponentGoal);
			
			if(Math.abs(Ball.X)>8 && Math.abs(Ball.Y)>5){

				if(Theta<0){
					
					Theta1 = -10-(10*Math.random());
					Theta2 = -30-(10*Math.random());
					
				}else{
					
					Theta1 = 10+(10*Math.random());
					Theta2 = 30+(10*Math.random());
					
				}
				
				Offset1 = 4 + Math.random() * 2;
				Offset2 = 4 + Math.random() * 2;
				
			}else{

				Theta1 = 30 + 90*(Ball.X/(Constraints.FieldLength/2));
				Theta2 = -30 - 90*(Ball.X/(Constraints.FieldLength/2));

				Offset1 = 4 - 2*(Ball.X/(Constraints.FieldLength/2));
				Offset2 = 4 - 2*(Ball.X/(Constraints.FieldLength/2));

			}

		}

		NewCoordinates[0] = TriangleLocalization.get_det_with_distance_angle(Ball.X, Ball.Y, Theta+Theta1, Offset1);
		NewCoordinates[1] = TriangleLocalization.get_det_with_distance_angle(Ball.X, Ball.Y, Theta+Theta2, Offset2);




















		return NewCoordinates;

	}

}
