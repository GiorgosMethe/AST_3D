package action.handler;

import coordination.action.ActionObject;

public class ActionHandler {

	public static void Handle(ActionObject Action) {

		if (Action != null) {

			if(ActionPlaying.isEnd()){
				
				ActionPlaying.setActionPlaying(Action);
			
			}else{
			
				
			
			}
				

		} else {
			
			ActionPlaying.setActionPlaying(null);

		}

	}

}
