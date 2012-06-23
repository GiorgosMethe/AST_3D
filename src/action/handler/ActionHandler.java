package action.handler;

import coordination.action.ActionObject;

public class ActionHandler {
	
	public static void Handle(ActionObject Action){
		
		
		if(Action != null){
			
			ActionPlaying.setActionPlaying(Action);			
			
		}

	}

}
