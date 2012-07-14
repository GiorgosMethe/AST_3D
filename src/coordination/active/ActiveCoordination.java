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

import javax.print.attribute.standard.MediaSize.Other;

import perceptor.localization.TriangleLocalization;
import coordination.action.ActionObject;
import coordination.action.ActionTable;
import coordination.communication.message.CoordinationMessage;
import coordination.main.CoordinationBeliefs;
import coordination.main.CoordinationSplitter;
import coordination.mapping.ActivePositionMapCost;
import coordination.mapping.PositionMap;
import coordination.strategy.ActivePositions;
import coordination.strategy.SoccerFieldCoordinateValue;

public class ActiveCoordination {

	public static Vector<PositionMap> OptimizedActiveMap;
	public static int PreviousOnBallPlayer = 0;
	public static int OnBallPlayer = 0;

	/*
	 * This is the function which makes the coordination of the active players
	 */

	public static void Coordinate() {

		double min = 1000;
		double distance;
		double finalValue = 0;

		for (int i = 0; i < CoordinationSplitter.ActiveSubset.size(); i++) {

			distance = CoordinationSplitter.ActiveSubset.elementAt(i)
					.getRealDistance();

			finalValue = distance;

			if (finalValue < min) {
				min = finalValue;
				OnBallPlayer = CoordinationSplitter.ActiveSubset.elementAt(i)
						.getNumber();
			}

		}

		boolean needlessChange = false;
		for (int i = 0; i < CoordinationSplitter.ActiveSubset.size(); i++) {

			if (PreviousOnBallPlayer == CoordinationSplitter.ActiveSubset
					.elementAt(i).getNumber()) {

				if (min > CoordinationSplitter.ActiveSubset.elementAt(i)
						.getRealDistance() - 1) {

					needlessChange = true;

				}

			}

		}

		if (needlessChange) {
			OnBallPlayer = PreviousOnBallPlayer;
		}

		OptimizedActiveMap = PositionCombination(
				ActivePositions.ActivePositions,
				CoordinationSplitter.ActiveSubset, OnBallPlayer,
				CoordinationBeliefs.Ball);
		
		
		for (int i = 0; i < CoordinationSplitter.ActiveSubset.size(); i++) {
			
			if (OnBallPlayer == CoordinationSplitter.ActiveSubset.elementAt(i)
					.getNumber()) {
				

				double max = -1000;
				perceptor.localization.Coordinate BestAlternative = null;
				for(int j=0;j<OptimizedActiveMap.size();j++){
					if(OptimizedActiveMap.elementAt(i).getAgent().getNumber() != OnBallPlayer){

						double value = SoccerFieldCoordinateValue.Calculate(OptimizedActiveMap.elementAt(i).getPosition());
						
						if(value > max){
							
							max = value;
							BestAlternative = OptimizedActiveMap.elementAt(i).getPosition();

						}	
					}
				}
				
				ActionObject OnBallCoordinateAction;
				if(BestAlternative != null){
					
					OnBallCoordinateAction = new ActionObject(
							CoordinationSplitter.ActiveSubset.elementAt(i)
									.getNumber(), "GoKickBallToGoal", BestAlternative.getX(), BestAlternative.getY(), 0, 0);
					
				}else{
					
					OnBallCoordinateAction = new ActionObject(
							CoordinationSplitter.ActiveSubset.elementAt(i)
									.getNumber(), "GoKickBallToGoal", 0, 0, 0, 0);
					
				}
				

				ActionTable.CoordinateActions.addElement(OnBallCoordinateAction);

				PreviousOnBallPlayer = OnBallPlayer;

			}
		}

		for (int i = 0; i < OptimizedActiveMap.size(); i++) {
			
			if(OptimizedActiveMap.elementAt(i).getAgent().getNumber() != OnBallPlayer){

			ActionObject a = new ActionObject(OptimizedActiveMap.elementAt(i)
					.getAgent().getNumber(), "WalkToCoordinate",
					OptimizedActiveMap.elementAt(i).getPosition().getX(),
					OptimizedActiveMap.elementAt(i).getPosition().getY(),
					TriangleLocalization.FindAngleBetweenCoordinates(
							OptimizedActiveMap.elementAt(i).getPosition(),
							CoordinationBeliefs.Ball), 0);

			ActionTable.CoordinateActions.addElement(a);
			}

		}

	}

	/*
	 * This is the function which calculate the cost of every mapping the three
	 * active player can have. The mapping with the minimun cost will be return
	 * to the above function.
	 */

	public static Vector<PositionMap> PositionCombination(
			Vector<perceptor.localization.Coordinate> activePositions,
			Vector<CoordinationMessage> activeSubset, int onBallPlayer,
			perceptor.localization.Coordinate ball) {

		Vector<PositionMap> Bestmap = new Vector<PositionMap>();

		float min = 1000;

		for (int i = 0; i < activePositions.size(); i++) {

			for (int j = 0; j < activePositions.size(); j++) {

				if (i != j) {

					Vector<PositionMap> map = new Vector<PositionMap>();

					int PlayerSelection[] = { i, j };
					int selection = 0;

					for (int k = 0; k < activeSubset.size(); k++) {

						if (activeSubset.elementAt(k).getNumber() == onBallPlayer) {

							PositionMap temp = new PositionMap(
									activeSubset.elementAt(k), ball);
							map.add(temp);

						} else {

							if (selection < PlayerSelection.length - 1) {

								PositionMap temp = new PositionMap(
										activeSubset.elementAt(k),
										activePositions
										.elementAt(PlayerSelection[selection++]));
								map.add(temp);

							} else {

								PositionMap temp = new PositionMap(
										activeSubset.elementAt(k),
										activePositions
										.elementAt(PlayerSelection[selection]));
								map.add(temp);

							}
						}

					}

					double cost = ActivePositionMapCost.calculate(map, ball);

					if (min > cost) {

						min = (float) cost;
						Bestmap.removeAllElements();
						for (int g = 0; g < map.size(); g++) {

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
