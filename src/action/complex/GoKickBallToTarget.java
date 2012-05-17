package action.complex;

import motion.old.MotionTrigger;
import motion.xml.CheckKickEnd;
import motion.xml.MotionPlaying;
import action.simple.WalkToBall;
import action.undeclared.ActionStateMachine;

public class GoKickBallToTarget {
	
	public static boolean Act(float theta){


		if(ActionStateMachine.getState().equalsIgnoreCase("GoToBall")){
			if(WalkToBall.Act()){
				ActionStateMachine.setState("Kick");
			}else{
				ActionStateMachine.setState("GoToBall");
			}
		}else if(ActionStateMachine.getState().equalsIgnoreCase("Kick")){
			if(CheckKickEnd.Check()){
			
				ActionStateMachine.setState("GoToBall");
				return true;
			
			}
			MotionTrigger.setMotion("KickForwardRight");
			ActionStateMachine.setState("GoToBall");
			
		}
		return false;

	}

}
