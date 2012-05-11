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

import localization.BallPosition;
import motions.MotionTrigger;
import perceptor.HingeJointPerceptor;
import perceptor.vision.Ball;
import perceptor.vision.Vision;

public class WalkToBall {

	public static boolean Act(){

		if(Vision.isiSee()){

			if(Ball.isSeeTheBall()){

				if(TurnToBall.Act()==true){

					if((Ball.getDistance()>0.5)){

						MotionTrigger.setMotion("Forwards50");
						return false;

					}else{

						if(Ball.getAngleY()+HingeJointPerceptor.getHj2()<-48){

							MotionTrigger.setMotion("");
							return true;

						}else{

							MotionTrigger.setMotion("Forwards50");
							return false;

						}


					}



				}else{

					return false;
				}

			}

		}
		return false;

	}

}