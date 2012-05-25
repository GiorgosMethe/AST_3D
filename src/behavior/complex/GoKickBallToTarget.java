package behavior.complex;

import perceptor.vision.Ball;
import localization.Coordinate;
import localization.LocalizationResults;
import localization.TriangleLocalization;
import motion.old.MotionTrigger;
import motion.xml.CheckKickEnd;
import behavior.fsm.GKBTTstates;
import behavior.fsm.GKBstates;
import behavior.fsm.PKTGstates;
import behavior.simple.TurnToBall;
import behavior.simple.TurnToSeeBall;
import behavior.simple.WalkToBall;
import behavior.simple.WalkToTargetAngle;
import behavior.vision.KickSuccess;
import behavior.vision.VisionType;

public class GoKickBallToTarget {

	public static boolean Act(Coordinate Target){

		if(GKBTTstates.getState().equalsIgnoreCase("Start")){

			if(TurnToBall.Act()){
				GKBTTstates.setState("CalculatePosition");
			}

		}else if(GKBTTstates.getState().equalsIgnoreCase("CalculatePosition")){

			if(CalculateValuesToTarget.Act(Target)){
				GKBTTstates.setState("WalkToPosition");
				return true;
			}else{

				GKBTTstates.setState("CalculatePosition");
			}

		}else if(GKBTTstates.getState().equalsIgnoreCase("WalkToPosition")){

			System.out.println("ypologisa :"+PKTGstates.getResult());

			GKBTTstates.setState("StartCycle");


		}else if(GKBTTstates.getState().equalsIgnoreCase("StartCycle")){

			VisionType.setType(1);
			WalkToTargetAngle.Act(PKTGstates.getResult());
			if(Ball.getDistance()<2){

				GKBTTstates.setState("EndCycle");

			}

		}else if(GKBTTstates.getState().equalsIgnoreCase("EndCycle")){

			GoKickBall.Act();
			if(Ball.getDistance()>2){
				GKBTTstates.setState("Start");
				PKTGstates.setResult(0);
			}








			//			if(GKBTTstates.getTimeout()<200){
			//				
			//				int timeout = GKBTTstates.getTimeout();
			//				GKBTTstates.setTimeout((timeout+1));
			//				GKBTTstates.setState("StartCycle");				
			//				
			//			}else{
			//
			//				GKBTTstates.setTimeout(0);
			//				GKBTTstates.setState("CalculatePosition");
			//				PKTGstates.setResult(0);
			//
			//			}


		}

		return false;

	}


}
