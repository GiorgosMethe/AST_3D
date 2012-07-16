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

import perceptor.localization.Coordinate;
import coordination.communication.message.CoordinationMessage;

public class PositionMap {

	public CoordinationMessage Agent;
	public Coordinate Position;

	public PositionMap(CoordinationMessage agent, Coordinate position) {

		Agent = agent;
		Position = position;
	}

	public CoordinationMessage getAgent() {
		return Agent;
	}

	public void setAgent(CoordinationMessage agent) {
		Agent = agent;
	}

	public Coordinate getPosition() {
		return Position;
	}

	public void setPosition(Coordinate position) {
		Position = position;
	}

}
