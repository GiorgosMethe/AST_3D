package action.comlex;

import motions.MotionTrigger;
import perceptor.HingeJointPerceptor;
import perceptor.vision.Ball;
import action.simple.PrepareKick;
import action.simple.WalkToBall;

public class GoKickBall {
	
	public static boolean Act(){
		
		
			if(WalkToBall.Act()){
				if(PrepareKick.Act()){
					MotionTrigger.setMotion("KickForwardRight");
				}	
			}
			return false;
			

		
	}

}
