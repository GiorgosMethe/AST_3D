package agent.runtime;

import motion.old.MotionTrigger;
import motion.utils.PerformMovement;
import action.fsm.CFstates;
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
		//
		// if (!GameState.getGameState().equalsIgnoreCase("BeforeKickOff")
		// && InitAgent.isPlayerInited() == true) {
		//
		// Say = SayEffector.Say(MessageType.getType());
		//
		// Coordination.MakeCoordination();
		//
		// ActionEffector.Act();
		//
		// ServerCyrcles.setGameCyrcles(AgentRuntime.GameCycles++);
		//
		// }

		if (CFstates.getState().equalsIgnoreCase("Start")) {
			MotionTrigger.setMotion("Forwards50");
		}

		Act = PerformMovement.run();

		Head = HeadMovement.MoveHead(VisionType.getType());

	}

}
