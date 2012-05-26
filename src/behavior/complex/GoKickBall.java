package behavior.complex;

import localization.Coordinate;
import localization.LocalizationResults;
import motion.old.MotionTrigger;
import motion.xml.check.CheckKickEnd;
import motion.xml.check.CheckStrongKickEnd;
import behavior.fsm.GKBstates;
import behavior.simple.WalkToBall;
import behavior.vision.KickSuccess;

public class GoKickBall {

	public static boolean Act(){

		if(GKBstates.getState().equalsIgnoreCase("Start")){
			if(WalkToBall.Act()){
				GKBstates.setState("Kick");
				KickSuccess.setStart(new Coordinate(LocalizationResults.ball_location.X, LocalizationResults.ball_location.Y));
			}else{
				GKBstates.setState("Start");
			}
		}else if(GKBstates.getState().equalsIgnoreCase("Kick")){
			
			if(CheckStrongKickEnd.Check()){
				KickSuccess.setEnd(new Coordinate(LocalizationResults.ball_location.X, LocalizationResults.ball_location.Y));
				GKBstates.setState("Start");
				MotionTrigger.setMotion("");
				return true;
			
			}
			MotionTrigger.setMotion("KickForwardRight");
			
		}
		return false;

	}


}
