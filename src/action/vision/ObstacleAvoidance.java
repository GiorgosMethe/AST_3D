package action.vision;

import java.util.Comparator;
import java.util.Vector;

import localization.Landmark;
import localization.LocalizationResults;
import java.util.Collections;

public class ObstacleAvoidance {
	


	public static void Act(){
		
		Vector<Landmark> CoPlayers = LocalizationResults.coplayers;
		Vector<Landmark> RivalPlayers = LocalizationResults.rivals;

		CoPlayers.addAll(RivalPlayers);
		Comparator<Landmark> comparator = Collections.reverseOrder();
		
		Collections.sort(CoPlayers,comparator);
		
		for(int i=0;i<CoPlayers.size();i++){
			System.out.println("blepw empodio dist"+CoPlayers.elementAt(i).Distance);
			System.out.println("blepw empodio thate"+CoPlayers.elementAt(i).Horizontal_Angle);
		}
		
		
		
		
		
		
		
		
		
	}
	
}
