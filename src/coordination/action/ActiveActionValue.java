/**
 * 
 */
package coordination.action;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import agent.Constraints;
import coordination.communication.CoordinationMessage;

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
public class ActiveActionValue {

	public static double Calculate(String action, CoordinationMessage player,
			Coordinate[] PotentialPosition) {

		if (action.equalsIgnoreCase("GoKickBallToGoal")) {

			double theta = player.getBallTheta();
			double distance = player.getBallDistance();

			double distanceWeight = 0.8;
			double AngleWeight = 0.2;

			Coordinate ballPos = TriangleLocalization
					.get_det_with_distance_angle(player.getPlayerX(),
							player.getPlayerY(), theta, distance);
			// double ballValue = SoccerFieldCoordinateValue.Calculate(ballPos);

			double ThetaToGoal = Math.abs(TriangleLocalization
					.FindAngleBetweenCoordinates(ballPos,
							Constraints.OpponentGoal))
					+ Math.abs(TriangleLocalization
							.FindAngleBetweenCoordinates(new Coordinate(
									player.PlayerX, player.getPlayerY()),
									Constraints.OpponentGoal));

			double finalValue = distance * distanceWeight * ThetaToGoal
					* AngleWeight;

			return finalValue;

		} else if (action.equalsIgnoreCase("ClearBall")) {

			double theta = player.getBallTheta();
			double distance = player.getBallDistance();

			double distanceWeight = 0.8;
			double AngleWeight = 0.2;

			Coordinate ballPos = TriangleLocalization
					.get_det_with_distance_angle(player.getPlayerX(),
							player.getPlayerY(), theta, distance);

			// double ballValue = SoccerFieldCoordinateValue.Calculate(ballPos);

			double ThetaToGoal = Math.abs(TriangleLocalization
					.FindAngleBetweenCoordinates(ballPos,
							Constraints.OpponentGoal))
					+ Math.abs(TriangleLocalization
							.FindAngleBetweenCoordinates(new Coordinate(
									player.PlayerX, player.getPlayerY()),
									Constraints.OpponentGoal));

			double finalValue = distance * distanceWeight + ThetaToGoal
					* AngleWeight;

			return finalValue;

		} else {

			return 0;
		}

	}

}
