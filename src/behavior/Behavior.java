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
package behavior;

import motions.MotionTrigger;
import perceptor.Ball;
import perceptor.Vision;

public class Behavior {


	public void Act(){

		if(Vision.isiSee()==true){

			if(Ball.isSeeTheBall()==true){
				
				if(Ball.getDistance()>1){
					
					MotionTrigger.setMotion("Forwards");
				}else{
					
					MotionTrigger.setMotion("StopBehavior");
				}

			}else{
				MotionTrigger.setMotion("");
			}

		}else{
			
			MotionTrigger.setMotion("");
			
			
		}





	}



}
