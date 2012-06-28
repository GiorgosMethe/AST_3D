package action.handler;

import perceptor.localization.Coordinate;
import action.complex.GoKickBallToGoal;
import action.complex.WalkToCoordinate;
import action.simple.TurnToBall;

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

				playing = WalkToCoordinate.Act(target);

			}

			ActionPlaying.setEnd(playing);

		} else {

			TurnToBall.Act();

		}

	}

}
