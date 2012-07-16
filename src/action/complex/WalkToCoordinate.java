/*******************************************************************************
 * Technical University of Crete
 * 
 * Thesis Project
 * 
 * Author:	Methenitis K. Georgios
 * 
 * Abstract  : Player Behavior and Team Strategy 
 * 			for the RoboCup 3D Simulation League
 * 
 * Date:  		July 2012
 ******************************************************************************/
package action.complex;

import motion.utils.MotionTrigger;
import motion.xml.WalkLeaning;
import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import action.vision.VisionType;

public class WalkToCoordinate {

	public static boolean Act(Coordinate target) {

		VisionType.setType(6);

		double ThetaToTarget = TriangleLocalization.FindAngle(target);

		if (TriangleLocalization.FindDistanceToTarget(target) < 0.5) {

			MotionTrigger.setMotion("");
			return true;

		} else {

			if (Math.abs(TriangleLocalization
					.FindAngleDifference(ThetaToTarget)) < 20) {

				MotionTrigger.setMotion("Forwards50");
				WalkLeaning.setLean("");
				return false;

			} else if (Math.abs(TriangleLocalization
					.FindAngleDifference(ThetaToTarget)) < 10) {

				if (TriangleLocalization.FindAngleDifference(ThetaToTarget) < 0) {

					MotionTrigger.setMotion("Forwards50");
					WalkLeaning.setLean("right");
					return false;

				} else {

					MotionTrigger.setMotion("Forwards50");
					WalkLeaning.setLean("left");
					return false;

				}

			} else {

				if (TriangleLocalization.FindAngleDifference(ThetaToTarget) < 0) {

					MotionTrigger.setMotion("TurnRight40");
					return false;

				} else {

					MotionTrigger.setMotion("TurnLeft40");
					return false;

				}

			}

		}

	}

}
