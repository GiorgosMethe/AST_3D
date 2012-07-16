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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;

public class BallLocalizationFilter {

	public static Coordinate MyFilteredBallPosition;

	public static Queue<Coordinate> qe = new LinkedList<Coordinate>();

	public static void filter() {

		Coordinate LocalizationSample = null;

		if (Ball.isSeeTheBall()) {

			if (LocalizationFilter.MyPosition != null) {
				LocalizationSample = TriangleLocalization
						.get_det_with_distance_angle(
								LocalizationFilter.MyPosition.getX(),
								LocalizationFilter.MyPosition.getY(),
								HingeJointPerceptor.getHj1()
										+ LocalizationFilter.MyFilteredPosition
												.getTheta() + Ball.getAngleX(),
								Ball.getDistance());
			}

		}

		if (LocalizationSample == null) {

			MyFilteredBallPosition = VectorAVG();
			if (qe.size() > 0) {
				qe.remove();
			}

		} else {

			if (qe.size() == 0) {

				qe.add(LocalizationSample);
				MyFilteredBallPosition = VectorAVG();

			} else if (qe.size() < 10) {

				MyFilteredBallPosition = VectorAVG();

				if (TriangleLocalization.FindDistanceAmong2Coordinates(
						new Coordinate(MyFilteredBallPosition.getX(),
								MyFilteredBallPosition.getY()),
						new Coordinate(LocalizationSample.getX(),
								LocalizationSample.getY())) > 2) {

					qe.remove();

				} else {

					qe.add(LocalizationSample);

				}

			} else {

				MyFilteredBallPosition = VectorAVG();

				qe.remove();

			}

		}

	}

	public static Coordinate VectorAVG() {

		double x = 0, y = 0;

		Iterator<Coordinate> it = qe.iterator();

		while (it.hasNext()) {

			Coordinate a = (Coordinate) it.next();

			x += a.getX();
			y += a.getY();

		}

		Coordinate MyAvgPosition = new Coordinate((x / qe.size()),
				(y / qe.size()));

		return MyAvgPosition;

	}

}
