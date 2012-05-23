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
package behavior.simple;

import localization.Coordinate;
import localization.TriangleLocalization;
import motion.old.MotionTrigger;

public class WalkTo {

	public static boolean Act(Coordinate target,float Theta){

		double ThetaToTarget=TriangleLocalization.FindAngle(target);

		if(TriangleLocalization.FindDistanceToTarget(target)<0.5){

			if(Math.abs(TriangleLocalization.FindAngleDifference(Theta))<20){
				
				MotionTrigger.setMotion("");
				return true;	
				
			}else{
				
				if(TriangleLocalization.FindAngleDifference(Theta)<0){
					
					MotionTrigger.setMotion("TurnRight40");
					return false;
					
				}else{
					
					MotionTrigger.setMotion("TurnLeft40");
					return false;
					
				}
				
			}

		}else{
			
				
				if(Math.abs(TriangleLocalization.FindAngleDifference(ThetaToTarget))<20){

					MotionTrigger.setMotion("Forwards50");
					return false;
					
				}else{
					
					if(TriangleLocalization.FindAngleDifference(ThetaToTarget)<0){
						
						MotionTrigger.setMotion("TurnRight40");
						return false;
						
					}else{
						
						MotionTrigger.setMotion("TurnLeft40");
						return false;
						
					}
					
				}

		}

	}


}
