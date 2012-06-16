package action.complex;

import perceptor.localization.Coordinate;
import perceptor.vision.Ball;
import action.fsm.GKBTTstates;
import action.fsm.PKTGstates;
import action.simple.TurnToBall;
import action.vision.VisionType;
import agent.Constraints;

public class GoKickBallToGoalLocalize {

	public static boolean Act() {

		if (GKBTTstates.getState().equalsIgnoreCase("Start")) {

			PKTGstates.setProperPositionToWalk(new Coordinate(0, 0));
			if (TurnToBall.Act()) {
				GKBTTstates.setState("CalculatePosition");
			}

		} else if (GKBTTstates.getState().equalsIgnoreCase("CalculatePosition")) {

			if (CalculateValuesToTarget.Act(Constraints.OpponentGoal)) {
				GKBTTstates.setState("WalkToPosition");
			}

		} else if (GKBTTstates.getState().equalsIgnoreCase("WalkToPosition")) {

			System.out.println("ypologisa :" + PKTGstates.getResult());

			GKBTTstates.setState("StartCycle");

		} else if (GKBTTstates.getState().equalsIgnoreCase("StartCycle")) {

			VisionType.setType(2);
			if (WalkToCoordinate.Act(new Coordinate(PKTGstates.getResult().X,
					PKTGstates.getResult().Y))) {
				GKBTTstates.setState("GoForKick");
				VisionType.setType(1);
			}

		} else if (GKBTTstates.getState().equalsIgnoreCase("GoForKick")) {

			VisionType.setType(1);
			if (GoKickBallDynamic.Act()) {
				GKBTTstates.setState("EndKick");
			}

		} else if (GKBTTstates.getState().equalsIgnoreCase("EndKick")) {

			if (GKBTTstates.getTimeout() < 300) {

				int timeout = GKBTTstates.getTimeout();
				GKBTTstates.setTimeout((timeout + 1));

			} else {

				GKBTTstates.setTimeout(0);
				if (Ball.getDistance() < 1.5) {
					GKBTTstates.setState("GoForKick");
					return true;
				} else {
					GKBTTstates.setState("Start");
					return true;
				}

			}

		}

		return false;

	}

}
