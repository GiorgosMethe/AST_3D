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

package action.general;

import localization.LocalizationResults;
import motion.old.MotionTrigger;
import perceptor.vision.Ball;

public class TakeGoaliePos {

	public void Act(){


		boolean alreadyGivenMove=false;
		if(Ball.getDistance()<4){
			if(LocalizationResults.getCurrent_location().getX()<-10.5){
				alreadyGivenMove=true;
				MotionTrigger.setMotion("Forwards50");
			}else if(LocalizationResults.getCurrent_location().getX()>-9.5){
				alreadyGivenMove=true;
				MotionTrigger.setMotion("Backwards");
			}else{

				if(LocalizationResults.getCurrent_location().getY()>0.8 && alreadyGivenMove==false){
					alreadyGivenMove=true;
					MotionTrigger.setMotion("SideStepRight");
				}else if(LocalizationResults.getCurrent_location().getY()<-0.8 && alreadyGivenMove==false){
					alreadyGivenMove=true;
					MotionTrigger.setMotion("SideStepLeft");
				}else{

					if(LocalizationResults.getBody_angle()>10 && alreadyGivenMove==false){
						alreadyGivenMove=true;
						MotionTrigger.setMotion("TurnRight40");
					}else if(LocalizationResults.getBody_angle()>10 && alreadyGivenMove==false){
						alreadyGivenMove=true;
						MotionTrigger.setMotion("TurnLeft40");
					}else{

						if(LocalizationResults.getBall_location().getY()<LocalizationResults.getCurrent_location().getY() && alreadyGivenMove==false){
							MotionTrigger.setMotion("SideStepRight");
						}else{
							MotionTrigger.setMotion("SideStepLeft");
						}
					}

				}		
			}	
		}
	}

}