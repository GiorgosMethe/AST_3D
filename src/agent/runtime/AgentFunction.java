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

		if (!GameState.getGameState().equalsIgnoreCase("BeforeKickOff")
				&& InitAgent.isPlayerInited() == true) {

			Say = SayEffector.Say(MessageType.getType());

			Coordination.MakeCoordination();

			if (CFstates.getState().equalsIgnoreCase("Start")) {
				ActionEffector.Act();
			}

			ServerCyrcles.setGameCyrcles(AgentRuntime.GameCycles++);

		}


		Act = PerformMovement.run();

		Head = HeadMovement.MoveHead(VisionType.getType());

	}

}
