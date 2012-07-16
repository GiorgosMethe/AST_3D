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
package perceptor.worldstate;

public class ServerTime {

	public static float time;
	public static String name;

	public ServerTime() {

	}

	public ServerTime(String name, float time) {

		name = ServerTime.getName();
		time = ServerTime.getTime();

	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		ServerTime.name = name;
	}

	public static float getTime() {
		return time;
	}

	public static void setTime(float time) {
		ServerTime.time = time;
	}

}
