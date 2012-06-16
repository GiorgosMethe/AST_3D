/**
 * 
 */
package coordination.main;

import java.util.Vector;

import perceptor.localization.Coordinate;

import agent.Constraints;

import coordination.action.ActionObject;
import coordination.action.ActionValue;
import coordination.communication.CoordinationMessage;
import coordination.strategy.OffTheBallMovement;

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
public class CoordinateFunction {

	public static void Calculate(Vector<CoordinationMessage> coordinationVector){


		//positions in where the agents should go
		Coordinate[] TeamPositions = OffTheBallMovement.Calculate(CoordinationBeliefs.Ball);


		double min = 10000;
		int player = 0;
		for (int i = 0; i < coordinationVector.size(); i++) {

			double value4Goal = ActionValue.Calculate("GoKickBallToGoal",
					coordinationVector.elementAt(i),TeamPositions);

			if(min>value4Goal){
				player = coordinationVector.elementAt(i).getNumber();
				min = value4Goal;
			}
		}

		System.out.println("GoKickBall");
		System.out.println("num: "+player);
		System.out.println("value :"+min);


		
		for(int j=2;j<Constraints.numberPlayers;j++){
			double min1 =1000;
			if(TeamPositions[j]!=null){
				
				for(int i=0;i<coordinationVector.size();i++){		
					if(coordinationVector!=null){
						if(coordinationVector.elementAt(i).getNumber()!=player){
							
							double value4oBm = 0;


						}
					}

				}	

			}
		}



		/*
		 * This is the end of coordination function Coordination admin should
		 * have decided action for all field player; now these actions will be
		 * sent to field players
		 */
		ActionTable.CoordinateActions.removeAllElements();
		for (int j = 0; j < coordinationVector.size(); j++) {
			ActionObject ActionObject = null;

			if (coordinationVector.elementAt(j).getNumber() == player) {
				ActionObject = new ActionObject(coordinationVector.elementAt(j)
						.getNumber(), "GoKickBallToGoal", 0, 0, 0);
			} else {
				ActionObject = new ActionObject(coordinationVector.elementAt(j)
						.getNumber(), "", 0, 0, 0);
			}

			ActionTable.CoordinateActions.add(ActionObject);

		}


	}


}
