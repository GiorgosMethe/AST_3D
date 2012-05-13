package action.complex;

import newMotions.MotionPlaying;
import motions.MotionTrigger;
import perceptor.HingeJointPerceptor;
import perceptor.vision.Ball;
import action.ActionStateMachine;
import action.simple.PrepareKick;
import action.simple.WalkToBall;

public class GoKickBall {
	
	public static boolean Act(){
		
		
	
		System.out.println(ActionStateMachine.getState());
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
			System.out.println(MotionPlaying.getMotionName());
			if(MotionPlaying.getMotionName()==null){
				
			}else{
			if(MotionPlaying.getMotionName().equalsIgnoreCase("rigth_front_front_kick")){
				ActionStateMachine.setState("GoToBall");
			}else{
				ActionStateMachine.setState("Kick");
				MotionTrigger.setMotion("KickForwardRight");
			}	
			}
			return true;
		}
		return false;

	}

}
