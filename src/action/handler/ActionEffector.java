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

			}

			ActionPlaying.setEnd(playing);

		} else {

			TurnToLocate.Act();

		}

	}

}
