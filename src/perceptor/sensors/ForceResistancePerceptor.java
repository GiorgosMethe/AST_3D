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
package perceptor.sensors;


//import javax.vecmath.Vector3d;

import javax.vecmath.Vector3d;

//import org.apache.commons.math.geometry.Vector3D;


public class ForceResistancePerceptor {
	// point where the force acts
	public static Vector3d forceOrigin;

	// the force itself
	public static Vector3d force;
	
	public static String name;

	/**
	 * Default constructor, initializes origin and force to (0.0, 0.0, 0.0)
	 * @param name the name of the sensor
	 */	
	public ForceResistancePerceptor(String name, float fox, float foy,
			float foz, float fx, float fy, float fz)
	{
		name = ForceResistancePerceptor.name;
		forceOrigin = new Vector3d(fox, foy, foz);
		force = new Vector3d(fx, fy, fz);
	}

	public Vector3d getForceOrigin()
	{
		return forceOrigin;
	}

	public Vector3d getForce()
	{
		return force;
	}

	public static void setForceOrigin(Vector3d forceOr) {
		ForceResistancePerceptor.forceOrigin = forceOr;
	}

	public static void setForce(Vector3d force) {
		ForceResistancePerceptor.force = force;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		ForceResistancePerceptor.name = name;
	}

	
	
}