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
package coordination.mapping;

import java.util.Vector;

public class PositionMapValues {

	public Vector<PositionMap> PosMap;
	public double cost;

	public PositionMapValues(Vector<PositionMap> posMap, double cost) {

		PosMap = posMap;
		this.cost = cost;
	}

	public Vector<PositionMap> getPosMap() {
		return PosMap;
	}

	public void setPosMap(Vector<PositionMap> posMap) {
		PosMap = posMap;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
