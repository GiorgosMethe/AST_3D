package action.complex;

import perceptor.localization.Coordinate;
import perceptor.localization.LocalizationResults;
import motion.old.MotionTrigger;
import motion.xml.check.CheckStrongKickEnd;
import action.fsm.GKBstates;
import action.simple.WalkToBall;
import action.vision.KickSuccess;

public class GoKickBallDynamic {

	public static boolean Act() {

		if (GKBstates.getState().equalsIgnoreCase("Start")) {
			if (WalkToBall.Act()) {
				GKBstates.setState("Kick");
				KickSuccess.setStart(new Coordinate(
						LocalizationResults.ball_location.X,
						LocalizationResults.ball_location.Y));
			} else {
				GKBstates.setState("Start");
			}
		} else if (GKBstates.getState().equalsIgnoreCase("Kick")) {

			if (CheckStrongKickEnd.Check()) {
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
