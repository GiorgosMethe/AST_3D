/**
 * 
 */
package coordination.support;

import coordination.strategy.SoccerFieldCoordinateValue;
import perceptor.localization.Coordinate;
import agent.constraints.Beam;
import agent.constraints.Constraints;

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

	public static Coordinate[] Calculate(Coordinate Ball) {

		Coordinate[] NewCoordinates = new Coordinate[10];

		double value = SoccerFieldCoordinateValue.Calculate(Ball);

		Coordinate a = new Coordinate(Beam.playersInitPositions[3].X,
				Beam.playersInitPositions[3].Y);

		// Defence line

		double defendersWide = Constraints.defenceWideMinValue
				+ (Constraints.defenceWideMaxValue - Constraints.defenceWideMinValue)
				* ((Constraints.MaxFieldSpotValue + value) / (2 * Constraints.MaxFieldSpotValue));

		double defendersY = a.Y
				+ Constraints.FieldWidth
				* (Ball.Y / Constraints.FieldWidth / 2)
				* ((Constraints.MaxFieldSpotValue + value) / (2 * Constraints.MaxFieldSpotValue));

		if ((Math.abs(Math.rint(defendersY)) + Math.abs(Math
				.rint(defendersWide))) >= Constraints.FieldWidth / 2) {
			if (defendersY > 0) {
				defendersY = defendersY - defendersWide;
			} else {
				defendersY = defendersY + defendersWide;
			}
		}

		double defendersX = a.X
				- 2
				+ 7
				* ((Constraints.MaxFieldSpotValue + value) / (2 * Constraints.MaxFieldSpotValue));

		// Main defender center
		NewCoordinates[4] = new Coordinate(defendersX, defendersY);

		// DR , DL
		NewCoordinates[3] = new Coordinate(defendersX,
				(defendersY + defendersWide));
		NewCoordinates[2] = new Coordinate(defendersX,
				(defendersY - defendersWide));

		// Attack line
		double attackersWide = 4;
		double attackersX = -1;
		double attackersY = 0;
		double attackersDX = 2;

		if (value > 0) {

			attackersWide = 4 - ((value / Constraints.MaxFieldSpotValue) * 3);
			attackersDX = 1 - ((value / Constraints.MaxFieldSpotValue) * 2);
			attackersX = Ball.X - 1;
			attackersY = Ball.Y;

			if ((Math.abs(Math.rint(attackersY)) + Math.abs(Math
					.rint(attackersWide))) >= Constraints.FieldWidth / 2) {
				if (defendersY > 0) {
					attackersY = attackersY - attackersWide;
				} else {
					attackersY = attackersY + attackersWide;
				}
			}

		} else {

		}

		// Forward Center
		NewCoordinates[9] = new Coordinate(attackersX, attackersY);

		// FR , FL
		NewCoordinates[8] = new Coordinate((attackersX - attackersDX),
				(attackersY + attackersWide));
		NewCoordinates[7] = new Coordinate((attackersX - attackersDX),
				(attackersY - attackersWide));

		// MidField line

		double midfielderswide = 0;
		double midfieldersX = 0;
		double midfieldersY = 0;

		if (value > 0) {

			midfieldersX = attackersX - 2;
			midfielderswide = attackersWide / 2;
			midfieldersY = attackersY;

		} else {

			midfieldersX = defendersX + 2;
			midfielderswide = defendersWide / 2;
			midfieldersY = defendersY;

		}

		// MCR
		NewCoordinates[6] = new Coordinate(midfieldersX,
				(midfieldersY + midfielderswide));

		// MCL
		NewCoordinates[5] = new Coordinate(midfieldersX,
				(midfieldersY - midfielderswide));

		return NewCoordinates;

	}

}
