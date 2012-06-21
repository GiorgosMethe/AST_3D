package perceptor.localization;

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
import perceptor.vision.Vision;

public class ReturnMyPosition {

	public static CompleteCoordinate Return() {

		if (Vision.isiSee() == true) {

			if ((!Double.isNaN(LocalizationResults.getBody_angle()))
					&& (!Double.isNaN(LocalizationResults.getCurrent_location()
							.getX()))
					&& (!Double.isNaN(LocalizationResults.getCurrent_location()
							.getY()))) {

				return new CompleteCoordinate(LocalizationResults
						.getCurrent_location().getX(), LocalizationResults
						.getCurrent_location().getY(),
						LocalizationResults.getBody_angle());

			} else {

				return null;

			}

		} else {

			return null;
		}

	}

}