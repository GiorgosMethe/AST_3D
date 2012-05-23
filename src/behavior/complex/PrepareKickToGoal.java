package behavior.complex;

import perceptor.HingeJointPerceptor;
import localization.BallPosition;
import localization.Coordinate;
import localization.LocalizationResults;
import localization.TriangleLocalization;
import motion.old.MotionTrigger;
import agent.NAOConstraints;
import behavior.fsm.PKTGstates;
import behavior.vision.VisionType;



public class PrepareKickToGoal {

	public static boolean Act(){

		if(PKTGstates.getState().equalsIgnoreCase("Start")){
			VisionType.setType(2);		

			if(PKTGstates.getTimeout()<100){

				int timeout = PKTGstates.getTimeout();
				PKTGstates.setTimeout((timeout+1));

			}else{

				PKTGstates.setTimeout(0);
				PKTGstates.setState("StartTakingPosition");
				PKTGstates.setTheta(LocalizationResults.getBody_angle());
				PKTGstates.setX(LocalizationResults.getCurrent_location().X);
				PKTGstates.setY(LocalizationResults.getCurrent_location().Y);
				PKTGstates.setPrefferedAngleToKick(TriangleLocalization.FindAngle(NAOConstraints.OpponentGoal));
				System.out.println(LocalizationResults.getBody_angle());
				System.out.println(LocalizationResults.getCurrent_location().X);
				System.out.println(LocalizationResults.getCurrent_location().Y);

			}

		}else if(PKTGstates.getState().equalsIgnoreCase("StartTakingPosition")){

			VisionType.setType(1);
			if(PKTGstates.getTimeout()<150){

				int timeout = PKTGstates.getTimeout();
				PKTGstates.setTimeout((timeout+1));

				if(Math.abs(PKTGstates.getTheta()-PKTGstates.getPrefferedAngleToKick() )>20){


					if((PKTGstates.getTheta()-PKTGstates.getPrefferedAngleToKick())>0 &&
							(PKTGstates.getTheta()-PKTGstates.getPrefferedAngleToKick())<180){
						
						if(Math.abs((HingeJointPerceptor.getHj1()+BallPosition.getAngle()))>5){

							MotionTrigger.setMotion("TurnRight40");

						}else{
							
							MotionTrigger.setMotion("SideStepLeft");
							
						}
						
					}else{
						
						if(Math.abs((HingeJointPerceptor.getHj1()+BallPosition.getAngle()))>5){

							MotionTrigger.setMotion("TurnLeft40");

						}else{
							
							MotionTrigger.setMotion("SideStepRight");
							
						}
					}


				}else{
					
					MotionTrigger.setMotion("");
					PKTGstates.setState("Start");
					return true;
				}

			}else{

				PKTGstates.setState("StartTurningPosition");
				PKTGstates.setTimeout(0);
			}


		}else if(PKTGstates.getState().equalsIgnoreCase("StartTurningPosition")){

			MotionTrigger.setMotion("");
			PKTGstates.setState("Start");


		}

		return false;	
	}
}
