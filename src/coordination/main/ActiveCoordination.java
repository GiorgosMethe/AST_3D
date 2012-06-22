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
import coordination.communication.CoordinationMessage;



public class ActiveCoordination {

	public static void Coordinate(Vector<CoordinationMessage> activeSubset, Vector<Coordinate> ActivePositions, Coordinate ball) {
		
		
		int iterations=0;
		int set[] = new int[3];
		int MinSet[] = new int[3];
		Coordinate Agent;
		double sum;
		double min=1000;
		
		
		for(int i=0;i<ActivePositions.size();i++){
			
			for(int j=0;j<ActivePositions.size();j++){
				
				for(int k=0;k<ActivePositions.size();k++){
					
					if(k!=i && k!=j && i!=j){
									
						sum = 0;
						
						set[0]=i;
						set[1]=j;
						set[2]=k;
						
						System.out.println("-----");
						for(int agentNum=0;agentNum<activeSubset.size();agentNum++){
							
							Agent = new Coordinate(activeSubset.elementAt(agentNum).getPlayerX(),
									activeSubset.elementAt(agentNum).getPlayerY());
							
							
							System.out.println("paixths: "+activeSubset.elementAt(agentNum).getNumber());
							System.out.println("8esh: "+Agent.X+" "+Agent.Y);
							System.out.println("nea 8esh: "+ActivePositions.elementAt(set[agentNum]).X+" "+ActivePositions.elementAt(set[agentNum]).Y);
							
							sum += TriangleLocalization.FindDistanceAmong2Coordinates(Agent, ActivePositions.elementAt(set[agentNum]));
							System.out.println("sum: "+sum);
						}
						
						
						for(int q=0;q<3;q++){
							for(int r=q+1;r<3;r++){
								
								Coordinate Agent1 = new Coordinate(activeSubset.elementAt(q).getPlayerX(),
										activeSubset.elementAt(q).getPlayerY());
								
								Coordinate Agent2 = new Coordinate(activeSubset.elementAt(r).getPlayerX(),
										activeSubset.elementAt(r).getPlayerY());
										
								com.vividsolutions.jts.geom.Coordinate inter = GeometricUtils.FindIntersection(Agent1, ActivePositions.elementAt(set[q]), Agent2, ActivePositions.elementAt(set[r]));
								
								
								if(inter != null){
									
									System.out.println("briskoun");
									sum +=5;
									
								}
			
							}		
						}
						
						
						if(sum<min){
							
							MinSet[0] = i;
							MinSet[1] = j;
							MinSet[2] = k;
							
							min=sum;
						}
		
						
						
					}
					
				}
				
			}
			
			
		}
		System.out.println(MinSet[0]+" "+MinSet[1]+" "+MinSet[2]);
		System.out.println("iterations :"+iterations);
		
		
		
		
		
		
	}

}
