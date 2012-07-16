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

import java.util.Vector;

import javax.vecmath.Vector3d;

public class ForceResistancePerceptor {

	public static Vector<ForceResistancePerceptor> ForcePerceptors = new Vector<ForceResistancePerceptor>();

	// point where the force acts
	public Vector3d forceOrigin;
	// the force itself
	public Vector3d force;

	public String name;

	public ForceResistancePerceptor(Vector3d forceOrigin, Vector3d force,
			String name) {

		this.forceOrigin = forceOrigin;
		this.force = force;
		this.name = name;
	}

	public Vector3d getForceOrigin() {
		return forceOrigin;
	}

	public void setForceOrigin(Vector3d forceOrigin) {
		this.forceOrigin = forceOrigin;
	}

	public Vector3d getForce() {
		return force;
	}

	public void setForce(Vector3d force) {
		this.force = force;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
