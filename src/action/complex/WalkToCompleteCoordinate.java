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
package action.complex;

import motion.old.MotionTrigger;
import motion.xml.WalkLeaning;
import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import action.vision.VisionType;

public class WalkToCompleteCoordinate {

	public static boolean Act(Coordinate target, float Theta) {

		double ThetaToTarget = TriangleLocalization.FindAngle(target);
		VisionType.setType(2);

		if (TriangleLocalization.FindDistanceToTarget(target) < 0.5) {

			if (Math.abs(TriangleLocalization.FindAngleDifference(Theta)) < 20) {

				MotionTrigger.setMotion("");
				return true;

			} else {

				if (TriangleLocalization.FindAngleDifference(Theta) < 0) {

					MotionTrigger.setMotion("TurnRight40");
					return false;

				} else {

					MotionTrigger.setMotion("TurnLeft40");
					return false;

				}

			}

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
