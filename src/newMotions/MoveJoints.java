/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/
package newMotions;

import motions.Motions;
import perceptor.GetNormalJointValueDegrees;

public class MoveJoints {

	public  static String performMove(Phase pha){

		String[] NaoJoints = {"rae1",
				"rae2",
				"rae3",
				"rae4",
				"lae1",
				"lae2",
				"lae3",
				"lae4",
				"lle1",
				"lle2",
				"lle3",
				"lle4",
				"lle5",
				"lle6",
				"rle1",
				"rle2",
				"rle3",
				"rle4",
				"rle5",
				"rle6"};
		
		boolean[] Move = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
		
		GetNormalJointValueDegrees gNjVd= new GetNormalJointValueDegrees();
		String Str = "";
		if(pha.movements.size()>0){
			for(int i=0;i<pha.movements.size();i++){
				
				String joint=pha.movements.elementAt(i).axis_name;
				for(int j=0;j<NaoJoints.length;j++){
					if(NaoJoints[j].equalsIgnoreCase(joint)){
						Move[j]=true;
					}
				}
				
				Float move=pha.movements.elementAt(i).value;
				Float velocity=gNjVd.Get(joint, move)/(pha.duration/20);
				String value2str = Float.toString(velocity);
				Str += "(" + joint + " "+value2str+ ")";
				
			}
			
			Str += StopJoints(NaoJoints,Move);
		}else{
			
			Str="(lae4 0)(rae4 0)(lae3 0)(rae3 0)(lae2 0)(rae2 0)(lae1 0)(rae1 0)(rle1 0)(rle2 0)(rle3 0)(rle4 0)(rle5 0)(rle6 0)(lle1 0)(lle2 0)(lle3 0)(lle4 0)(lle5 0)(lle6 0)";
			
		}

		return Str;

	}
	
	public static String StopJoints(String[] NaoJoints, boolean[] Move){
		
		String Str="";
		for(int i=0;i<NaoJoints.length;i++){
			if(Move[i]==false){
				Str += "(" + NaoJoints[i] + " "+0.0f+ ")";
			}
		}

		return Str;
			
	}

}
