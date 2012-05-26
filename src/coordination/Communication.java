package coordination;

import perceptor.vision.Ball;
import worldState.TeamState;
import agent.AgentType;

public class Communication {

	public static String CoordinationMessageCoder(){
		String message="";

		message="d%"+TeamState.getTeamSide()+"%"+Integer.toString(AgentType.getPlayerNum())+"%"+Float.toString(Ball.getDistance());
		
		
		return message;
		
	}
	
	
	
}
