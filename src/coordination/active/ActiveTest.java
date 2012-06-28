package coordination.active;

import java.util.Vector;

import perceptor.localization.Coordinate;
import coordination.communication.message.CoordinationMessage;
import coordination.main.CoordinationBeliefs;
import coordination.strategy.ActivePositions;

public class ActiveTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ActivePositions.Calculate(new Coordinate(10, 7));
		
		CoordinationMessage a = new CoordinationMessage(0, 7, new Coordinate(-5, 0), new Coordinate(0, 0), 3, 3, 5);
		CoordinationMessage b = new CoordinationMessage(0, 8, new Coordinate(-4, 0), new Coordinate(0, 0), 3, 3, 4);
		CoordinationMessage c = new CoordinationMessage(0, 9, new Coordinate(-6, 0), new Coordinate(0, 0), 3, 3, 6);
		
		Vector<CoordinationMessage> active = new Vector<CoordinationMessage>();
		
		active.add(c);
		active.add(b);
		active.add(a);
		
		ActiveCoordination.Coordinate(active, ActivePositions.ActivePositions, new Coordinate(10, 7));
		
		
		

	}

}
