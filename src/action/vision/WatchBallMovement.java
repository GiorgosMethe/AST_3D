/**
 * 
 */
package action.vision;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import perceptor.vision.Ball;

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
	public static MovingObject MovingBall;
	public static int timer = 0;

	public static MovingObject Watch() {

		if (Ball.isSeeTheBall())

			if (timer < 10) {

				BallObservationsPrevious.add(TriangleLocalization
						.get_det_with_distance_angle(0, 0, Ball.getAngleX(),
								Ball.getDistance()));

				timer++;

			} else if (timer >= 10 && timer < 20) {

				timer++;

			} else if (timer >= 20 && timer < 30) {

				BallObservationsNow.add(TriangleLocalization
						.get_det_with_distance_angle(0, 0, Ball.getAngleX(),
								Ball.getDistance()));

				timer++;

			} else {

				timer = 0;

				Coordinate ballPrevious = new Coordinate(0, 0);
				Coordinate ballNow = new Coordinate(0, 0);

				double movingAngle;
				double speed;

				for (int i = 0; i < BallObservationsPrevious.size(); i++) {

					ballPrevious.setX(ballPrevious.getX()
							+ BallObservationsPrevious.elementAt(i).getX());
					ballPrevious.setY(ballPrevious.getY()
							+ BallObservationsPrevious.elementAt(i).getY());

					ballNow.setX(ballNow.getX()
							+ BallObservationsNow.elementAt(i).getX());
					ballNow.setY(ballNow.getY()
							+ BallObservationsNow.elementAt(i).getY());

				}

				ballPrevious.setX((ballPrevious.getX() / 10));
				ballPrevious.setY((ballPrevious.getY() / 10));

				ballNow.setX((ballNow.getX() / 10));
				ballNow.setY((ballNow.getY() / 10));

				movingAngle = TriangleLocalization.FindAngleBetweenCoordinates(
						ballPrevious, ballNow);
				speed = TriangleLocalization.FindDistanceAmong2Coordinates(
						ballPrevious, ballNow);

				MovingBall = new MovingObject(ballNow, movingAngle, speed);

				return MovingBall;

			}

		return null;

	}

}
