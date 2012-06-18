package coordination.main;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import coordination.action.ActionObject;
import coordination.communication.CoordinationMessage;

public class CoordinationSplitter {
	
	public static Vector<CoordinationMessage> coordinationSubset1 = new Vector<CoordinationMessage>();
	public static Vector<CoordinationMessage> coordinationSubset2 = new Vector<CoordinationMessage>();
	public static Vector<CoordinationMessage> coordinationSubset3 = new Vector<CoordinationMessage>();

	
	public static void Split(Vector<CoordinationMessage> coordinationVector){
			
		for(int i=0;i<coordinationVector.size();i++){
			System.out.println("-------");
			System.out.println("paixths "+coordinationVector.elementAt(i).getNumber());
			System.out.println("8esh mpalas "+CoordinationBeliefs.Ball.X+","+CoordinationBeliefs.Ball.Y);
			System.out.println("8esh paikth "+coordinationVector.elementAt(i).getPlayerX()+","+coordinationVector.elementAt(i).getPlayerY());
			System.out.println("ball distan "+coordinationVector.elementAt(i).getBallDistance());
			System.out.println();
		}
		
		
		
		
	}

}
