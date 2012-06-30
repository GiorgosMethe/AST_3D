package agent.runtime;

import motion.utils.PerformMovement;
import perceptor.utils.isFallen;
import perceptor.worldstate.GameState;
import action.handler.ActionEffector;
import action.vision.HeadMovement;
import action.vision.VisionType;

import communication.utils.MessageType;
import communication.utils.SayEffector;

import connection.utils.ServerCyrcles;
import coordination.main.Coordination;

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
		isFallen.Check();

		if (!GameState.getGameState().equalsIgnoreCase("BeforeKickOff")
				&& InitAgent.isPlayerInited() == true) {

			Say = SayEffector.Say(MessageType.getType());

			Coordination.MakeCoordination();

			ActionEffector.Act();

			ServerCyrcles.setGameCyrcles(AgentRuntime.GameCycles++);

		}

		Act = PerformMovement.run();

		Head = HeadMovement.MoveHead(VisionType.getType());

	}

}
