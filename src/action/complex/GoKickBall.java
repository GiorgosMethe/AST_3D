package action.complex;

import motion.old.MotionTrigger;
import motion.xml.MotionPlaying;
import perceptor.HingeJointPerceptor;
import perceptor.vision.Ball;
import action.simple.PrepareKick;
import action.simple.WalkToBall;
import action.undeclared.ActionStateMachine;

public class GoKickBall {

	public static boolean Act(){

		if(WalkToBall.Act()){
			MotionTrigger.setMotion("KickForwardRight");
			return true;
		}
		return false;

	}

}
