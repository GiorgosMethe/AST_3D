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
package perceptor.utils;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;

public class BallObservationFilter {

	public static Vector<BallObservationSamples> BallSampleVector = new Vector<BallObservationSamples>();

	public static void AddSample(Coordinate sample) {

		if (BallSampleVector.size() == 0) {

			BallSampleVector.addElement(new BallObservationSamples(sample,
					new Coordinate(0, 0), 0.0f, 1));

		} else {

			boolean flag = false;

			for (int i = 0; i < BallSampleVector.size(); i++) {

				// samples which have value almost same values
				if (TriangleLocalization
						.FindDistanceAmong2Coordinates(BallSampleVector
								.elementAt(i).getBallPosition(), sample) < 1.5) {

					// add the coordinates of the two samples
					BallSampleVector.elementAt(i).setSumOfObservations(
							TriangleLocalization.addCoordinates(
									BallSampleVector.elementAt(i)
											.getSumOfObservations(), sample));

					// fix the counter
					BallSampleVector.elementAt(i)
							.setSamplesNum(
									(BallSampleVector.elementAt(i)
											.getSamplesNum() + 1));

					flag = true;
					break;

				}
			}

			if (!flag) {

				BallSampleVector.addElement(new BallObservationSamples(sample,
						sample, 0.0f, 1));

			}

		}

	}

	public static Coordinate update() {

		int samples = 0;

		for (int i = 0; i < BallSampleVector.size(); i++) {

			samples += Math.pow(BallSampleVector.elementAt(i).getSamplesNum(),
					3);
		}

		Coordinate result = new Coordinate(0, 0);

		for (int i = 0; i < BallSampleVector.size(); i++) {

			Coordinate WeightedAvg = new Coordinate(
					(BallSampleVector.elementAt(i).getBallPosition().X
							* Math.pow(BallSampleVector.elementAt(i)
									.getSamplesNum(), 3) / samples),
					BallSampleVector.elementAt(i).getBallPosition().Y
							* Math.pow(BallSampleVector.elementAt(i)
									.getSamplesNum(), 3) / samples);

			result = TriangleLocalization.addCoordinates(result, WeightedAvg);

		}

		return result;

	}

}
