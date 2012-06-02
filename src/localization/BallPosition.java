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
package localization;

import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;

public class BallPosition {



	public static float distance,angle;

	public BallPosition(float distance,float angle){

		distance=BallPosition.getDistance();
		angle=BallPosition.getAngle();



	}

	public static BallPosition WhereIsTheBall(){

		float angleX=Ball.getAngleX();
		//float angleY=Ball.getAngleY();
		float Bodydistance=Ball.getDistance();
		boolean iSeeBall=Ball.isSeeTheBall();
		float HeadxTheta=HingeJointPerceptor.getHj1();
		//float HeadyTheta=HingeJointPerceptor.getHj2();



		if(iSeeBall==true){


			float HeadxThetaDeg=(float) Math.toDegrees(HeadxTheta);
			float realAngleFromBody=HeadxThetaDeg + angleX;
			
			BallPosition BallPos = new BallPosition(Bodydistance, realAngleFromBody);
			return BallPos;


		}else{
			
			return null;
		}
	}


	public static float getDistance() {
		return distance;
	}

	public static void setDistance(float distance) {
		BallPosition.distance = distance;
	}

	public static float getAngle() {
		return angle;
	}

	public static void setAngle(float angle) {
		BallPosition.angle = angle;
	}


}