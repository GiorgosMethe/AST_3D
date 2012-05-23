package behavior.complex;

import localization.Coordinate;
import localization.LocalizationResults;
import motion.old.MotionTrigger;
import motion.xml.CheckKickEnd;
import behavior.fsm.GKBTGstates;
import behavior.fsm.GKBstates;
import behavior.simple.WalkToBall;
import behavior.vision.KickSuccess;

public class GoKickBallToGoal {

	public static boolean Act(){

		if(GKBTGstates.getState().equalsIgnoreCase("Start")){
			
			if(WalkToBall.Act()){
				GKBTGstates.setState("TakePosition");
				KickSuccess.setStart(new Coordinate(LocalizationResults.ball_location.X, LocalizationResults.ball_location.Y));
			}else{
				GKBTGstates.setState("Start");
			}
			
		}else if(GKBTGstates.getState().equalsIgnoreCase("TakePosition")){
			
			if(PrepareKickToGoal.Act()){
				GKBTGstates.setState("Kick");
			}
			
					
		}else if(GKBTGstates.getState().equalsIgnoreCase("Kick")){
			
			if(CheckKickEnd.Check()){
				
				KickSuccess.setEnd(new Coordinate(LocalizationResults.ball_location.X, LocalizationResults.ball_location.Y));
				
				if(KickSuccess.Check()){
					System.out.println("petyxa klotsia");
				}else{
					System.out.println("den petyxa klotsia");
				}
				GKBTGstates.setState("Start");
				
				return true;
			
			}
			
			MotionTrigger.setMotion("KickForwardRight");
			GKBstates.setState("GoToBall");
			
		}
		return false;

	}


}
