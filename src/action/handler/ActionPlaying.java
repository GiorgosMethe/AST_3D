package action.handler;

import coordination.action.ActionObject;

public class ActionPlaying {

	public static ActionObject ActionPlaying;

	public static boolean End;

	public static ActionObject getActionPlaying() {
		return ActionPlaying;
	}

	public static void setActionPlaying(ActionObject actionPlaying) {
		ActionPlaying = actionPlaying;
	}

	public static boolean isEnd() {
		return End;
	}

	public static void setEnd(boolean end) {
		End = end;
	}

}
