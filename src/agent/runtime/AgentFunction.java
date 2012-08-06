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
package agent.runtime;

import motion.utils.PerformMovement;
import perceptor.worldstate.GameState;
import action.handler.ActionEffector;
import action.sensor.CheckIfFall;
import action.vision.HeadMovement;
import action.vision.VisionType;
import agent.constraints.Beam;
import behavior.goalie.Goalie;

import communication.utils.MessageType;
import communication.utils.SayEffector;

import connection.utils.ServerCyrcles;
import coordination.main.Coordination;

public class AgentFunction {

	public static String Act;
	public static String Say;
	public static String Head;
	public static String BeamEff;

	public static float angle = 0, angleSum = 0;
	public static double turn = 0;

	public static void Act() {

		/*
		 * Agent check if he is fallen on the ground. If yes, he will manage to
		 * understand through this function the he is fallen, and then he will
		 * try to get up.
		 */
		CheckIfFall.Check();

		if (InitAgent.isPlayerInited()) {

			if (!GameState.getGameState().equalsIgnoreCase("BeforeKickOff")) {

				Say = SayEffector.Say(MessageType.getType());

				Coordination.MakeCoordination();

				if (!CheckIfFall.fallen) {
					if (AgentRuntime.num == 1) {

						Goalie.Act();

					} else {

						ActionEffector.Act();

					}
				}

				ServerCyrcles.setGameCyrcles(AgentRuntime.GameCycles++);

			} else {

				VisionType.setType(6);

			}

		}

		Act = PerformMovement.run();

		Head = HeadMovement.MoveHead(VisionType.getType());

		BeamEff = Beam.BeamEffector();

	}

}
