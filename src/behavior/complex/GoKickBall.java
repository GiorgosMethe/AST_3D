package behavior.complex;

import localization.Coordinate;
import localization.LocalizationResults;
import motion.old.MotionTrigger;
import motion.xml.CheckKickEnd;
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
			if(CheckKickEnd.Check()){
				KickSuccess.setEnd(new Coordinate(LocalizationResults.ball_location.X, LocalizationResults.ball_location.Y));
				
				if(KickSuccess.Check()){
					System.out.println("petyxa klotsia");
				}else{
					System.out.println("den petyxa klotsia");
				}
				GKBstates.setState("Start");
				
				return true;
			
			}
			MotionTrigger.setMotion("KickForwardRight");
			GKBstates.setState("Start");
			
		}
		return false;

	}


}
