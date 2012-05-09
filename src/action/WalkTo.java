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

import connection.ServerCyrcles;
import localization.Coordinate;
import localization.LocalizationResults;
import motions.MotionTrigger;

public class WalkTo {
	
	public void Act(float X,float Y,float Theta){
		
		Coordinate target=new Coordinate(4, -4);

		double dx=target.getX()-LocalizationResults.current_location.getX();
		double dy=target.getY()-LocalizationResults.current_location.getY();
		double dTheta=-Math.atan(dy/dx)+LocalizationResults.getBody_angle();

		if(ServerCyrcles.getCyrclesNow()%20==0){
			if(Math.abs(dx)<1 && Math.abs(dy)<1){
				MotionTrigger.setMotion("");
			}else{


				if(dTheta>15){

					if(dTheta>0){
						MotionTrigger.setMotion("TurnRight40");

					}else{
						MotionTrigger.setMotion("TurnLeft40");
					}

				}else{

					MotionTrigger.setMotion("Forwards50");

				}

			}
		}
		
	}

}
