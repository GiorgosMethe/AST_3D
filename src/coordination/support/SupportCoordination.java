package coordination.support;

import java.util.Vector;

import coordination.action.ActionObject;
import coordination.action.ActionTable;
import coordination.communication.message.CoordinationMessage;
import coordination.strategy.TeamFormation;

public class SupportCoordination {

	public static void Coordinate(
			Vector<CoordinationMessage> coordinationVector,
			perceptor.localization.Coordinate ball) {

		TeamFormation.Calculate(ball);

		for (int i = 0; i < coordinationVector.size(); i++) {

			ActionObject a = new ActionObject(

			coordinationVector.elementAt(i).getNumber(), "WalkToCoordinate",
					TeamFormation.TeamFormation[coordinationVector.elementAt(i)
							.getNumber()].getX(),
					TeamFormation.TeamFormation[coordinationVector.elementAt(i)
							.getNumber()].getY(), 0, 0);

			ActionTable.CoordinateActions.addElement(a);

		}

	}

}
