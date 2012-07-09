/**
 * 
 */
package action.vision;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.LocalizationResults;
import perceptor.localization.TriangleLocalization;
import connection.utils.ServerCyrcles;

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
public class WatchBallMovement {

	public static Vector<Coordinate> BallObservationsPrevious = new Vector<Coordinate>();
	public static Vector<Integer> TimesPrevious = new Vector<Integer>();
	public static Vector<Integer> TimesNow = new Vector<Integer>();
	public static Vector<Coordinate> BallObservationsNow = new Vector<Coordinate>();

	public static void Watch() {

		if (BallObservationsPrevious.size() < 30) {

			// System.out.println("BallObservationsPrevious");

			BallObservationsPrevious
					.add(LocalizationResults.getBall_location());
			TimesPrevious.add(ServerCyrcles.getCyrclesNow());

		} else if (BallObservationsNow.size() < 30) {

			// System.out.println("BallObservationsNow");

			BallObservationsNow.add(LocalizationResults.getBall_location());
			TimesNow.add(ServerCyrcles.getCyrclesNow());

		} else {

			double PreviousX = 0;
			double PreviousY = 0;
			double NowX = 0;
			double NowY = 0;
			int PreviousTime = 0;
			int NowTime = 0;

			for (int i = 0; i < BallObservationsNow.size(); i++) {

				PreviousX += BallObservationsPrevious.elementAt(i).getX();
				PreviousY += BallObservationsPrevious.elementAt(i).getY();
				NowX += BallObservationsNow.elementAt(i).getX();
				NowY += BallObservationsNow.elementAt(i).getY();
				PreviousTime += TimesPrevious.elementAt(i);
				NowTime += TimesNow.elementAt(i);

			}

			BallObservationsPrevious.removeAllElements();
			BallObservationsNow.removeAllElements();

			PreviousX = PreviousX / 30;
			PreviousY = PreviousY / 30;

			NowX = NowX / 30;
			NowY = NowY / 30;

			PreviousTime = PreviousTime / 30;
			NowTime = NowTime / 30;

			System.out.println("x  " + PreviousX);
			System.out.println("x'  " + NowX);

			System.out.println("y  " + PreviousY);
			System.out.println("y'  " + NowY);

			System.out.println("PreviousTime  " + PreviousTime);
			System.out.println("NowTime  " + NowTime);

			Coordinate a = new Coordinate(PreviousX, PreviousY);
			Coordinate b = new Coordinate(NowX, NowY);

			double distance = TriangleLocalization
					.FindDistanceAmong2Coordinates(a, b);
			double angle = TriangleLocalization.FindAngleBetweenCoordinates(a,
					b);

			double speed = distance / ((NowTime - PreviousTime) / 50);

			System.out.println("angle  " + angle);
			System.out.println("distance  " + distance);
			System.out.println("speed  " + speed);

		}

	}

}
