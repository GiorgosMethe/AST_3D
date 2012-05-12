package action.complex;

import motions.MotionTrigger;
import perceptor.HingeJointPerceptor;
import perceptor.vision.Ball;
import action.ActionStateMachine;
import action.simple.PrepareKick;
import action.simple.WalkToBall;

public class GoKickBall {
	
	public static boolean Act(){
		
		
//			if(WalkToBall.Act()){
//				if(PrepareKick.Act()){
//					MotionTrigger.setMotion("KickForwardRight");
//				}	
//			}
			
		
		
		if(ActionStateMachine.getState().equalsIgnoreCase("GoToBall")){
			if(WalkToBall.Act()){
				ActionStateMachine.setState("PrepareToKick");
			}else{
				ActionStateMachine.setState("GoToBall");
			}
			return false;
		}else if(ActionStateMachine.getState().equalsIgnoreCase("PrepareToKick")){
			if(PrepareKick.Act()){
				ActionStateMachine.setState("Kick");
			}else{
				ActionStateMachine.setState("PrepareToKick");
			}
			return false;
		}else if(ActionStateMachine.getState().equalsIgnoreCase("Kick")){
			MotionTrigger.setMotion("KickForwardRight");
			ActionStateMachine.setState("GoToBall");
			return true;
		}
		return false;

	}

}
