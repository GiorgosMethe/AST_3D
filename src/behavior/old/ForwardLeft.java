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
package behavior.old;

import localization.BallPosition;
import motion.old.MotionTrigger;
import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;
import perceptor.vision.Vision;
import action.general.GetPosToGoal;
import action.general.GetUp;
import action.general.GoToPos;
import action.general.Kick;
import action.general.StandUp;
import action.general.TurnOver;
import action.simple.TurnToBall;
import action.simple.TurnToSeeBall;
import action.simple.WalkToBall;

public class ForwardLeft {

	
	TurnToSeeBall tTsB=new TurnToSeeBall();
	TurnToBall tTb=new TurnToBall();
	WalkToBall wTb=new WalkToBall();
	Kick Kb=new Kick();
	GetPosToGoal gPtG = new GetPosToGoal();
	GoToPos gTp= new GoToPos();
	StandUp sU=new StandUp();
	TurnOver tO=new TurnOver();
	GetUp gU=new GetUp();

	public void BehaviorController(){


		////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////go kick the ball////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////




		if(BehaviorStateMachine.getName().equalsIgnoreCase("goKickTheBall")){

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
				BehaviorStateMachine.setState("walkToBall");


			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("NotSeeBall")){


				tTsB.Act();

				BehaviorStateMachine.setState("start");

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("goBall")){

				if(Ball.getDistance()>0.5){
					wTb.Act();
					BehaviorStateMachine.setState("goBall");
				}else{
					BehaviorStateMachine.setState("StraightToBall");


				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("StraightToBall")){

				if(Math.abs((HingeJointPerceptor.getHj1()+BallPosition.getAngle()))>15){

					if(HingeJointPerceptor.getHj1()>0){
						MotionTrigger.setMotion("TurnLeft40");

					}else{
						MotionTrigger.setMotion("TurnRight40");

					}
					
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






			////////////////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////kick the ball to goal////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////






		}else if(BehaviorStateMachine.getName().equalsIgnoreCase("KickTheBallToGoal")){

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
				BehaviorStateMachine.setState("walkToBall");


			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("NotSeeBall")){


				tTsB.Act();

				BehaviorStateMachine.setState("start");

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("walkToBall")){

				if(Ball.getDistance()>0.6){
					wTb.Act();
					BehaviorStateMachine.setState("walkToBall");
				}else{
					BehaviorStateMachine.setState("GetPosToGoal");


				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("GetPosToGoal")){

				gPtG.Act();


			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("goBall")){

				if(Ball.getDistance()>0.5){
					wTb.Act();
					BehaviorStateMachine.setState("goBall");
				}else{
					BehaviorStateMachine.setState("StraightToBall");


				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("StraightToBall")){

				if(Math.abs((HingeJointPerceptor.getHj1()+BallPosition.getAngle()))>15){

					if(HingeJointPerceptor.getHj1()>0){
						MotionTrigger.setMotion("TurnLeft40");

					}else{
						MotionTrigger.setMotion("TurnRight40");

					}
					
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


			////////////////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////go to position///////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////

		}else if(BehaviorStateMachine.getName().equalsIgnoreCase("goToPos")){

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

				if(Ball.getDistance()>4){

					gTp.Act();
					BehaviorStateMachine.setState("start");

				}else{
					MotionTrigger.setMotion("");
					BehaviorStateMachine.setState("start");
				}


			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("NotSeeBall")){


				tTsB.Act();

				BehaviorStateMachine.setState("start");

			}

			//////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////robot fall//////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////////////////////

		}else if(BehaviorStateMachine.getName().equalsIgnoreCase("Fallen")){
			if(BehaviorStateMachine.getState().equalsIgnoreCase("start")){
				BehaviorDone.setName("");
				BehaviorDone.setBehaviorDone(true);
				BehaviorStateMachine.setState("turnOver");

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("turnOver")){

				if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("")){
					BehaviorDone.setBehaviorDone(false);
					BehaviorDone.setName("turnOver");
					tO.Act();				
				}else if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("turnOver")){
					BehaviorDone.setName("");
					BehaviorDone.setBehaviorDone(true);
					BehaviorStateMachine.setState("standup");
				}else{

				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("standup")){

				if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("")){
					BehaviorDone.setBehaviorDone(false);
					BehaviorDone.setName("standup");
					sU.Act();				
				}else if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("standup")){
					BehaviorDone.setName("");
					BehaviorDone.setBehaviorDone(true);
					BehaviorStateMachine.setState("getup");
				}else{

				}

			}else if(BehaviorStateMachine.getState().equalsIgnoreCase("getup")){

				if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("")){
					BehaviorDone.setBehaviorDone(false);
					BehaviorDone.setName("getup");
					gU.Act();				
				}else if(BehaviorDone.isBehaviorDone()==true && BehaviorDone.getName().equalsIgnoreCase("getup")){
					BehaviorDone.setName("");
					BehaviorDone.setBehaviorDone(true);
					BehaviorStateMachine.setState("KickTheBallToGoal");
					BehaviorStateMachine.setName("start");
				}else{

				}





			}


		}










	}


}
