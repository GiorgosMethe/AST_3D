package coordination.communication.action;

public class ActionMessages {

	public static int timeout;

	public static int player;

	public static int getTimeout() {
		return timeout;
	}

	public static void setTimeout(int timeout) {
		ActionMessages.timeout = timeout;
	}

	public static int getPlayer() {
		return player;
	}

	public static void setPlayer(int player) {
		ActionMessages.player = player;
	}

}
