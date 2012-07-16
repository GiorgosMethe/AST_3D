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
package perceptor.sensors;

public class Accelerometer {

	public static float accX, accY, accZ;

	public Accelerometer(float accX, float accY, float accZ) {

		accX = Accelerometer.accX;
		accY = Accelerometer.accY;
		accZ = Accelerometer.accZ;

	}

	public static float getAccX() {
		return accX;
	}

	public static void setAccX(float accX) {
		Accelerometer.accX = accX;
	}

	public static float getAccY() {
		return accY;
	}

	public static void setAccY(float accY) {
		Accelerometer.accY = accY;
	}

	public static float getAccZ() {
		return accZ;
	}

	public static void setAccZ(float accZ) {
		Accelerometer.accZ = accZ;
	}

}
