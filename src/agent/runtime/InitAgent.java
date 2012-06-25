/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/
package agent.runtime;

import motion.old.CurrentMotion;
import motion.old.MotionTrigger;
import motion.xml.MotionPlaying;
import motion.xml.WalkLeaning;
import perceptor.localization.Coordinate;
import action.fsm.GKBGDstates;
import action.fsm.GKBTTstates;
import action.fsm.GKBstates;
import action.fsm.PKTGstates;
import action.handler.ActionPlaying;
import action.vision.VisionType;
import agent.constraints.Beam;
import agent.constraints.Constraints;
import behavior.old.BehaviorDone;

import communication.utils.MessageType;
import communication.utils.WhoSent;

import connection.TCPSocket.Connection;
import connection.utils.ServerCyrcles;
import coordination.communication.action.ActionMessages;

public class InitAgent {

	public static boolean playerReady;

	public static void Init(String Teamname, int number, Connection con) {

		Beam bm = new Beam();
		String beam = bm.Init(number);
		int cyrcles = ServerCyrcles.getCyrclesNow();
		// boolean AgentInitialized=false;
		if (cyrcles >= 0 && cyrcles < 10) {
			if (cyrcles == 1) {

				System.out.println("Player initialized");

				// init behavior fsm
				GKBstates.setState("Start");

				GKBTTstates.setState("Start");
				GKBTTstates.setTimeout(0);

				PKTGstates.setProperPositionToWalk(new Coordinate(0, 0));
				PKTGstates.setResult(null);
				PKTGstates.setTimeout(0);

				GKBGDstates.setTimeout(0);
				GKBGDstates.setState("Start");
				GKBGDstates.setAngle(0);
				GKBGDstates.setX(0);
				GKBGDstates.setY(0);
				GKBGDstates.setDistance(0);
				GKBGDstates.setBallAngle(0);

				// Old Movement
				CurrentMotion.setSoftChangeCounter(0);
				InitAgent.setPlayerInited(false);
				BehaviorDone.setName("");
				BehaviorDone.setBehaviorDone(true);
				MotionTrigger.setMotion("");

				// XML movement
				MotionPlaying.setMotionName(null);
				MotionPlaying.setMotionPhase(null);
				MotionPlaying.setStartCyrcle(0);
				WalkLeaning.setLean("");

				// Vision Type
				VisionType.setType(1);

				CurrentMotion.setCurrentMotionPlaying("");
				con.sendMessage("(init(unum " + number + ")(teamname "
						+ Teamname + "))");

				// communication
				WhoSent.setCounter(0);
				MessageType.setType(1);
				MessageType.setCommunicationType(0);
				ActionMessages.setTimeout(Constraints.CoordinationTimeout);
				ActionMessages.setPlayer(2);

				// Actions
				ActionPlaying.setActionPlaying(null);

			} else if (cyrcles == 3) {

				con.sendMessage("(beam " + beam + ")");

			}

			MotionTrigger.setMotion("Init");
			if (cyrcles == 9) {
				InitAgent.setPlayerInited(true);
			}
		}

	}

	public static void CreateAgent(Connection con) {
		con.sendMessage("(scene rsg/agent/nao/nao.rsg)");
	}

	public static boolean isPlayerInited() {
		return playerReady;
	}

	public static void setPlayerInited(boolean playerInited) {
		InitAgent.playerReady = playerInited;
	}

}
