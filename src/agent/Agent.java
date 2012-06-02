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
package agent;

import localization.BallPosition;
import motion.old.CurrentMotion;
import motion.old.MotionStorage;
import motion.old.MotionTrigger;
import motion.xml.XMLMotionStorage;
import motion.xml.XMLMovement;
import perceptor.Perceptors;
import perceptor.isFallen;
import worldState.GameState;
import action.complex.GoKickBallToGoal;
import action.fsm.GKBstates;
import action.vision.SeekBall;
import action.vision.VisionType;

import communication.handler.MessageType;
import communication.handler.SayEffector;

import connection.Connection;
import connection.ServerCyrcles;


public class Agent {


	public static int num=0;
	@SuppressWarnings("unused")
	private static CurrentMotion mt;
	@SuppressWarnings("unused")
	private static float max;

	public static String Teamname="";
	
	public static void main(String[] args) {

		Perceptors Gp = new Perceptors();
		SeekBall Sb = new SeekBall();
		SayEffector sm = new SayEffector();
		//Think think=new Think();
		isFallen iF=new isFallen();
		MotionStorage Ms=new MotionStorage();
		XMLMotionStorage nMs=new XMLMotionStorage();
		XMLMovement pXML=new XMLMovement();
		
		///
		GKBstates.setState("GoToBall");

		//connection config
		String host = "127.0.0.1";
		int port=3100;
		
		//initializes the connection
		Connection con = new Connection(host,port);

		//read old .motion files
		System.out.print("loading old .motion files");
		Ms.StoreMotions();
		System.out.println("OK");

		//read new XML motion files
		System.out.print("loading new .XML files");
		nMs.StoreMotions();
		System.out.println("OK");



		boolean isConnected = false;
		//establish the connection between agent and server
		isConnected = con.establishConnection();
		//Creation of Nao robot
		if(isConnected==true){
			InitAgent.CreateAgent(con);
		}
		//server cyrcles
		int i=0;
		int j=0;
		
		//player number
		num=11;
		Teamname="e";
		// team name
		
		while(con.isConnected()){

			//update server cyrcles
			i++;
			
			//update perceptors
			Gp.GetPerceptors(con);
			
			//update ball position
			BallPosition.WhereIsTheBall();
			
			//update server cyrcles
			ServerCyrcles.setCyrclesNow(i);
			
			//init Agent
			InitAgent.Init(Teamname, num, con);
			//think
			
			String AgentAct="";
			String SayEffector = "";
			if(!GameState.getGameState().equalsIgnoreCase("BeforeKickOff") && InitAgent.isPlayerInited()==true){	
				
				SayEffector = sm.Say(MessageType.getType(), con);
				
				if(MotionTrigger.getMotion().equalsIgnoreCase("Forwards50")){
					AgentAct = pXML.execute("walk_fine");
				}else if(MotionTrigger.getMotion().equalsIgnoreCase("TurnLeft40")){
					AgentAct = pXML.execute("turn_left");
				}else if(MotionTrigger.getMotion().equalsIgnoreCase("TurnRight40")){
					AgentAct= pXML.execute("turn_right");
				}else if(MotionTrigger.getMotion().equalsIgnoreCase("SideStepRight")){
					AgentAct= pXML.execute("strafe_right");
				}else if(MotionTrigger.getMotion().equalsIgnoreCase("SideStepLeft")){
					AgentAct= pXML.execute("strafe_left");
				}else if(MotionTrigger.getMotion().equalsIgnoreCase("KickForwardRight")||MotionTrigger.getMotion().equalsIgnoreCase("KickForwardLeft")){
					AgentAct= pXML.execute("strong_right_kick");
				}else{
					AgentAct= pXML.execute("");
				}
				
				j=j+1;
				ServerCyrcles.setGameCyrcles(j);
				
			}
			
			/****************************experiments***************************/

			/*******************************************************************/
			
			
			
			//check if i am down
			iF.Check();
		
			//get the head movement
			String headAct=Sb.MoveHead(VisionType.getType());
			//String headAct=Sb.MoveHead(1);

			//create the hole agents actions
			String Act=headAct+AgentAct+SayEffector;
			
			//Act
			con.sendMessage(Act);
			
			

		}

	}
}
