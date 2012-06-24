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

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.SerializationUtils;

import perceptor.localization.Coordinate;
import coordination.communication.CoordinationMessage;
import coordination.strategy.PositionMapping;
import coordination.strategy.PositionMappingCost;
import coordination.strategy.PositionMappingValues;
import coordination.strategy.SoccerFieldCoordinateValue;

public class ActiveCoordination {

	static PositionMappingValues BestMap = new PositionMappingValues(null, 0);

	public static void Coordinate(Vector<CoordinationMessage> ActiveSubset,
			Vector<Coordinate> ActivePositions, Coordinate ball) {

		double min = 1000;
		int player = 0;
		double distance;
		double ThetaToGoal;
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


		int length = ActivePositions.size();
		List<Integer> source = new LinkedList<Integer>();

		// form the source list that have all the possible positions
		for (int i = 0; i < length; i++) {
			source.add(i);
		}

		// create a target list for forming unique combinations
		List<Integer> target = new LinkedList<Integer>();

		PositionCombination(source, target, ActivePositions, ActiveSubset);


		if(BestMap!=null){

				for(int i=0;i<BestMap.getPosMap().size();i++){

					System.out.println("player "+BestMap.getPosMap().elementAt(i).getAgent().getNumber());
					System.out.println("x "+BestMap.getPosMap().elementAt(i).getPosition().getX());
					System.out.println("y "+BestMap.getPosMap().elementAt(i).getPosition().getY());


				}
				System.out.println("cost "+BestMap.getCost());
			
		}

	System.out.println("-------------------------");
	
	
	BestMap.setPosMap(null);

}

public static void PositionCombination(List<Integer> source,
		List<Integer> target,
		Vector<perceptor.localization.Coordinate> activePositions,
		Vector<CoordinationMessage> activeSubset) {

	// break the recursion
	if (target.size() == activeSubset.size()) {

		Vector<PositionMapping> map = new Vector<PositionMapping>();
		for (int i = 0; i < activeSubset.size(); i++) {

			PositionMapping temp = new PositionMapping(
					activeSubset.elementAt(i),
					activePositions.elementAt(target.get(i)));
			map.add(temp);
		}

		double cost = PositionMappingCost.calculate(map);

		if(BestMap.getPosMap() != null){
			if(BestMap.getCost() > cost){
				BestMap.setCost(cost);
				BestMap.setPosMap(map);
			}
		}else{
			BestMap.setCost(cost);
			BestMap.setPosMap(map);
		}

		return;
	}
	for (Integer position : source) {
		// form the target combination by selecting a position from the
		// source
		@SuppressWarnings("unchecked")
		List<Integer> reducedSource = (List<Integer>) SerializationUtils
		.clone((LinkedList<Integer>) source);
		reducedSource.remove(position);
		@SuppressWarnings("unchecked")
		List<Integer> combinedTarget = (List<Integer>) SerializationUtils
		.clone((LinkedList<Integer>) target);
		combinedTarget.add(position);
		PositionCombination(reducedSource, combinedTarget, activePositions,
				activeSubset);
	}

	source.clear();
	target.clear();

}

}
