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
package worldState;

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
