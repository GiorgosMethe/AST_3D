package behavior.vision;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import localization.BodyTheta;
import localization.Landmark;
import localization.LocalizationResults;

public class ObstacleAvoidance {



	public static boolean Act(){

		final Comparator<Landmark> SENIORITY_ORDER = new Comparator<Landmark>() {
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
		Vector<Float> WayOutAngles = new Vector<Float>();

		final float DangerDist=(float) 0.35;
		final int Dangerzone=2;
		Players.addAll(RivalPlayers);
		Collections.sort(Players, SENIORITY_ORDER);

		for(int i=0;i<Players.size();i++){

			if(Players.elementAt(i).Distance<Dangerzone){

				float DistanceFromObstacleWhenClose = (float) (Math.sin(Math.toRadians(Players.elementAt(i).Horizontal_Angle)) 
						* Players.elementAt(i).Distance);

				if(Math.abs(DistanceFromObstacleWhenClose)<DangerDist){

					float theta = (float) Math.toDegrees(Math.asin(DangerDist/Players.elementAt(i).Distance));
					BodyTheta bt=new BodyTheta((float)(Players.elementAt(i).Horizontal_Angle-theta), 
							(float)(Players.elementAt(i).Horizontal_Angle+theta));
					DangerousAngles.addElement(bt);

				}
			}

		}

		//No obstacle in my way
		if(DangerousAngles.size()==0){
			System.out.println("No obstacle in my way");
			//MotionTrigger.setMotion("Forwards50");
		}else{
			
			//find angles which are suitable for exit
			WayOutAngles = WayOut(DangerousAngles);
			
			//clear vectors which are not needed any more
			DangerousAngles.removeAllElements();
			Players.removeAllElements();
			RivalPlayers.removeAllElements();
			
			//find best angle to avoid obstacle
			float WayOutBest = FindBestWayOut(WayOutAngles);
			System.out.println(WayOutBest);
			//MotionTrigger.setMotion("TurnRight40");
		}


		return true;

	}


	public static int compare(Landmark a,Landmark b){

		if(a.Horizontal_Angle<b.Horizontal_Angle){
			return 1;
		}


		return 0;

	}

	public static Vector<Float> WayOut(Vector<BodyTheta> dangerousAngles){

		Vector<Float> WayOutAngles = new Vector<Float>();

		//there is only one obstacle
		if(dangerousAngles.size()==1){
			
			WayOutAngles.add(dangerousAngles.elementAt(0).ThetaStart);
			WayOutAngles.add(dangerousAngles.elementAt(0).ThetaEnd);

		//there are more than one obstacles
		}else{
			for(int i=0;i<dangerousAngles.size();i++){

				boolean flagStart=true;
				boolean flagEnd=true;
				for(int j=0;j<dangerousAngles.size();j++){

					if(i!=j){
						
						if((dangerousAngles.elementAt(i).ThetaStart>dangerousAngles.elementAt(j).ThetaStart)&&
								(dangerousAngles.elementAt(i).ThetaStart<dangerousAngles.elementAt(j).ThetaEnd)){

							flagStart=false;

						}

						if((dangerousAngles.elementAt(i).ThetaEnd>dangerousAngles.elementAt(j).ThetaStart)&&
								(dangerousAngles.elementAt(i).ThetaEnd<dangerousAngles.elementAt(j).ThetaEnd)){

							flagEnd=false;

						}

						if(flagEnd){
							
							WayOutAngles.add(dangerousAngles.elementAt(0).ThetaEnd);	
							
						}
						
						if(flagStart){
							
							WayOutAngles.add(dangerousAngles.elementAt(0).ThetaStart);
							
						}
					}

				}
			}
		}
		
		return WayOutAngles;
		
	}
	
	
	
	public static float FindBestWayOut(Vector<Float> WayOutAngles){

		
		float bestAngle=1000;
		for(int k=0;k<WayOutAngles.size();k++){
			if(Math.abs(WayOutAngles.elementAt(k))<bestAngle){
				bestAngle = WayOutAngles.elementAt(k);
			}
		}
		return bestAngle;

	}

}

