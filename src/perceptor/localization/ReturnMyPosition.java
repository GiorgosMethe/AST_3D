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
package perceptor.localization;

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
