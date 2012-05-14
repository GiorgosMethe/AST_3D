/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/

package action.undeclared;

import motion.old.MotionTrigger;
import perceptor.HingeJointPerceptor;



public class Kick {
	
	public void Act(){
		
		
		if(HingeJointPerceptor.getHj1()>0){
			MotionTrigger.setMotion("KickForwardLeft");
		}else{
			MotionTrigger.setMotion("KickForwardRight");
		}
		
		
	
	}

}
