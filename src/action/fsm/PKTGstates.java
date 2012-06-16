package action.fsm;

import perceptor.localization.CompleteCoordinate;
import perceptor.localization.Coordinate;

public class PKTGstates {

	public static int timeout;

	public static Coordinate ProperPositionToWalk;
	public static CompleteCoordinate result;

	public static int getTimeout() {
		return timeout;
	}

	public static void setTimeout(int timeout) {
		PKTGstates.timeout = timeout;
	}

	public static Coordinate getProperPositionToWalk() {
		return ProperPositionToWalk;
	}

	public static void setProperPositionToWalk(Coordinate properPositionToWalk) {
		ProperPositionToWalk = properPositionToWalk;
	}

	public static CompleteCoordinate getResult() {
		return result;
	}

	public static void setResult(CompleteCoordinate result) {
		PKTGstates.result = result;
	}

}
