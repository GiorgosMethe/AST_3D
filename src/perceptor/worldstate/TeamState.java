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

package perceptor.worldstate;

import perceptor.localization.Coordinate;
import agent.constraints.Constraints;

public class TeamState {

	public static String TeamSide;
	public static String OppGoal1, OppGoal2;

	public static String getTeamSide() {
		return TeamSide;
	}

	public static void setTeamSide(String teamSide) {

		if (teamSide.equalsIgnoreCase("right")) {

			Constraints.OwnGoal = new Coordinate(Constraints.FieldLength / 2 - 0.5f, 0);
			Constraints.OpponentGoal = new Coordinate(
					-Constraints.FieldLength / 2, 0);

		} else {

			Constraints.OwnGoal = new Coordinate(-Constraints.FieldLength / 2,
					0);
			Constraints.OpponentGoal = new Coordinate(
					Constraints.FieldLength / 2, 0);

		}

		TeamSide = teamSide;
	}

	public static String getOppGoal1() {
		return OppGoal1;
	}

	public static void setOppGoal1(String oppGoal1) {
		OppGoal1 = oppGoal1;
	}

	public static String getOppGoal2() {
		return OppGoal2;
	}

	public static void setOppGoal2(String oppGoal2) {
		OppGoal2 = oppGoal2;
	}

}
