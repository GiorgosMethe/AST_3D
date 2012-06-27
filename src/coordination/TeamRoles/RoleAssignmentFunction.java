package coordination.TeamRoles;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;

import coordination.active.ActiveCoordination;
import coordination.strategy.TeamFormation;

public class RoleAssignmentFunction {

	public static Vector<Role> ActiveRoles = new Vector<Role>();

	public static void AssignRolesForActivePlayers() {


		int roleArray[] = {0,0,0};

		Coordinate agent = ActiveCoordination.OptimizedActiveMap.elementAt(0).getPosition();
		Coordinate agent1 = ActiveCoordination.OptimizedActiveMap.elementAt(1).getPosition();
		Coordinate agent2 = ActiveCoordination.OptimizedActiveMap.elementAt(2).getPosition();		


		double min = 1000;
		for(int i=2;i<10;i++){
			for(int j=2;j<10;j++){
				for(int q=2;q<10;q++){

					if(i !=j && j!=q && i!=q){


						Coordinate role = TeamFormation.TeamFormation[i];
						Coordinate role1 = TeamFormation.TeamFormation[j];
						Coordinate role2 = TeamFormation.TeamFormation[q];

						double distance = TriangleLocalization.FindDistanceAmong2Coordinates(agent,role) +
								TriangleLocalization.FindDistanceAmong2Coordinates(agent1,role1) +
								TriangleLocalization.FindDistanceAmong2Coordinates(agent1,role1);


						if(distance < min){

							min = distance;
							roleArray[0]=i;
							roleArray[1]=j;
							roleArray[2]=q;


						}

					}

				}

			}
		}




		for(int r=0;r<ActiveCoordination.OptimizedActiveMap.size();r++){
			System.out.println("paixths :"+ActiveCoordination.OptimizedActiveMap.elementAt(r).getAgent().getNumber());
			System.out.println("rolos :"+roleArray[r]);
		}

	}

}
