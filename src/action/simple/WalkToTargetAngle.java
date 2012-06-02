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

import motion.old.MotionTrigger;
import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;
import perceptor.vision.Vision;

public class WalkToTargetAngle {

	public static boolean Act(double Angle){

		if(Vision.isiSee()){

			if(Ball.isSeeTheBall()){


					float AngleThresholdBigTurn;
					float AngleThresholdWalkLeaningTurn;
					if(Ball.getDistance()<1){

						AngleThresholdBigTurn=10;
						AngleThresholdWalkLeaningTurn = 2;

					}else{

						AngleThresholdBigTurn=20;
						AngleThresholdWalkLeaningTurn = 5;
					}


					if((Math.abs(Angle+HingeJointPerceptor.getHj1()+Math.abs(Ball.getAngleX())))>AngleThresholdBigTurn){


						if((HingeJointPerceptor.getHj1()+Ball.getAngleX())>Angle){

							MotionTrigger.setMotion("TurnLeft40");
							return false;

						}else{

							MotionTrigger.setMotion("TurnRight40");
							return false;

						}
					
					}else if((Math.abs(-Angle+HingeJointPerceptor.getHj1()+Math.abs(Ball.getAngleX())))>AngleThresholdWalkLeaningTurn){


						if((HingeJointPerceptor.getHj1()+Ball.getAngleX())>Angle){

							MotionTrigger.setMotion("Forwards50");
							//WalkLeaning.setLean("left");
							return false;

						}else{

							MotionTrigger.setMotion("Forwards50");
							//WalkLeaning.setLean("right");
							return false;

						}

					}else{

						if(Ball.getDistance()<1){
							MotionTrigger.setMotion("Forwards50");
							//WalkLeaning.setLean("slow");
						}else{
							MotionTrigger.setMotion("Forwards50");
							//WalkLeaning.setLean("");
						}
						return false;
					}

				}


		}
		return false;

	}
}