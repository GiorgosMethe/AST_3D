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
package behavior;

import action.Kick;
import action.TakeGoaliePos;
import action.simple.TurnToBall;
import action.simple.TurnToSeeBall;
import perceptor.vision.Ball;
import perceptor.vision.Vision;

public class Goalie {


	public void BehaviorController(){

		TurnToSeeBall tTsB=new TurnToSeeBall();
		TurnToBall tTb=new TurnToBall();
		Kick Kb=new Kick();
		TakeGoaliePos tGp=new TakeGoaliePos();
		

		if(BehaviorStateMachine.getName().equalsIgnoreCase("Goalie")){

			if(BehaviorStateMachine.getState().equalsIgnoreCase("start")){

				if(Vision.isiSee()==true){

					if(Ball.isSeeTheBall()==true){

						BehaviorStateMachine.setState("iSeeBall");

					}else{
						BehaviorStateMachine.setState("NotSeeBall");
					}

				}else{
					BehaviorStateMachine.setState("start");
				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("iSeeBall")){

				tTb.Act();
				BehaviorStateMachine.setState("takeGoaliePos");


			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("NotSeeBall")){

				
				tTsB.Act();
				BehaviorStateMachine.setState("start");
				
			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("takeGoaliePos")){

				if(Ball.getDistance()>0.5){
					tGp.Act();
					BehaviorStateMachine.setState("takeGoaliePos");
				}else{
					BehaviorStateMachine.setState("Kick");
				}		

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("Kick")){

				if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("")){
					BehaviorDone.setBehaviorDone(false);
					BehaviorDone.setName("Kick");
					Kb.Act();				
					BehaviorStateMachine.setState("Kick");
				}else if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("Kick")){
					BehaviorDone.setName("");
					BehaviorDone.setBehaviorDone(true);
					BehaviorStateMachine.setState("start");
				}else{

				}
			}

		}
	}


}
