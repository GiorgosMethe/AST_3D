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
package perceptor;

public class GyroScope {

	public static float angleX, angleY, angleZ;

	public GyroScope(float angleX, float angleY, float angleZ) {

		angleX = GyroScope.angleX;
		angleY = GyroScope.angleY;
		angleZ = GyroScope.angleZ;
	}

	public static float getAngleX() {
		return angleX;
	}

	public static void setAngleX(float angleX) {
		GyroScope.angleX = angleX;
	}

	public static float getAngleY() {
		return angleY;
	}

	public static void setAngleY(float angleY) {
		GyroScope.angleY = angleY;
	}

	public static float getAngleZ() {
		return angleZ;
	}

	public static void setAngleZ(float angleZ) {
		GyroScope.angleZ = angleZ;
	}

}
