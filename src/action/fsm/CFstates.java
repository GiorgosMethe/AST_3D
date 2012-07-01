package action.fsm;

public class CFstates {

	public static String State;
	public static int CheckFRPtimer;

	public static String getState() {
		return State;
	}

	public static void setState(String state) {
		State = state;
	}

	public static int getCheckFRPtimer() {
		return CheckFRPtimer;
	}

	public static void setCheckFRPtimer(int checkFRPtimer) {
		CheckFRPtimer = checkFRPtimer;
	}

}
