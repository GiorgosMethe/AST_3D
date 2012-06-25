package coordination.mapping;

import perceptor.localization.Coordinate;
import coordination.communication.message.CoordinationMessage;

public class PositionMapping {

	public CoordinationMessage Agent;
	public Coordinate Position;

	public PositionMapping(CoordinationMessage agent, Coordinate position) {

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
