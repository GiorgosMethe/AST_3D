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

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import agent.Constraints;

public class ActivePositions {

	public static Vector<Coordinate> ActivePositions = new Vector<Coordinate>();

	public static void Calculate(Coordinate Ball) {

		Coordinate CoordinateOfInterest;
		ActivePositions.removeAllElements();
		
		int distance = 2;
		float theta = 0;
		
		for(int i=0;i<7;i++){
			
			Coordinate a = TriangleLocalization.get_det_with_distance_angle(Ball.X, Ball.Y, theta, distance);
			theta +=45; 
			if(ProperSupportPosition(a)){
			ActivePositions.add(a);
			}
			
		}
		
		
		for(int i=0;i<ActivePositions.size();i++){
			System.out.println();
			System.out.println();
			System.out.println("----------");
			System.out.print("thesh :"+i+"  ");
			System.out.print(ActivePositions.elementAt(i).getX()+"  ");
			System.out.println(ActivePositions.elementAt(i).getY());
		}

	}

	public static boolean ProperSupportPosition(Coordinate spot) {

		if (Math.abs(spot.X) < (Constraints.FieldLength / 2)) {
			if (Math.abs(spot.Y) < (Constraints.FieldWidth / 2)) {

				return true;

			}
		}

		return false;

	}

}
