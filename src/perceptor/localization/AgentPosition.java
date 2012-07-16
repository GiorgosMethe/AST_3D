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
package perceptor.localization;

public class AgentPosition {

	public static float X, Y, Theta;

	public AgentPosition(double d, double e, double theta2) {
		// TODO Auto-generated constructor stub
	}

	public static float getX() {
		return X;
	}

	public static void setX(float x) {
		X = x;
	}

	public static float getY() {
		return Y;
	}

	public static void setY(float y) {
		Y = y;
	}

	public static float getTheta() {
		return Theta;
	}

	public static void setTheta(float theta) {
		Theta = theta;
	}

}
