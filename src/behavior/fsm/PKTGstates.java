package behavior.fsm;

public class PKTGstates {

	public static String State;
	public static int timeout;
	
	public static double X;
	public static double Y;
	public static double Theta;
	public static double PrefferedAngleToKick;
	
	public static String getState() {
		return State;
	}

	public static void setState(String state) {
		State = state;
	}

	public static int getTimeout() {
		return timeout;
	}

	public static void setTimeout(int timeout) {
		PKTGstates.timeout = timeout;
	}

	public static double getX() {
		return X;
	}

	public static void setX(double x) {
		X = x;
	}

	public static double getY() {
		return Y;
	}

	public static void setY(double y) {
		Y = y;
	}

	public static double getTheta() {
		return Theta;
	}

	public static void setTheta(double theta) {
		Theta = theta;
	}

	public static double getPrefferedAngleToKick() {
		return PrefferedAngleToKick;
	}

	public static void setPrefferedAngleToKick(double prefferedAngleToKick) {
		PrefferedAngleToKick = prefferedAngleToKick;
	}

	
}
