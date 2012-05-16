package action.complex;

import motion.old.MotionTrigger;
import motion.xml.Check4Playing;
import motion.xml.MotionPlaying;
import perceptor.HingeJointPerceptor;
import perceptor.vision.Ball;
import action.simple.PrepareKick;
import action.simple.WalkToBall;
import action.undeclared.ActionStateMachine;

public class GoKickBall {

	public static boolean Act(){


		if(ActionStateMachine.getState().equalsIgnoreCase("GoToBall")){
			if(WalkToBall.Act()){
				ActionStateMachine.setState("Kick");
			}else{
				ActionStateMachine.setState("GoToBall");
			}
		}else if(ActionStateMachine.getState().equalsIgnoreCase("Kick")){
			if(MotionPlaying.getMotionPhase()!=null){
			if(MotionPlaying.getMotionPhase().equalsIgnoreCase("rigth_front_front_kick4")){
				ActionStateMachine.setState("GoToBall");
				return true;
			}
			}
			MotionTrigger.setMotion("KickForwardRight");
			ActionStateMachine.setState("GoToBall");
			
		}
		return false;

	}

}
