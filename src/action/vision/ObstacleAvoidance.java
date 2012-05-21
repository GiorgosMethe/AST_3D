package action.vision;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import localization.BodyTheta;
import localization.Landmark;
import localization.LocalizationResults;

public class ObstacleAvoidance {



	public static boolean Act(){

		final Comparator<Landmark> SENIORITY_ORDER = 
				new Comparator<Landmark>() {
			public int compare(Landmark e1, Landmark e2) {
				boolean Cmp = e2.Horizontal_Angle >= (e1.Horizontal_Angle);
				if (Cmp != true){
					return 1;
				}else{
					return 0;
				}
			}
		};

		final Vector<Landmark> Players = LocalizationResults.coplayers;
		final Vector<Landmark> RivalPlayers = LocalizationResults.rivals;
		final Vector<BodyTheta> DangerousAngles = new Vector<BodyTheta>();

		final float DangerDist=(float) 0.35;
		final int Dangerzone=2;
		Players.addAll(RivalPlayers);
		Collections.sort(Players, SENIORITY_ORDER);

		for(int i=0;i<Players.size();i++){
			System.out.println("blepw CoPlayer dist"+Players.elementAt(i).Distance);
			System.out.println("blepw CoPlayer theta"+Players.elementAt(i).Horizontal_Angle);
			System.out.println("body theta"+LocalizationResults.getBody_angle());

			if(Players.elementAt(i).Distance<Dangerzone){

				float DistanceFromObstacleWhenClose = (float) (Math.sin(Math.toRadians(Players.elementAt(i).Horizontal_Angle)) * Players.elementAt(i).Distance);

				if(Math.abs(DistanceFromObstacleWhenClose)<DangerDist){

					System.out.println("danger object");
					float theta = (float) Math.toDegrees(Math.asin(DangerDist/Players.elementAt(i).Distance));
					BodyTheta bt=new BodyTheta((float)(Players.elementAt(i).Horizontal_Angle-theta), 
							(float)(Players.elementAt(i).Horizontal_Angle+theta));
					System.out.println("danger angle zone:"+(Players.elementAt(i).Horizontal_Angle-theta)+
							" < "+"Theta < "+ (Players.elementAt(i).Horizontal_Angle+theta));
					DangerousAngles.addElement(bt);

				}
			}

		}
		WayOut(DangerousAngles);

		return true;

	}


	public static int compare(Landmark a,Landmark b){

		if(a.Horizontal_Angle<b.Horizontal_Angle){
			return 1;
		}


		return 0;

	}

	public static float WayOut(Vector<BodyTheta> dangerousAngles){

		if(dangerousAngles.size()!=0){

			float angle=0;

			for(int i=0;i<dangerousAngles.size();i++){

				boolean flagStart=true;
				boolean flagEnd=true;
				for(int j=0;j<dangerousAngles.size();j++){

					if((dangerousAngles.elementAt(i).ThetaStart>dangerousAngles.elementAt(j).ThetaStart)&&
							(dangerousAngles.elementAt(i).ThetaStart<dangerousAngles.elementAt(j).ThetaEnd)){

						flagStart=false;

					}

					if((dangerousAngles.elementAt(i).ThetaEnd>dangerousAngles.elementAt(j).ThetaStart)&&
							(dangerousAngles.elementAt(i).ThetaEnd<dangerousAngles.elementAt(j).ThetaEnd)){

						flagEnd=false;

					}

					if(flagEnd){
						System.out.println("clean angle:"+dangerousAngles.elementAt(i).ThetaEnd);	
					}
					if(flagStart){
						System.out.println("clean angle:"+dangerousAngles.elementAt(i).ThetaStart);	
					}
					

				}



			}


			return 0;

		}
		return 0;

	}
}
