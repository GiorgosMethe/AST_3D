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

public class LocalizationFilter {

	public static CompleteCoordinate MyFilteredPosition;
	public static Coordinate MyPosition;

	public static Queue<CompleteCoordinate> qe = new LinkedList<CompleteCoordinate>();

	public static void filter(CompleteCoordinate LocalizationSample) {

		if (!Double.isNaN(LocalizationSample.getX())
				&& !Double.isNaN(LocalizationSample.getY())
				&& !Double.isNaN(LocalizationSample.getTheta())) {

			if (qe.size() == 0) {

				qe.add(LocalizationSample);
				MyFilteredPosition = VectorAVG();
				MyPosition = new Coordinate(MyFilteredPosition.getX(),
						MyFilteredPosition.getY());

			} else if (qe.size() < 10) {

				MyFilteredPosition = VectorAVG();
				MyPosition = new Coordinate(MyFilteredPosition.getX(),
						MyFilteredPosition.getY());
				if (TriangleLocalization.FindDistanceAmong2Coordinates(
						new Coordinate(MyFilteredPosition.getX(),
								MyFilteredPosition.getY()),
						new Coordinate(LocalizationSample.getX(),
								LocalizationSample.getY())) > 2) {

					qe.remove();

				} else {

					qe.add(LocalizationSample);

				}

			} else {

				MyFilteredPosition = VectorAVG();
				MyPosition = new Coordinate(MyFilteredPosition.getX(),
						MyFilteredPosition.getY());
				qe.remove();

			}

		}

	}

	public static CompleteCoordinate VectorAVG() {

		double x = 0, y = 0, theta = 0, sinSum = 0, cosSum = 0;

		Iterator<CompleteCoordinate> it = qe.iterator();

		while (it.hasNext()) {

			CompleteCoordinate a = (CompleteCoordinate) it.next();

			x += a.getX();
			y += a.getY();

			cosSum += Math.cos(Math.toRadians(a.getTheta()));

			sinSum += Math.sin(Math.toRadians(a.getTheta()));

		}

		theta = Math.toDegrees(Math.atan2(sinSum, cosSum));

		CompleteCoordinate MyAvgPosition = new CompleteCoordinate(
				(x / qe.size()), (y / qe.size()), theta);

		return MyAvgPosition;

	}

}
