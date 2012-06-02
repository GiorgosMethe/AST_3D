package agent;

import localization.Coordinate;

public class Constraints {
	
	
	/*
	 * simulation static values
	 */
	public static int numberPlayers = 11;
	
	
	/*
	 * kinematics static values
	 */
	public static float bodyHeight=(float) 0.3;
	
	public static float UpperLegHeight=(float) 0.15;
	
	public static float LegHeight=(float) 0.15;
	
	
	/*
	 * Localization static values
	 */
	public static Coordinate OpponentGoal = new Coordinate(15, 0); 
	
	
	
	/*
	 * Communication and Coordination static values
	 */
	public static int CoordinationPlayer = 1;
	
	public static int CoordinationTimeout = 10;

}
