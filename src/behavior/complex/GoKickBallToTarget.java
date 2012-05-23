package behavior.complex;

import motion.old.MotionTrigger;
import motion.xml.CheckKickEnd;
import behavior.fsm.GKBstates;
import behavior.simple.WalkToBall;

public class GoKickBallToTarget {
	
	public static boolean Act(float theta){


		if(GKBstates.getState().equalsIgnoreCase("GoToBall")){
			if(WalkToBall.Act()){
				GKBstates.setState("Kick");
			}else{
				GKBstates.setState("GoToBall");
			}
		}else if(GKBstates.getState().equalsIgnoreCase("Kick")){
			if(CheckKickEnd.Check()){
			
				GKBstates.setState("GoToBall");
				return true;
			
			}
			MotionTrigger.setMotion("KickForwardRight");
			GKBstates.setState("GoToBall");
			
		}
		return false;

	}

}
