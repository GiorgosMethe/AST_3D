/*******************************************************************************
 * Technical University of Crete
 * 
 * Thesis Project
 * 
 * Author:	Methenitis K. Georgios
 * 
 * Abstract  : Player Behavior and Team Strategy 
 * 			for the RoboCup 3D Simulation League
 * 
 * Date:  		July 2012
 ******************************************************************************/
package action.handler;

import perceptor.localization.Coordinate;
import action.complex.GoKickBallToGoal;
import action.complex.WalkToCompleteCoordinate;
import action.simple.TurnToLocate;

public class ActionEffector {

	public static void Act() {

		if (ActionPlaying.getActionPlaying() != null) {

			boolean playing = false;

			if (ActionPlaying.getActionPlaying().getAction()
					.equalsIgnoreCase("GoKickBallToGoal")) {

				playing = GoKickBallToGoal.Act();

			} else if (ActionPlaying.getActionPlaying().getAction()
					.equalsIgnoreCase("WalkToCoordinate")) {

				Coordinate target = new Coordinate(ActionPlaying
						.getActionPlaying().getParametres1(), ActionPlaying
						.getActionPlaying().getParametres2());

				float Theta = (float) ActionPlaying.getActionPlaying()
						.getParametres3();

				playing = WalkToCompleteCoordinate.Act(target, Theta);

			} else if (ActionPlaying.getActionPlaying().getAction()
					.equalsIgnoreCase("TurnToLocate")) {

				playing = TurnToLocate.Act();

			}

			ActionPlaying.setEnd(playing);

		} else {

			TurnToLocate.Act();

		}

	}

}
