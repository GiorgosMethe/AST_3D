/***********************************************************************************
 * Technical University of Crete
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
import perceptor.utils.UpdatePerceptors;
import agent.constraints.Constraints;
import agent.roboviz.RVTester;
import connection.TCPSocket.Connection;
import connection.utils.ServerCyrcles;

public class AgentRuntime {

	public static int num = 0;
	public static String Teamname = "";
	public static int ServerCycles = 0;
	public static int GameCycles = 0;
	public static String host;
	public static int port;
	public static boolean test = false;
	public static boolean isConnected = false;
	public static Connection connection;

	public static void main(String[] args) throws Exception {

		/*
		 * settings
		 */
		if (args.length == 0) {

			host = "127.0.0.1";
			port = 3100;
			num = 1;
			Teamname = "AST_3D";

		} else {

			host = args[0];
			port = Integer.parseInt(args[1]);
			Teamname = args[2];
			num = Integer.parseInt(args[3]);

		}

		/*
		 * This method reads every motion file neccessary
		 */
		ReadMotionFiles.Read();

		/*
		 * This method creates a new connection
		 */

		connection = new Connection(host, port);

		/*
		 * This method establish the connection between agent and the server
		 */

		isConnected = connection.establishConnection();

		/*
		 * This method initialized the agent
		 */

		if (isConnected == true) {

			InitAgent.CreateAgent(connection);

		}

		/*
		 * This method drawing information in the monitor
		 */
		if (num == Constraints.CoordinationPlayer) {

			RVTester.run(null);

		}

		/*
		 * This method is the main-loop of the AST 3D agent
		 */
		while (connection.isConnected()) {

			update(connection);

		}

	}

	/*
	 * This method handles the main-loop of the AST 3D agent. It is called from
	 * the main class, when a new server cycle starts. The main loop is
	 * responsible for enabling all components of the agent system in the
	 * correct sequence, in order to ensure a proper functioning. Be aware of
	 * changing the order, this will definitively have massive effects on the
	 * agent's behavior.
	 */
	public static void update(Connection connection) {

		/*
		 * Update server cycles. This is an important function for the agent
		 * because the whole movement function depends on this Cyclemeter.
		 */
		ServerCyrcles.setCyrclesNow(ServerCycles++);

		/*
		 * Server send agent messages every cycle in order to aqcuire knowledge
		 * about his environment. This message contains information about
		 * vision,joint,hear and other perceptors.
		 */
		UpdatePerceptors.GetPerceptors(connection);

		// init Agent
		if (!InitAgent.isPlayerInited()) {
			InitAgent.Init(Teamname, num, connection);
		}

		/*
		 * Main function agent through communication coordinate with other
		 * agents and plan his behavior
		 */

		AgentFunction.Act();

		/*
		 * At the end of each cycle call the action to send the actual
		 * motor-string (all effector-values) to the server. This string
		 * actually represents the agent's body movement, the head movement and
		 * if there is one, a communication message towards other agents.
		 */
		String Action = AgentFunction.Act + AgentFunction.Head
				+ AgentFunction.Say;

		connection.sendMessage(Action);

	}

}
