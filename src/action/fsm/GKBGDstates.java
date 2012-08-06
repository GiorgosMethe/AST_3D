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
package action.fsm;

public class GKBGDstates {

	public static String State;
	public static int timeout, moveTimeout;
	public static double angle, X, Y, distanceFromPost1, distanceFromPost2,
			distance, ballAngle, angleFromGoal, angleFromPost1, angleFromPost2;

	public static double getAngleFromGoal() {
		return angleFromGoal;
	}

	public static void setAngleFromGoal(double angleFromGoal) {
		GKBGDstates.angleFromGoal = angleFromGoal;
	}

	public static double getDistance() {
		return distance;
	}

	public static void setDistance(double distance) {
		GKBGDstates.distance = distance;
	}

	public static double getBallAngle() {
		return ballAngle;
	}

	public static void setBallAngle(double ballAngle) {
		GKBGDstates.ballAngle = ballAngle;
	}

	public static double getX() {
		return X;
	}

	public static void setX(double x) {
		X = x;
	}

	public static double getY() {
		return Y;
	}

	public static void setY(double y) {
		Y = y;
	}

	public static String getState() {
		return State;
	}

	public static void setState(String state) {
		State = state;
	}

	public static int getTimeout() {
		return timeout;
	}

	public static void setTimeout(int timeout) {
		GKBGDstates.timeout = timeout;
	}

	public static double getAngle() {
		return angle;
	}

	public static void setAngle(double angle) {
		GKBGDstates.angle = angle;
	}

	public static double getAngleFromPost1() {
		return angleFromPost1;
	}

	public static void setAngleFromPost1(double angleFromPost1) {
		GKBGDstates.angleFromPost1 = angleFromPost1;
	}

	public static double getAngleFromPost2() {
		return angleFromPost2;
	}

	public static void setAngleFromPost2(double angleFromPost2) {
		GKBGDstates.angleFromPost2 = angleFromPost2;
	}

	public static int getMoveTimeout() {
		return moveTimeout;
	}

	public static void setMoveTimeout(int moveTimeout) {
		GKBGDstates.moveTimeout = moveTimeout;
	}

	public static double getDistanceFromPost1() {
		return distanceFromPost1;
	}

	public static void setDistanceFromPost1(double distanceFromPost1) {
		GKBGDstates.distanceFromPost1 = distanceFromPost1;
	}

	public static double getDistanceFromPost2() {
		return distanceFromPost2;
	}

	public static void setDistanceFromPost2(double distanceFromPost2) {
		GKBGDstates.distanceFromPost2 = distanceFromPost2;
	}

}
