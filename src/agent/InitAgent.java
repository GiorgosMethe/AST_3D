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

import localization.Coordinate;
import motion.old.CurrentMotion;
import motion.old.MotionTrigger;
import motion.xml.MotionPlaying;
import motion.xml.WalkLeaning;
import behavior.fsm.GKBTTstates;
import behavior.fsm.GKBstates;
import behavior.fsm.PKTGstates;
import behavior.old.BehaviorDone;
import behavior.old.BehaviorStateMachine;
import behavior.vision.VisionType;

import communication.handler.WhoSent;

import connection.Connection;
import connection.ServerCyrcles;

public class InitAgent {

	public static boolean playerReady;
	

	public static void Init(String Teamname, int number,Connection con){

		Beam bm=new Beam();
		String beam=bm.Init(number);
		int cyrcles=ServerCyrcles.getCyrclesNow();
		//boolean AgentInitialized=false;
		if(cyrcles>=0 && cyrcles<10){
			if(cyrcles==1){
				
				if(number==1){
					new BehaviorStateMachine("Goalie","start");
				}else{
					new BehaviorStateMachine("goToPos","start");
				}
				
				//init behavior fsm
				GKBstates.setState("Start");
				GKBTTstates.setState("Start");
				GKBTTstates.setTimeout(0);
				PKTGstates.setProperPositionToWalk(new Coordinate(0, 0));
				PKTGstates.setResult(null);
				PKTGstates.setTimeout(0);
				
				//Old Movement
				CurrentMotion.setSoftChangeCounter(0);
				InitAgent.setPlayerInited(false);
				BehaviorDone.setName("");
				BehaviorDone.setBehaviorDone(true);
				MotionTrigger.setMotion("");
				
				//XML movement
				MotionPlaying.setMotionName(null);	
				MotionPlaying.setMotionPhase(null);
				MotionPlaying.setStartCyrcle(0);
				WalkLeaning.setLean("");
				
				//Vision Type
				VisionType.setType(1);
				
				CurrentMotion.setCurrentMotionPlaying("");
				con.sendMessage("(init(unum "+number+")(teamname "+Teamname+"))");
				AgentType.setPlayerNum(number);
				WhoSent.setCounter(1);
				

			}else if(cyrcles==3){

				con.sendMessage("(beam "+beam+")");

			}
			
			MotionTrigger.setMotion("Init");
			if(cyrcles==9){
				InitAgent.setPlayerInited(true);
			}
		}

	}

	public static void CreateAgent(Connection con){
		con.sendMessage("(scene rsg/agent/nao/nao.rsg)");
	}

	public static boolean isPlayerInited() {
		return playerReady;
	}

	public static void setPlayerInited(boolean playerInited) {
		InitAgent.playerReady = playerInited;
	}



}
