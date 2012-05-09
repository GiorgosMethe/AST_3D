package agent;
import communication.HearMessage;
import communication.SendMessage;
import localization.BallPosition;
import localization.LocalizationResults;
import motions.CurrentMotion;
import motions.MotionController;
import motions.MotionStorage;
import motions.MotionTrigger;
import motions.Motions;
import newMotions.Motion;
import newMotions.NewMotionStorage;
import newMotions.MotionPlaying;
import newMotions.ReadXMLFile;
import newMotions.XMLMovement;
import behavior.Think;
import action.SeekBall;
import connection.Connection;
import connection.MessageController;
import connection.ServerCyrcles;
import worldState.GameState;
import java.lang.String;

import perceptor.isFallen;


public class Agent {


	public static int num=0;
	@SuppressWarnings("unused")
	private static CurrentMotion mt;
	@SuppressWarnings("unused")
	private static float max;

	public static String Teamname="";
	public static void main(String[] args) {

		Check Ch=new Check();
		MessageController Gp = new MessageController();
		SeekBall Sb = new SeekBall();
		SendMessage sm = new SendMessage();
		MotionController dnc=new MotionController();
		Think think=new Think();
		isFallen iF=new isFallen();
		MotionStorage Ms=new MotionStorage();
		NewMotionStorage nMs=new NewMotionStorage();
		XMLMovement pXML=new XMLMovement();

		//connection config
		//String host = args[0];
		String host = "127.0.0.1";
		//int port = Integer.parseInt(args[1]);
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
		max = 0;
		//player number
		//num=7;
		num=7;
		Teamname="tuc";
		// team name
		//String Teamname=args[2];
		//player position
		Ch.Number(num);
		
		long time,time1=0,time2 = 0;
		while(con.isConnected()){

			i++;
			time=System.nanoTime();
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
			if(!GameState.getGameState().equalsIgnoreCase("BeforeKickOff") && InitAgent.isPlayerInited()==true){	
				think.Role(num);
				sm.Say("distance", con);
				HearMessage.MessageDecoder();
				System.out.println("###################33------->>>>>>>>"+MotionTrigger.getMotion());
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
					AgentAct= pXML.execute("rigth_front_front_kick");
				}else{
					AgentAct= pXML.execute("");
				}
			}
			
			//check if i am down
			iF.Check();
		
			//get the head movement
			String headAct=Sb.MoveHead();
		
			//create the hole agents actions
			String Act=headAct+AgentAct;
			//Act
			con.sendMessage(Act);
			
			long time3 = System.nanoTime()-time;

			System.out.println("avg time to do all:"+time3);

		}

	}
}