package perceptor.localization;

import agent.constraints.Constraints;

public class OutOfField {

	public static boolean Check(Coordinate agent) {

		if ((Math.abs(agent.getX()) > (Constraints.FieldLength / 2))
				|| ((Math.abs(agent.getY()) > (Constraints.FieldWidth / 2)))) {

			return true;

		} else {

			return false;

		}

	}

}
