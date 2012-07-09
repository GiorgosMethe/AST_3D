package action.complex;

import motion.old.MotionTrigger;
import motion.xml.check.CheckKickEnd;
import motion.xml.check.CheckStrongKickEnd;
import perceptor.localization.Coordinate;
import perceptor.localization.LocalizationResults;
import action.fsm.GKBstates;
import action.simple.WalkToBall;
import action.vision.KickSuccess;

public class GoKickBallDynamic {

	public static boolean Act() {

		if (GKBstates.getState().equalsIgnoreCase("Start")) {

			if (WalkToBall.Act()) {
				GKBstates.setState("PrepareKick");
				KickSuccess.setStart(new Coordinate(
						LocalizationResults.ball_location.X,
						LocalizationResults.ball_location.Y));
			} else {
				GKBstates.setState("Start");
			}

		} else if (GKBstates.getState().equalsIgnoreCase("PrepareKick")) {

			if (PrepareKick.Act()) {

				GKBstates.setState("Kick");

			}

		} else if (GKBstates.getState().equalsIgnoreCase("Kick")) {

			if (CheckStrongKickEnd.Check()) {
				KickSuccess.setEnd(new Coordinate(
						LocalizationResults.ball_location.X,
						LocalizationResults.ball_location.Y));
				GKBstates.setState("Start");
				MotionTrigger.setMotion("");
				return true;

			} else if (CheckKickEnd.Check()) {
				KickSuccess.setEnd(new Coordinate(
						LocalizationResults.ball_location.X,
						LocalizationResults.ball_location.Y));
				GKBstates.setState("Start");
				MotionTrigger.setMotion("");
				return true;

			}
			MotionTrigger.setMotion("KickForwardRight");

		}
		return false;

	}

}
