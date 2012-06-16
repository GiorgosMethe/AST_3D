package agent;

import perceptor.localization.Coordinate;

public class Constraints {

	/*
	 * simulation static values
	 */
	public static int numberPlayers = 9;

	/*
	 * kinematics static values
	 */
	public static float bodyHeight = (float) 0.3;

	public static float UpperLegHeight = (float) 0.15;

	public static float LegHeight = (float) 0.15;

	/*
	 * Localization static values
	 */
	// 11 player rcssserver 0.6.6
	public static Coordinate OpponentGoal = new Coordinate(10.5, 0);

	/*
	 * Communication and Coordination static values
	 */
	public static int CoordinationPlayer = 1;

	public static int CoordinationTimeout = 20;

	/*
	 * Strategy constraints
	 */
	public static float FieldLength = 21;

	public static float FieldWidth = 14;

	public static float MaxFieldSpotValue = 73.5f;

	// defence line
	public static float defenceWideMinValue = 1;
	public static float defenceWideMaxValue = 4;

}
