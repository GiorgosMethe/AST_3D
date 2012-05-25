package behavior.fsm;

public class PKTGstates {

	public static int timeout;
	
	public static double PrefferedAngleToWalk,result;

	public static int getTimeout() {
		return timeout;
	}

	public static void setTimeout(int timeout) {
		PKTGstates.timeout = timeout;
	}

	public static double getPrefferedAngleToWalk() {
		return PrefferedAngleToWalk;
	}

	public static void setPrefferedAngleToWalk(double prefferedAngleToWalk) {
		PrefferedAngleToWalk = prefferedAngleToWalk;
	}

	public static double getResult() {
		return result;
	}

	public static void setResult(double result) {
		PKTGstates.result = result;
	}

}
