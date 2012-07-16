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

import java.util.Vector;

public class Motion {

	public String name, firstPhase;
	public Vector<Phase> phases = new Vector<Phase>();

	public Motion(String name, String firstPhase, Vector<Phase> phases) {
		this.name = name;
		this.firstPhase = firstPhase;
		this.phases = phases;
	}

	public Motion() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstPhase() {
		return firstPhase;
	}

	public void setFirstPhase(String firstPhase) {
		this.firstPhase = firstPhase;
	}

	public Vector<Phase> getPhases() {
		return phases;
	}

	public void setPhases(Vector<Phase> phases) {
		this.phases = phases;
	}

}
