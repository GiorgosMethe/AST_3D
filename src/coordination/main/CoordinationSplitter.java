package coordination.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import coordination.communication.CoordinationMessage;

public class CoordinationSplitter {

	public static Vector<CoordinationMessage> ActiveSubset = new Vector<CoordinationMessage>();
	public static Vector<CoordinationMessage> PassiveSubset = new Vector<CoordinationMessage>();
	public static Vector<CoordinationMessage> InactiveSubset = new Vector<CoordinationMessage>();

	public static void Split(Vector<CoordinationMessage> coordinationVector) {

		final Comparator<CoordinationMessage> POSITIVE_ORDER = new Comparator<CoordinationMessage>() {

			public int compare(CoordinationMessage e1, CoordinationMessage e2) {
				boolean Cmp = e2.getBallDistance() >= (e1.getBallDistance());
				if (Cmp != true) {
					return 1;
				} else {
					return 0;
				}
			}
		};
		
		
		//clear previous created subsets
		ActiveSubset.removeAllElements();
		PassiveSubset.removeAllElements();
		InactiveSubset.removeAllElements();
		
	
		
		//sort coordination vector 
		Collections.sort(coordinationVector, POSITIVE_ORDER);

		
		
		/*
		 * Creation of three subsets
		 * 3 players will be added into active subset
		 * the rest players will be added either into the
		 * passive subset or into the inactive subset
		 */
		
		ActiveSubset.addElement(coordinationVector.elementAt(0));
		ActiveSubset.addElement(coordinationVector.elementAt(1));
		ActiveSubset.addElement(coordinationVector.elementAt(2));
		
		
		for(int i=3;i<coordinationVector.size();i++){
			
			if(coordinationVector.elementAt(i).getBallDistance()!=80){
				
				PassiveSubset.addElement(coordinationVector.elementAt(i));
				
			}else{
				
				InactiveSubset.addElement(coordinationVector.elementAt(i));
				
			}
		}
			
		
	}
	
}
