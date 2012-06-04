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
