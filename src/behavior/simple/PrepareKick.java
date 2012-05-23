package behavior.simple;

import motion.old.MotionTrigger;
import perceptor.HingeJointPerceptor;
import perceptor.vision.Ball;

public class PrepareKick {
	
	public static boolean Act(){
		
		if((Ball.getAngleX()+HingeJointPerceptor.getHj1())>-4){
			
			MotionTrigger.setMotion("SideStepLeft");
			return false;
			
		}else if((Ball.getAngleX()+HingeJointPerceptor.getHj1())<-13){
			
			MotionTrigger.setMotion("SideStepRight");
			return false;
			
		}else{
			MotionTrigger.setMotion("");
			return true;
		}
		
		
		
	}

}
