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
package motion.xml;

public class Move {

	public String axis_name;
	public float value;

	public Move(String axis_name, float value) {
		this.axis_name = axis_name;
		this.value = value;
	}

	public Move() {
		// TODO Auto-generated constructor stub
	}

	public String getAxis_name() {
		return axis_name;
	}

	public void setAxis_name(String axis_name) {
		this.axis_name = axis_name;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}
