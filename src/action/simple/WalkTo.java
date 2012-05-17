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

import localization.Coordinate;
import localization.LocalizationResults;
import motion.old.MotionTrigger;

public class WalkTo {

	public static boolean Act(Coordinate target,float Theta){

		double ThetaToTarget=FindAngle(target);

		if(FindDistanceToTarget(target)<0.5){

			if(Math.abs(FindAngleDifference(Theta))<20){
				
				MotionTrigger.setMotion("");
				return true;	
				
			}else{
				
				if(FindAngleDifference(Theta)<0){
					
					MotionTrigger.setMotion("TurnRight40");
					return false;
					
				}else{
					
					MotionTrigger.setMotion("TurnLeft40");
					return false;
					
				}
				
			}

		}else{
			
				
				if(Math.abs(FindAngleDifference(ThetaToTarget))<20){

					MotionTrigger.setMotion("Forwards50");
					return false;
					
				}else{
					
					if(FindAngleDifference(ThetaToTarget)<0){
						
						MotionTrigger.setMotion("TurnRight40");
						return false;
						
					}else{
						
						MotionTrigger.setMotion("TurnLeft40");
						return false;
						
					}
					
				}

		}

	}

	public static double FindAngle(Coordinate target){

		double dx=target.getX()-LocalizationResults.getCurrent_location().getX();
		double dy=target.getY()-LocalizationResults.getCurrent_location().getY();

		double ThetaToTarget=Math.toDegrees(Math.atan2(dx, dy));
		if(ThetaToTarget>=0 && ThetaToTarget<90){

			ThetaToTarget=90-ThetaToTarget;

		}else if(ThetaToTarget>=90 && ThetaToTarget<180){

			ThetaToTarget=-(ThetaToTarget-90);

		}else if(ThetaToTarget<-90 && ThetaToTarget>=-180){

			ThetaToTarget=-(ThetaToTarget+270);

		}else if(ThetaToTarget>=-90 && ThetaToTarget<-0){

			ThetaToTarget=-(ThetaToTarget-90);

		}
		
		return ThetaToTarget;
	}




	public static double FindDistanceToTarget(Coordinate target){

		double dx=target.getX()-LocalizationResults.getCurrent_location().getX();
		double dy=target.getY()-LocalizationResults.getCurrent_location().getY();
		double DistanceToTarget=Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
		
		return DistanceToTarget;
		
	}


	public static double FindAngleDifference(double ThetaToTarget){
		
		double BodyAngle=LocalizationResults.getBody_angle();
		double DesirableAngle=ThetaToTarget;
		double AngleDifference=DesirableAngle-BodyAngle;
		
		if(AngleDifference>180){
			AngleDifference=AngleDifference-360;
		}
		
		return AngleDifference;
		
	}








}
