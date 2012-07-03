package agent.runtime;

import communication.utils.MessageType;
import communication.utils.SayEffector;
import connection.utils.ServerCyrcles;
import coordination.main.Coordination;

import perceptor.worldstate.GameState;
import motion.old.MotionTrigger;
import motion.utils.PerformMovement;
import action.fsm.CFstates;
import action.handler.ActionEffector;
import action.sensor.CheckIfFall;
import action.simple.TurnToLocate;
import action.vision.HeadMovement;
import action.vision.VisionType;

public class AgentFunction {

	public static String Act;
	public static String Say;
	public static String Head;

	public static void Act() {

		/*
		 * Agent check if he is fallen on the ground. If yes, he will manage to
		 * understand through this function the his fall, and then he will try
		 * to get up.
		 */
		CheckIfFall.Check();

		
		if(InitAgent.isPlayerInited()){
			
			if (!GameState.getGameState().equalsIgnoreCase("BeforeKickOff")) {

				Say = SayEffector.Say(MessageType.getType());

				Coordination.MakeCoordination();

				if (CFstates.getState().equalsIgnoreCase("Start") ||
						CFstates.getState().equalsIgnoreCase("CheckFRP")) {
					ActionEffector.Act();
				}

				ServerCyrcles.setGameCyrcles(AgentRuntime.GameCycles++);

			}else{
				
				if (CFstates.getState().equalsIgnoreCase("Start") ||
						CFstates.getState().equalsIgnoreCase("CheckFRP")) {
					TurnToLocate.Act();
				}
	
			}
			
			
		}

		Act = PerformMovement.run();

		Head = HeadMovement.MoveHead(VisionType.getType());

	}

}
