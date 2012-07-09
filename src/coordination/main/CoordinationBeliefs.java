/**
 * 
 */
package coordination.main;

import perceptor.localization.Coordinate;
import perceptor.localization.LocalizationResults;
import perceptor.localization.TriangleLocalization;
import perceptor.utils.BallObservationFilter;
import coordination.communication.message.CoordinationVectorUpdate;

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
public class CoordinationBeliefs {

	public static Coordinate Ball;

	private static double distance2;
	private static double realDistance;
	private static int distance1;

	public static void UpdateBeliefs() {

		UpdateBallBelief();

		UpdateDistancesBelief();

	}

	public static void UpdateBallBelief() {

		/*
		 * Here, we are making the collection of player perceptions
		 * 
		 * These thought will be used in order to locate the ball in the field
		 */

		if (LocalizationResults.isKnowMyPosition()
				&& perceptor.vision.Ball.isSeeTheBall()) {

			BallObservationFilter.AddSample(TriangleLocalization
					.get_det_with_distance_angle(LocalizationResults
							.getCurrent_location().getX(), LocalizationResults
							.getCurrent_location().getY(), LocalizationResults
							.getBall_angle(), perceptor.vision.Ball
							.getDistance()));

		}

		for (int i = 0; i < CoordinationVectorUpdate.CoordinationVector.size(); i++) {

			if (CoordinationVectorUpdate.CoordinationVector.elementAt(i)
					.getType() == 0) {

				Coordinate ballSample = TriangleLocalization
						.get_det_with_distance_angle(
								CoordinationVectorUpdate.CoordinationVector
										.elementAt(i).getPlayer().getX(),
								CoordinationVectorUpdate.CoordinationVector
										.elementAt(i).getPlayer().getY(),
								CoordinationVectorUpdate.CoordinationVector
										.elementAt(i).getBallTheta(),
								CoordinationVectorUpdate.CoordinationVector
										.elementAt(i).getBallDistance());

				BallObservationFilter.AddSample(ballSample);

			}

		}

		Coordinate Ball = BallObservationFilter.update();

		if (Double.isNaN(Ball.X) || Double.isNaN(Ball.X)) {

		} else {

			CoordinationBeliefs.Ball = Ball;

		}

	}

	public static void UpdateDistancesBelief() {

		/*
		 * We have to find the agent's real distance from the ball
		 */

		for (int i = 0; i < CoordinationVectorUpdate.CoordinationVector.size(); i++) {

			// agent sees the ball directly
			if (CoordinationVectorUpdate.CoordinationVector.elementAt(i)
					.getType() == 0
					|| CoordinationVectorUpdate.CoordinationVector.elementAt(i)
							.getType() == 2) {

				distance1 = CoordinationVectorUpdate.CoordinationVector
						.elementAt(i).getBallDistance();

				realDistance = distance1;

				// agent doesn't see the ball directly
			} else if (CoordinationVectorUpdate.CoordinationVector.elementAt(i)
					.getType() == 1) {

				// distance can be only calculated indirectly

				distance2 = TriangleLocalization.FindDistanceAmong2Coordinates(
						CoordinationBeliefs.Ball,
						CoordinationVectorUpdate.CoordinationVector
								.elementAt(i).getPlayer());

				realDistance = distance2;

			} else {

				realDistance = 80;

			}

			CoordinationVectorUpdate.CoordinationVector.elementAt(i)
					.setRealDistance(realDistance);

		}

	}

}
