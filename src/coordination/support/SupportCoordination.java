package coordination.support;

import coordination.action.ActionObject;
import coordination.action.ActionTable;
import coordination.communication.message.CoordinationVectorUpdate;
import coordination.strategy.TeamFormation;

public class SupportCoordination {

	public static void Coordinate() {

		for (int i = 0; i < CoordinationVectorUpdate.CoordinationVector.size(); i++) {

			ActionObject a = new ActionObject(

					CoordinationVectorUpdate.CoordinationVector.elementAt(i)
							.getNumber(),
					"WalkToCoordinate",
					TeamFormation.TeamFormation[CoordinationVectorUpdate.CoordinationVector
							.elementAt(i).getNumber()].getX(),
					TeamFormation.TeamFormation[CoordinationVectorUpdate.CoordinationVector
							.elementAt(i).getNumber()].getY(), 0, 0);

			ActionTable.CoordinateActions.addElement(a);

		}

	}

}
