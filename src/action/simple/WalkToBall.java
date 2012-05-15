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
import motion.old.MotionTrigger;
import motion.xml.WalkLeaning;
import perceptor.HingeJointPerceptor;
import perceptor.vision.Ball;
import perceptor.vision.Vision;

public class WalkToBall {

	public static boolean Act(){

		if(Vision.isiSee()){

			if(Ball.isSeeTheBall()){


				if((Ball.RealDistance()<0.37)&&(Ball.getDistance()<0.46)){
					System.out.println("stopppppppppppppPP!!!!!!!!!");
					MotionTrigger.setMotion("");
					return true;

				}else{



					if((Math.abs(HingeJointPerceptor.getHj1()+Math.abs(Ball.getAngleX())))>15){

						
						if((HingeJointPerceptor.getHj1()+Ball.getAngleX())>0){

							MotionTrigger.setMotion("TurnLeft40");
							return false;

						}else{

							MotionTrigger.setMotion("TurnRight40");
							return false;

						}
						
					}else if((Math.abs(HingeJointPerceptor.getHj1()+Math.abs(Ball.getAngleX())))>5){

							
							if((HingeJointPerceptor.getHj1()+Ball.getAngleX())>0){

								MotionTrigger.setMotion("Forwards50");
								WalkLeaning.setLean("left");
								return false;

							}else{

								MotionTrigger.setMotion("Forwards50");
								WalkLeaning.setLean("right");
								return false;

							}


					}else{

						MotionTrigger.setMotion("Forwards50");
						WalkLeaning.setLean("");
						return false;
					}

				}

			}
			return false;

		}
		return false;

	}
}