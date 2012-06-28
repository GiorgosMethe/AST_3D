/**
 * 
 */
package coordination.main;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.LocalizationResults;
import perceptor.localization.TriangleLocalization;
import perceptor.utils.BallObservationFilter;
import coordination.communication.message.CoordinationMessage;

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

	public static void UpdateBeliefs(
			Vector<CoordinationMessage> coordinationVector) {

		UpdateBallBelief(coordinationVector);
		
		

		UpdateDistancesBelief(coordinationVector);

	}

	public static void UpdateBallBelief(
			Vector<CoordinationMessage> coordinationVector) {

		/*
		 * Here, we are making the collection of player perceptions
		 * 
		 * These thought will be used in order to locate the ball in the field
		 */

		if (LocalizationResults.isKnowMyPosition() &&
				perceptor.vision.Ball.isSeeTheBall()) {

			BallObservationFilter.AddSample(TriangleLocalization.get_det_with_distance_angle(
					LocalizationResults.getCurrent_location().getX(),
					LocalizationResults.getCurrent_location().getY(),
					LocalizationResults.getBall_angle(),
					perceptor.vision.Ball.getDistance()));

		}

		for (int i = 0; i < coordinationVector.size(); i++) {

			if (coordinationVector.elementAt(i).getType() == 0) {

				Coordinate ballSample = 
						TriangleLocalization.get_det_with_distance_angle(
						coordinationVector.elementAt(i).getPlayer().getX(),
						coordinationVector.elementAt(i).getPlayer().getY(),
						coordinationVector.elementAt(i).getBallTheta(),
						coordinationVector.elementAt(i).getBallDistance());

				BallObservationFilter.AddSample(ballSample);

			}

		}

		CoordinationBeliefs.Ball = BallObservationFilter.update();

	}

	public static void UpdateDistancesBelief(
			Vector<CoordinationMessage> coordinationVector) {

		/*
		 * We have to find the agent's real distance from the ball
		 */

		for (int i = 0; i < coordinationVector.size(); i++) {

			// agent sees the ball directly
			if (coordinationVector.elementAt(i).getType() == 0 ||
					coordinationVector.elementAt(i).getType() == 2	) {

				distance1 = coordinationVector.elementAt(i).getBallDistance();

				realDistance = distance2;

				// agent doesn't see the ball directly
			} else if (coordinationVector.elementAt(i).getType() == 1) {

				// distance can be only calculated indirectly

				distance2 = TriangleLocalization.FindDistanceAmong2Coordinates(
						CoordinationBeliefs.Ball,
						coordinationVector.elementAt(i).getPlayer());

				realDistance = distance1;

			} else {

				realDistance = 80;

			}

			coordinationVector.elementAt(i).setRealDistance(realDistance);

		}

	}

}
