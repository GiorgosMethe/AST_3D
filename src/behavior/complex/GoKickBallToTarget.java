package behavior.complex;

import localization.Coordinate;
import behavior.fsm.GKBTTstates;
import behavior.fsm.PKTGstates;
import behavior.simple.TurnToBall;
import behavior.simple.WalkTo;
import behavior.vision.VisionType;

public class GoKickBallToTarget {

	public static boolean Act(Coordinate Target){

		if(GKBTTstates.getState().equalsIgnoreCase("Start")){

			PKTGstates.setProperPositionToWalk(new Coordinate(0, 0));
			if(TurnToBall.Act()){
				GKBTTstates.setState("CalculatePosition");
			}

		}else if(GKBTTstates.getState().equalsIgnoreCase("CalculatePosition")){

			if(CalculateValuesToTarget.Act(Target)){
				GKBTTstates.setState("WalkToPosition");
				return true;
			}

		}else if(GKBTTstates.getState().equalsIgnoreCase("WalkToPosition")){

			System.out.println("ypologisa :"+PKTGstates.getResult());

			GKBTTstates.setState("StartCycle");


		}else if(GKBTTstates.getState().equalsIgnoreCase("StartCycle")){

				VisionType.setType(3);
				if(WalkTo.Act(new Coordinate(PKTGstates.getResult().X,PKTGstates.getResult().Y),(float) PKTGstates.getResult().Theta)){
					GKBTTstates.setState("GoForKick");
					VisionType.setType(1);
				}


		}else if(GKBTTstates.getState().equalsIgnoreCase("GoForKick")){
			
			if(GoKickBall.Act()){
				GKBTTstates.setState("Start");
			}
		}

		return false;

	}


}
