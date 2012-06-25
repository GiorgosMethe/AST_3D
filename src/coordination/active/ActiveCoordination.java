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
import coordination.communication.CoordinationMessage;
import coordination.strategy.PositionMapping;
import coordination.strategy.PositionMappingCost;
import coordination.strategy.PositionMappingValues;

public class ActiveCoordination {

	static PositionMappingValues BestMap = new PositionMappingValues(null, 0);

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
				ActiveSubset.removeElementAt(i);
			}
		}

		PositionCombination(ActivePositions, ActiveSubset);

		BestMap.setPosMap(null);

	}

	public static void PositionCombination(
			Vector<perceptor.localization.Coordinate> activePositions,
			Vector<CoordinationMessage> activeSubset) {

		for (int i = 0; i < activePositions.size(); i++) {

			for (int j = 0; j < activePositions.size(); j++) {

				if (i != j) {

					Vector<PositionMapping> map = new Vector<PositionMapping>();

					PositionMapping temp = new PositionMapping(
							activeSubset.elementAt(0),
							activePositions.elementAt(i));
					map.add(temp);

					PositionMapping temp1 = new PositionMapping(
							activeSubset.elementAt(1),
							activePositions.elementAt(j));
					map.add(temp1);

					double cost = PositionMappingCost.calculate(map);

					if (BestMap.getPosMap() != null) {
						if (BestMap.getCost() > cost) {
							BestMap.setCost(cost);
							BestMap.setPosMap(map);
						}
					} else {
						BestMap.setCost(cost);
						BestMap.setPosMap(map);
					}

					map.clear();

				}
			}
		}
	}
}
