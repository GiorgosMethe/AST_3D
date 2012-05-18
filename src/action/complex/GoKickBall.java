package action.complex;

import localization.Coordinate;
import localization.LocalizationResults;
import motion.old.MotionTrigger;
import motion.xml.CheckKickEnd;
import action.simple.WalkToBall;
import action.undeclared.ActionStateMachine;
import action.vision.KickSuccess;

public class GoKickBall {

	public static boolean Act(){

		if(ActionStateMachine.getState().equalsIgnoreCase("GoToBall")){
			if(WalkToBall.Act()){
				ActionStateMachine.setState("Kick");
				KickSuccess.setStart(new Coordinate(LocalizationResults.ball_location.X, LocalizationResults.ball_location.Y));
			}else{
				ActionStateMachine.setState("GoToBall");
			}
		}else if(ActionStateMachine.getState().equalsIgnoreCase("Kick")){
			if(CheckKickEnd.Check()){
				KickSuccess.setEnd(new Coordinate(LocalizationResults.ball_location.X, LocalizationResults.ball_location.Y));
				
				if(KickSuccess.Check()){
					System.out.println("petyxa klotsia");
				}else{
					System.out.println("den petyxa klotsia");
				}
				ActionStateMachine.setState("GoToBall");
				
				return true;
			
			}
			MotionTrigger.setMotion("KickForwardRight");
			ActionStateMachine.setState("GoToBall");
			
		}
		return false;

	}


}
