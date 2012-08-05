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

import motion.old.CurrentMotion;
import motion.utils.MotionTrigger;
import motion.xml.MotionPlaying;
import motion.xml.WalkLeaning;
import perceptor.localization.Coordinate;
import action.fsm.CFstates;
import action.fsm.GKBGDstates;
import action.fsm.GKBTTstates;
import action.fsm.GKBstates;
import action.fsm.PKTGstates;
import action.fsm.SUstates;
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
			if (cyrcles == 0) {

				System.out.println("Player initialized");

				// init behavior fsm
				GKBstates.setState("Start");

				GKBTTstates.setState("Start");
				GKBTTstates.setTimeout(0);

				PKTGstates.setProperPositionToWalk(new Coordinate(0, 0));
				PKTGstates.setResult(null);
				PKTGstates.setTimeout(0);

				CFstates.setState("Start");
				CFstates.setCheckFRPtimer(0);
				SUstates.setState("Start");

				GKBGDstates.setTimeout(0);
				GKBGDstates.setMoveTimeout(0);
				GKBGDstates.setAngleFromPost1(Double.NaN);
				GKBGDstates.setAngleFromPost2(Double.NaN);
				GKBGDstates.setAngle(0);
				GKBGDstates.setState("Start");

				// Old Movement
				CurrentMotion.setSoftChangeCounter(0);
				CurrentMotion.setCurrentMotionPlaying("");
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
				VisionType.setType(6);

				con.sendMessage("(init(unum " + number + ")(teamname "
						+ Teamname + "))");

				// communication
				WhoSent.setCounter(0);
				MessageType.setType(1);
				MessageType.setCommunicationType(0);
				ActionMessages.setTimeout(Constraints.CoordinationTimeout);
				ActionMessages.setPlayer(0);

				// Actions
				ActionPlaying.setActionPlaying(null);
				ActionPlaying.setEnd(true);

			} else if (cyrcles == 2) {

				con.sendMessage("(beam " + beam + ")");

			}

			
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
