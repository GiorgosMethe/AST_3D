package action.handler;

import action.fsm.GKBGDstates;
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
						GKBGDstates.setState("Start");
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
