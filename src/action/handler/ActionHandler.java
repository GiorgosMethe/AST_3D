package action.handler;

import action.fsm.GKBGDstates;
import action.fsm.GKBstates;
import coordination.action.ActionObject;

public class ActionHandler {

	public static void Handle(ActionObject Action) {

		if (Action != null) {

			if (ActionPlaying.getActionPlaying() != null) {

				if (ActionPlaying.getActionPlaying().getAction()
						.equalsIgnoreCase("GoKickBallToGoal")) {

					if (!Action.getAction()
							.equalsIgnoreCase("GoKickBallToGoal")) {

						ActionPlaying.setActionPlaying(Action);
						GKBGDstates.setTimeout(0);
						GKBGDstates.setMoveTimeout(0);
						GKBGDstates.setAngleFromPost1(Double.NaN);
						GKBGDstates.setAngleFromPost2(Double.NaN);
						GKBGDstates.setAngle(0);
						GKBGDstates.setState("Start");
						GKBstates.setState("Start");
					}

				} else {

					ActionPlaying.setActionPlaying(Action);

				}
			} else {

				ActionPlaying.setActionPlaying(Action);

			}

		} else {

			ActionPlaying.setActionPlaying(null);

		}

	}

}
