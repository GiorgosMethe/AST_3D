/***********************************************************************************
 * Technical University of Crete Academic Year 2011-2012
 * 
 * Thesis Project
 * 
 * @author Methenitis Georgios Student ID:2006030085
 * 
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D
 * Simulation League 
 * 
 * Start date: 25-04-2012 End date : xx-xx-2012
 ***********************************************************************************/
package coordination.main;

import geometry.GeometricUtils;

import java.util.Vector;

import com.vividsolutions.jts.geom.LineSegment;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import coordination.action.ActionObject;
import coordination.communication.CoordinationMessage;



public class ActiveCoordination {

	public static void Coordinate(Vector<CoordinationMessage> activeSubset, Vector<Coordinate> ActivePositions, Coordinate ball) {

		int set[] = new int[3];
		int MinSet[] = new int[3];
		Coordinate Agent;
		double Cost;
		double min=1000;
		
		
		for(int i=0;i<ActivePositions.size();i++){
			
			for(int j=0;j<ActivePositions.size();j++){
				
				for(int k=0;k<ActivePositions.size();k++){
					
					if(k!=i && k!=j && i!=j){
									
						Cost = 0;
						
						set[0]=i;
						set[1]=j;
						set[2]=k;
						
						//System.out.println("-----");
						for(int agentNum=0;agentNum<activeSubset.size();agentNum++){
							
							Agent = new Coordinate(activeSubset.elementAt(agentNum).getPlayerX(),
									activeSubset.elementAt(agentNum).getPlayerY());
							
							
							//System.out.println("paixths: "+activeSubset.elementAt(agentNum).getNumber());
							//System.out.println("8esh: "+Agent.X+" "+Agent.Y);
							if(set[agentNum]==2){
								//System.out.println("ball: "+ActivePositions.elementAt(set[agentNum]).X+" "+ActivePositions.elementAt(set[agentNum]).Y);
							}else{
								//System.out.println("nea 8esh: "+ActivePositions.elementAt(set[agentNum]).X+" "+ActivePositions.elementAt(set[agentNum]).Y);
							}
							Cost += TriangleLocalization.FindDistanceAmong2Coordinates(Agent, ActivePositions.elementAt(set[agentNum]));
							//System.out.println("sum: "+Cost);
						}
						
						
						for(int q=0;q<3;q++){
							for(int r=q+1;r<3;r++){
								
								Coordinate Agent1 = new Coordinate(activeSubset.elementAt(q).getPlayerX(),
										activeSubset.elementAt(q).getPlayerY());
								
								Coordinate Agent2 = new Coordinate(activeSubset.elementAt(r).getPlayerX(),
										activeSubset.elementAt(r).getPlayerY());
										
								com.vividsolutions.jts.geom.Coordinate interceptionPoint = GeometricUtils.FindIntersection(Agent1, ActivePositions.elementAt(set[q]), Agent2, ActivePositions.elementAt(set[r]));
								
								
								if(interceptionPoint != null){
									
									double distanceFromAgent1 = TriangleLocalization.FindDistanceAmong2Coordinates(
											Agent1,
											new Coordinate(interceptionPoint.x, interceptionPoint.y));
									
									double distanceFromAgent2 = TriangleLocalization.FindDistanceAmong2Coordinates(
											Agent2,
											new Coordinate(interceptionPoint.x, interceptionPoint.y));
									
									if(Math.abs(distanceFromAgent1 - distanceFromAgent2)<1.5){
										
										Cost += 5;
										
									}
											
									
								}
			
							}		
						}
						
						
						if(Cost<min){
							
							MinSet[0] = i;
							MinSet[1] = j;
							MinSet[2] = k;
							
							min=Cost;
						}
		
						
						
					}
					
				}
				
			}
			
			
		}
		
		for(int f=0;f<3;f++){
			if(MinSet[f]==2){
				
				ActionObject a = new ActionObject(activeSubset.elementAt(f).getNumber(),
						"GoKickBallToGoal", 0, 0, 0, 0);
				ActionTable.CoordinateActions.addElement(a);
				
			}else{
				
				ActionObject a = new ActionObject(activeSubset.elementAt(f).getNumber(),
						"GoToPos", ActivePositions.elementAt(MinSet[f]).X, ActivePositions.elementAt(MinSet[f]).Y, 0, 0);
				ActionTable.CoordinateActions.addElement(a);
				
			}
		}
		
	
	}

}
