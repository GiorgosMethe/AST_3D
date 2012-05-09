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
package action;

import localization.Coordinate;
import localization.LocalizationResults;

public class WalkTo {
	
	public static void Act(Coordinate target,float Theta){
		
		double ThetaToTarget=FindAngle(target);
		
		
		
		
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
	
	
}
