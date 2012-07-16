/*******************************************************************************
 * Technical University of Crete
 * 
 * Thesis Project
 * 
 * Author:	Methenitis K. Georgios
 * 
 * Abstract  : Player Behavior and Team Strategy 
 * 			for the RoboCup 3D Simulation League
 * 
 * Date:  		July 2012
 ******************************************************************************/
package perceptor.vision;

import motion.kinematics.JointPosition2D;
import motion.xml.MotionPlaying;
import perceptor.localization.Coordinate;
import perceptor.worldstate.TeamState;

public class Ball {

	private static boolean seeTheBall;
	private static float distance;
	private static float angleX;
	private static float angleY;

	public Ball(boolean seeTheBall, float distance, float angleX, float angleY) {

		seeTheBall = Ball.isSeeTheBall();
		distance = Ball.getDistance();
		angleX = Ball.getAngleX();
		angleY = Ball.getAngleY();

	}

	public static boolean isSeeTheBall() {
		return seeTheBall;
	}

	public static void setSeeTheBall(boolean seeTheBall) {
		Ball.seeTheBall = seeTheBall;
	}

	public static float getDistance() {
		return distance;
	}

	public static void setDistance(float distance) {
		Ball.distance = distance;
	}

	public static float getAngleX() {
		return angleX;
	}

	public static void setAngleX(float angleX) {
		Ball.angleX = angleX;
	}

	public static float getAngleY() {
		return angleY;
	}

	public static void setAngleY(float angleY) {
		Ball.angleY = angleY;
	}

	public static float RealDistance() {

		JointPosition2D HeadPos = motion.kinematics.HeadPosition.Calculate();

		float distance = (float) Math.sqrt(Math.pow(Ball.getDistance(), 2)
				+ Math.pow(HeadPos.PositionY, 2));

		float distanceFromFoot = distance + HeadPos.PositionX;

		if (MotionPlaying.getMotionName() != null) {
			if (MotionPlaying.getMotionName().equalsIgnoreCase("turn_left")
					|| MotionPlaying.getMotionName().equalsIgnoreCase(
							"turn_right")) {
				distanceFromFoot = distanceFromFoot + 0.1f;
			}
		}

		return distanceFromFoot;

	}

	public static Boolean BallAtOpponentsHalf(Coordinate Ball) {

		if (Ball.X >= 0) {

			if (TeamState.getTeamSide().equalsIgnoreCase("left")) {

				return true;

			} else {

				return false;

			}

		} else {

			if (TeamState.getTeamSide().equalsIgnoreCase("left")) {

				return false;

			} else {

				return true;

			}

		}

	}

}
