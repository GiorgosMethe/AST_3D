package action.handler;

import perceptor.localization.Coordinate;
import action.complex.GoKickBallToGoal;
import action.complex.WalkToCoordinate;
import action.simple.TurnToLocate;

public class ActionEffector {

	public static void Act() {

		if (ActionPlaying.getActionPlaying() != null) {

			if (ActionPlaying.getActionPlaying().getAction()
					.equalsIgnoreCase("GoKickBallToGoal")) {

				GoKickBallToGoal.Act();

			} else if (ActionPlaying.getActionPlaying().getAction()
					.equalsIgnoreCase("WalkToCoordinate")) {

				Coordinate target = new Coordinate(ActionPlaying
						.getActionPlaying().getParametres1(), ActionPlaying
						.getActionPlaying().getParametres2());

				WalkToCoordinate.Act(target);

			}

		}else{
			
			TurnToLocate.Act();
			
		}

	}

}
