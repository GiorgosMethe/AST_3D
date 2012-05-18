package action.vision;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import localization.BodyTheta;
import localization.Landmark;
import localization.LocalizationResults;

public class ObstacleAvoidance {



	public static void Act(){

		final Comparator<Landmark> SENIORITY_ORDER = 
				new Comparator<Landmark>() {
			public int compare(Landmark e1, Landmark e2) {
				boolean Cmp = e2.Horizontal_Angle >= (e1.Horizontal_Angle);
				if (Cmp != true)
					return 1;
				return 0;
			}
		};

		final Vector<Landmark> CoPlayers = LocalizationResults.coplayers;
		final Vector<Landmark> RivalPlayers = LocalizationResults.rivals;
		final Vector<BodyTheta> DangerousAngles = new Vector<BodyTheta>();
		final float DangerDist=(float) 0.3;
		final int Dangerzone=5;
		
		Collections.sort(CoPlayers, SENIORITY_ORDER);

		for(int i=0;i<CoPlayers.size();i++){
			System.out.println("blepw CoPlayer dist"+CoPlayers.elementAt(i).Distance);
			System.out.println("blepw CoPlayer theta"+CoPlayers.elementAt(i).Horizontal_Angle);
			System.out.println("---");
			if(CoPlayers.elementAt(i).Distance<Dangerzone){
				
				float DistanceFromObstacleWhenClose = (float) (Math.sin(Math.toRadians(CoPlayers.elementAt(i).Horizontal_Angle)) * CoPlayers.elementAt(i).Distance);
				
				if(Math.abs(DistanceFromObstacleWhenClose)<DangerDist){
					
					System.out.println("danger object");
					float theta = (float) Math.toDegrees(Math.asin(DangerDist/CoPlayers.elementAt(i).Distance));
					System.out.println("danger angle zone:"+(CoPlayers.elementAt(i).Horizontal_Angle-theta)+" < "+"Theta < "+ (CoPlayers.elementAt(i).Horizontal_Angle+theta));
					
				}
			}
			
		}
		
		for(int j=0;j<RivalPlayers.size();j++){
			
			System.out.println("blepw RivalPlayer dist"+CoPlayers.elementAt(j).Distance);
			System.out.println("blepw RivalPlayer thate"+CoPlayers.elementAt(j).Horizontal_Angle);
			System.out.println("---");
			
		}









	}


	public static int compare(Landmark a,Landmark b){

		if(a.Horizontal_Angle<b.Horizontal_Angle){
			return 1;
		}


		return 0;

	}

}