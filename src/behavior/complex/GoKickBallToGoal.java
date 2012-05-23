package behavior.complex;

import behavior.general.ActionStateMachine;
import behavior.simple.PrepareKickToGoal;
import behavior.simple.WalkToBall;
import behavior.vision.KickSuccess;
import behavior.vision.VisionType;
import localization.Coordinate;
import localization.LocalizationResults;
import motion.old.MotionTrigger;
import motion.xml.CheckKickEnd;

public class GoKickBallToGoal {

	public static boolean Act(){

		if(ActionStateMachine.getState().equalsIgnoreCase("GoToBall")){
			
			if(WalkToBall.Act()){
				ActionStateMachine.setState("TakePosition");
				KickSuccess.setStart(new Coordinate(LocalizationResults.ball_location.X, LocalizationResults.ball_location.Y));
			}else{
				ActionStateMachine.setState("GoToBall");
			}
			
		}else if(ActionStateMachine.getState().equalsIgnoreCase("TakePosition")){
			
			if(PrepareKickToGoal.Act()){
				ActionStateMachine.setState("Kick");
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
