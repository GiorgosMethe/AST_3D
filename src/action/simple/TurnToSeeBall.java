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
package action.simple;

import perceptor.vision.Ball;
import perceptor.vision.Vision;
import motions.MotionTrigger;


public class TurnToSeeBall {


	public static void Act(){

		if(Vision.isiSee()){
			if(Ball.isSeeTheBall()){
				MotionTrigger.setMotion("");
			}else{
				MotionTrigger.setMotion("TurnRight40");
			}
		}
		
								
	}

}



