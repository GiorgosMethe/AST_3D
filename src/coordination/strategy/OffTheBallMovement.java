/**
 * 
 */
package coordination.strategy;

import localization.Coordinate;
import agent.Beam;

/***********************************************************************************
 * Copyright 2012, Technical University of Crete Academic Year 2011-2012
 * 
 * Thesis Project
 * 
 * @author Methenitis Georgios Student ID:2006030085
 * 
 *         Abstract: Player Behavior and Team Strategy for the RoboCup 3D
 *         Simulation League Start date: 25-04-2012 End date : xx-xx-2012
 ***********************************************************************************/
public class OffTheBallMovement {

	private static final String Coordinate = null;

	public static Coordinate[] Calculate(Coordinate Ball) {

		Coordinate[] NewCoordinates = new Coordinate[9];

		double value = SoccerFieldCoordinateValue.Calculate(Ball);

		Coordinate a = new Coordinate(Beam.playersInitPositions[3].X,
				Beam.playersInitPositions[3].Y);

		double d = 1 + ((150 + value) / 300) * 2;
		double y = a.Y + 4 * (Ball.Y / 7);
		double x = a.X - 3 + ((150 + value) / 300) * 7;

		NewCoordinates[3] = new Coordinate(x, y);
		NewCoordinates[2] = new Coordinate(x, (y + d));
		NewCoordinates[1] = new Coordinate(x, (y - d));

		return NewCoordinates;

	}

}
