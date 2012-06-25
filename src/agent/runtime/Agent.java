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

import motion.utils.ReadMotionFiles;
import motion.xml.RunXML;
import perceptor.localization.BallPosition;
import perceptor.utils.UpdatePerceptors;
import perceptor.utils.isFallen;
import perceptor.worldstate.GameState;
import action.fsm.GKBstates;
import action.handler.ActionEffector;
import action.vision.HeadMovement;
import action.vision.VisionType;

import communication.utils.MessageType;
import communication.utils.SayEffector;

import connection.TCPSocket.Connection;
import connection.utils.ServerCyrcles;
import coordination.main.Coordination;

public class Agent {

	public static int num = 0;
	public static String Teamname = "";

	public static void main(String[] args) throws Exception {

		UpdatePerceptors Gp = new UpdatePerceptors();
		HeadMovement Sb = new HeadMovement();
		SayEffector sm = new SayEffector();
		isFallen iF = new isFallen();
		ReadMotionFiles.Read();

		// /
		GKBstates.setState("GoToBall");

		// connection config
		// String host = "192.168.1.1";
		String host = "127.0.0.1";
		int port = 3100;

		// initializes the connection
		Connection con = new Connection(host, port);

		boolean isConnected = false;
		// establish the connection between agent and server
		isConnected = con.establishConnection();
		// Creation of Nao robot
		if (isConnected == true) {
			InitAgent.CreateAgent(con);
			// RVTester.Roboviz(null);
		}
		// server cyrcles
		int i = 0;
		int j = 0;

		// player number
		num = 9;
		Teamname = "AST_3D";
		// team name

		while (con.isConnected()) {

			// update server cyrcles
			i++;

			// update perceptors
			Gp.GetPerceptors(con);

			// update ball position
			BallPosition.WhereIsTheBall();

			// update server cyrcles
			ServerCyrcles.setCyrclesNow(i);

			// init Agent
			if (!InitAgent.isPlayerInited()) {
				InitAgent.Init(Teamname, num, con);
			}

			String AgentAct = "";
			String SayEffector = "";

			if (!GameState.getGameState().equalsIgnoreCase("BeforeKickOff")
					&& InitAgent.isPlayerInited() == true) {

				/**************************** experiments ***************************/

				SayEffector = sm.Say(MessageType.getType(), con);
				Coordination.MakeCoordination();

				ActionEffector.Act();
				/*******************************************************************/

				AgentAct = RunXML.run();

				j = j + 1;
				ServerCyrcles.setGameCyrcles(j);

			}

			// check if i am down
			iF.Check();

			// get the head movement
			String headAct = Sb.MoveHead(VisionType.getType());

			// create the hole agents actions
			String Act = headAct + AgentAct + SayEffector;

			// Act
			con.sendMessage(Act);

		}

	}
}
