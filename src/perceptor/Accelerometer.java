/***********************************************************************************
 * 				  Copyright 2012, Technical University of Crete				       *
 * 							 Academic Year 2011-2012					           *
 ***********************************************************************************
 * 								Thesis Project								       *
 ***********************************************************************************
 * @author Methenitis Georgios													   *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League*
 * Start date: 25-04-2012														   *																	 
 * End date  : xx-xx-2012														   *																			   *
 ***********************************************************************************/
package perceptor;

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
