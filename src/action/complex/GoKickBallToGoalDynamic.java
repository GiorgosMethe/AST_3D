/**
 * 
 */
package action.complex;

import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;
import localization.Coordinate;
import localization.LocalizationResults;
import localization.TriangleLocalization;
import motion.old.MotionTrigger;
import motion.xml.check.CheckStrongKickEnd;
import action.fsm.GKBGDstates;
import action.fsm.GKBstates;
import action.fsm.PKTGstates;
import action.simple.WalkToBall;
import action.simple.WalkToBallForKick;
import action.vision.KickSuccess;
import action.vision.VisionType;
import agent.Constraints;

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
public class GoKickBallToGoalDynamic {


	public static boolean Act() {
		
		
		System.out.println(GKBGDstates.getState());

		if (GKBGDstates.getState().equalsIgnoreCase("Start")) {

			if (WalkToBallForKick.Act()) {
				GKBGDstates.setState("CheckAngle");
			}

		} else if (GKBGDstates.getState().equalsIgnoreCase("CheckAngle")) {


			if(GKBGDstates.getTimeout()<50){


				VisionType.setType(2);
				int timeout = GKBGDstates.getTimeout();

				GKBGDstates.setTimeout(timeout + 1);

			}else if(GKBGDstates.getTimeout()<60){

				GKBGDstates.setAngle((LocalizationResults.getBody_angle()+GKBGDstates.getAngle()));
				GKBGDstates.setX((LocalizationResults.getCurrent_location().X+GKBGDstates.getX()));
				GKBGDstates.setY((LocalizationResults.getCurrent_location().Y+GKBGDstates.getY()));


				int timeout = GKBGDstates.getTimeout();
				GKBGDstates.setTimeout(timeout + 1);

			}else{

				GKBGDstates.setAngle((GKBGDstates.getAngle()/10));
				GKBGDstates.setX((GKBGDstates.getX()/10));
				GKBGDstates.setY((GKBGDstates.getX()/10));
				GKBGDstates.setTimeout(0);
				GKBGDstates.setState("CheckBall");
				VisionType.setType(1);

			}



		} else if (GKBGDstates.getState().equalsIgnoreCase("CheckBall")) {

			if(GKBGDstates.getTimeout()<50){

				int timeout = GKBGDstates.getTimeout();

				GKBGDstates.setTimeout(timeout + 1);

			}else if(GKBGDstates.getTimeout()<60){

				GKBGDstates.setBallAngle((Ball.getAngleX()+GKBGDstates.getBallAngle()));
				GKBGDstates.setDistance((Ball.getDistance()+GKBGDstates.getDistance()));
				int timeout = GKBGDstates.getTimeout();
				GKBGDstates.setTimeout(timeout + 1);

			}else{

				GKBGDstates.setBallAngle((GKBGDstates.getBallAngle()/10));
				GKBGDstates.setDistance((GKBGDstates.getDistance()/10));
				GKBGDstates.setY((GKBGDstates.getX()/10));
				GKBGDstates.setTimeout(0);
				GKBGDstates.setState("Calculate");
				VisionType.setType(1);

			}


		} else if (GKBGDstates.getState().equalsIgnoreCase("Calculate")) {

			Coordinate ball = TriangleLocalization.get_det_with_distance_angle(GKBGDstates.getX(), GKBGDstates.getY(), GKBGDstates.getBallAngle(), GKBGDstates.getDistance());
			double AngleFromGoal = TriangleLocalization.FindAngleBetweenCoordinates(ball, Constraints.OpponentGoal);
			GKBGDstates.setAngleFromGoal(AngleFromGoal);
			GKBGDstates.setState("PerformMove");
		
		} else if (GKBGDstates.getState().equalsIgnoreCase("PerformMove")) {

			if(GKBGDstates.getTimeout()<50){
				
				int timeout = GKBGDstates.getTimeout();
				GKBGDstates.setTimeout(timeout + 1);
				
				
			}else if(GKBGDstates.getTimeout()<200){

				int timeout = GKBGDstates.getTimeout();
				GKBGDstates.setTimeout(timeout + 1);
				
				if(Math.abs(GKBGDstates.getAngle()-GKBGDstates.getAngleFromGoal())>20){
					
					if(((GKBGDstates.getAngle()-GKBGDstates.getAngleFromGoal())>0) && (GKBGDstates.getAngle()-GKBGDstates.getAngleFromGoal())<180){
						
						if((Ball.getAngleX()+HingeJointPerceptor.getHj1())>5){
							MotionTrigger.setMotion("TurnRight40");
						}else{
							MotionTrigger.setMotion("SideStepLeft");
						}
						
						
					}else{
						
						if((Ball.getAngleX()+HingeJointPerceptor.getHj1())>5){
							MotionTrigger.setMotion("TurnLeft40");
						}else{
							MotionTrigger.setMotion("SideStepRight");
						}
						
						
					}
					
					
				}else{
					
					GKBGDstates.setTimeout(0);
					GKBGDstates.setState("Kick");
					GKBGDstates.setAngle(0);
					GKBGDstates.setX(0);
					GKBGDstates.setY(0);
					GKBGDstates.setDistance(0);
					GKBGDstates.setBallAngle(0);
					
					
				}
				
				
				
				
				
			}else if(GKBGDstates.getTimeout()<300){

					MotionTrigger.setMotion("");
					int timeout = GKBGDstates.getTimeout();
					GKBGDstates.setTimeout(timeout + 1);
				

			}else{


				GKBGDstates.setTimeout(0);
				GKBGDstates.setState("Start");
				GKBGDstates.setAngle(0);
				GKBGDstates.setX(0);
				GKBGDstates.setY(0);
				GKBGDstates.setDistance(0);
				GKBGDstates.setBallAngle(0);

			}
			
			
			
			
		} else if (GKBGDstates.getState().equalsIgnoreCase("Kick")) {

			if(GoKickBallDynamic.Act()){
				GKBGDstates.setTimeout(0);
				GKBGDstates.setState("Start");
				GKBGDstates.setAngle(0);
				GKBGDstates.setX(0);
				GKBGDstates.setY(0);
				GKBGDstates.setDistance(0);
				GKBGDstates.setBallAngle(0);
				return true;
			}

		}


		return false;

	}

}
