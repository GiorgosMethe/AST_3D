/***********************************************************************************
 * Technical University of Crete Academic Year 2011-2012
 * 
 * Thesis Project
 * 
 * @author Methenitis Georgios Student ID:2006030085
 * 
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D
 * Simulation League 
 * 
 * Start date: 25-04-2012 End date : xx-xx-2012
 ***********************************************************************************/
package coordination.active;

import java.util.Vector;

import perceptor.localization.Coordinate;
import coordination.action.ActionObject;
import coordination.action.ActionTable;
import coordination.communication.message.CoordinationMessage;
import coordination.mapping.PositionMap;
import coordination.mapping.PositionMapCost;
import coordination.mapping.PositionMapValues;

public class ActiveCoordination {

	

	public static void Coordinate(Vector<CoordinationMessage> ActiveSubset,
			Vector<Coordinate> ActivePositions, Coordinate ball) {

		double min = 1000;
		int player = 0;
		double distance;
		double finalValue = 0;

		for (int i = 0; i < ActiveSubset.size(); i++) {

			if (ActiveSubset.elementAt(i).getType() == 0) {

				distance = ActiveSubset.elementAt(i).getRealDistance();

				finalValue = distance;

			} else if (ActiveSubset.elementAt(i).getType() == 1) {

				distance = ActiveSubset.elementAt(i).getRealDistance();

				finalValue = distance;

			}

			if (finalValue < min) {
				min = finalValue;
				player = ActiveSubset.elementAt(i).getNumber();
			}

		}

		for (int i = 0; i < ActiveSubset.size(); i++) {
			if (player == ActiveSubset.elementAt(i).getNumber()) {

				ActionObject a = new ActionObject(ActiveSubset.elementAt(i)
						.getNumber(), "GoKickBallToGoal", 0, 0, 0, 0);

				ActionTable.CoordinateActions.addElement(a);

				ActiveSubset.removeElementAt(i);
			}
		}

		Vector<PositionMap> OptimizedMap = PositionCombination(ActivePositions, ActiveSubset);

		
		for (int i = 0; i < OptimizedMap.size(); i++) {

			System.out.println("bazw paikth "+OptimizedMap.elementAt(i).getAgent().getNumber());
			System.out.println("bazw x "+OptimizedMap.elementAt(i).getPosition().getX());
			System.out.println("bazw y "+OptimizedMap.elementAt(i).getPosition().getY());
			
			ActionObject a = new ActionObject(OptimizedMap.elementAt(i)
					.getAgent().getNumber(), "WalkToCoordinate", OptimizedMap
					.elementAt(i).getPosition().getX(), OptimizedMap
					.elementAt(i).getPosition().getY(), 0, 0);

			ActionTable.CoordinateActions.addElement(a);

		}


	}

	public static Vector<PositionMap> PositionCombination(
			Vector<perceptor.localization.Coordinate> activePositions,
			Vector<CoordinationMessage> activeSubset) {

		Vector<PositionMap> Bestmap = new Vector<PositionMap>();
		
		float min = 1000;
		
		for (int i = 0; i < activePositions.size(); i++) {

			for (int j = 0; j < activePositions.size(); j++) {

				if (i != j) {

					Vector<PositionMap> map = new Vector<PositionMap>();

					PositionMap temp = new PositionMap(
							activeSubset.elementAt(0),
							activePositions.elementAt(i));
					map.add(temp);

					PositionMap temp1 = new PositionMap(
							activeSubset.elementAt(1),
							activePositions.elementAt(j));
					map.add(temp1);

					double cost = PositionMapCost.calculate(map);

					if (min > cost) {
						
							Bestmap.removeAllElements();
							for(int g=0;g<map.size();g++){
								
								Bestmap.add(map.elementAt(g));
								
							}
							
					}
					
					map.clear();

				}
			}
		}
		
		return Bestmap;
	}
}
