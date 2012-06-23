/**
 * 
 */
package perceptor.utils;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;

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
								.elementAt(i).getBallPosition(), sample) < 1) {

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
						new Coordinate(0, 0), 0.0f, 1));

			}

		}

	}

	public static Coordinate update() {

		int samples = 0;

		for (int i = 0; i < BallSampleVector.size(); i++) {
			BallSampleVector.elementAt(i).setBallPosition(
					TriangleLocalization.addCoordinates(BallSampleVector
							.elementAt(i).getBallPosition(), BallSampleVector
							.elementAt(i).getSumOfObservations()));
			Coordinate temp = BallSampleVector.elementAt(i).getBallPosition();
			Coordinate avg = new Coordinate(temp.X
					/ BallSampleVector.elementAt(i).getSamplesNum(), temp.Y
					/ BallSampleVector.elementAt(i).getSamplesNum());

			BallSampleVector.elementAt(i).setBallPosition(avg);

			samples += BallSampleVector.elementAt(i).getSamplesNum();
		}

		Coordinate result = new Coordinate(0, 0);

		for (int i = 0; i < BallSampleVector.size(); i++) {

			Coordinate WeightedAvg = new Coordinate((BallSampleVector
					.elementAt(i).getBallPosition().X
					* BallSampleVector.elementAt(i).getSamplesNum() / samples),
					BallSampleVector.elementAt(i).getBallPosition().Y
							* BallSampleVector.elementAt(i).getSamplesNum()
							/ samples);

			result = TriangleLocalization.addCoordinates(result, WeightedAvg);

		}

		BallSampleVector.removeAllElements();
		return result;

	}

}
