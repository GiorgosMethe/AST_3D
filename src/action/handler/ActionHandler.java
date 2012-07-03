package action.handler;

import action.fsm.GKBGDstates;
import coordination.action.ActionObject;

public class ActionHandler {

	public static void Handle(ActionObject Action) {

		if (Action != null) {

			if(ActionPlaying.getActionPlaying()!=null){
				
				System.out.println("mou stelnei "+Action.getAction());
				System.out.println("ActionPlaying"+ActionPlaying.getActionPlaying().getAction());

				if(ActionPlaying.getActionPlaying().getAction().equalsIgnoreCase("GoKickBallToGoal")){

					if(!Action.getAction().equalsIgnoreCase("GoKickBallToGoal")){

						System.out.println("mhdenizw to kick");
						ActionPlaying.setActionPlaying(Action);
						GKBGDstates.setState("Start");
					}

				}else{

					System.out.println("den kanw kick");
					ActionPlaying.setActionPlaying(Action);

				}
			}else{
				
				System.out.println("den kanw tipota");
				ActionPlaying.setActionPlaying(Action);
				
			}


		} else {
			
			System.out.println("den mou stelnei tpt");
			ActionPlaying.setActionPlaying(null);

		}

	}

}
