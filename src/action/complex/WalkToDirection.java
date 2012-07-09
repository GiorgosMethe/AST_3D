/**
 * 
 */
package action.complex;

import motion.utils.MotionTrigger;
import motion.xml.WalkLeaning;
import perceptor.localization.LocalizationResults;
import perceptor.localization.ReturnMyPosition;
import perceptor.localization.TriangleLocalization;
import action.vision.VisionType;

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
public class WalkToDirection {

	public static int DirectionValues[] = {

	0, 45, 90, 135, 180, -135, -90, -45

	};

	public static void Act(double Direction) {

		double ThetaToDirection;

		VisionType.setType(5);

		if (ReturnMyPosition.Return() == null) {

			// nothing

		} else {

			double MyDirection = LocalizationResults.getBody_angle();
			ThetaToDirection = TriangleLocalization.FindAngleDifference2(
					Direction, MyDirection);

			if (Math.abs(ThetaToDirection) < 20) {

				MotionTrigger.setMotion("Forwards50");
				WalkLeaning.setLean("");

			} else if (Math.abs(ThetaToDirection) < 10) {

				if (ThetaToDirection < 0) {

					MotionTrigger.setMotion("Forwards50");
					WalkLeaning.setLean("right");

				} else {

					MotionTrigger.setMotion("Forwards50");
					WalkLeaning.setLean("left");

				}

			} else {

				if (ThetaToDirection < 0) {

					MotionTrigger.setMotion("TurnRight40");

				} else {

					MotionTrigger.setMotion("TurnLeft40");

				}

			}

		}

	}

}
