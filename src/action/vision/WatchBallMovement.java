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
package action.vision;

import java.util.Vector;

import perceptor.joints.HingeJointPerceptor;
import perceptor.localization.Coordinate;
import perceptor.localization.TriangleLocalization;
import perceptor.vision.Ball;

public class WatchBallMovement {

	public static Vector<Coordinate> BallObservationsPrevious = new Vector<Coordinate>();
	public static Vector<Integer> TimesPrevious = new Vector<Integer>();
	public static Vector<Integer> TimesNow = new Vector<Integer>();
	public static Vector<Coordinate> BallObservationsNow = new Vector<Coordinate>();
	public static MovingObject MovingBall;
	public static int timer = 0;

	public static MovingObject Watch() {

		if (Ball.isSeeTheBall())

			if (timer < 5) {

				BallObservationsPrevious.add(TriangleLocalization
						.get_det_with_distance_angle(0, 0,
								(Ball.getAngleX() + HingeJointPerceptor
										.getHj1()), Ball.getDistance()));

				timer++;

			} else if (timer >= 5 && timer < 10) {

				timer++;

			} else if (timer >= 10 && timer < 15) {

				BallObservationsNow.add(TriangleLocalization
						.get_det_with_distance_angle(0, 0,
								(Ball.getAngleX() + HingeJointPerceptor
										.getHj1()), Ball.getDistance()));

				timer++;

			} else {

				timer = 0;

				Coordinate ballPrevious = new Coordinate(0, 0);
				Coordinate ballNow = new Coordinate(0, 0);

				float movingAngle;
				float speed;

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

				ballPrevious.setX((ballPrevious.getX() / 5));
				ballPrevious.setY((ballPrevious.getY() / 5));

				ballNow.setX((ballNow.getX() / 5));
				ballNow.setY((ballNow.getY() / 5));

				movingAngle = (float) TriangleLocalization
						.FindAngleBetweenCoordinates(ballPrevious, ballNow);
				speed = (float) (TriangleLocalization
						.FindDistanceAmong2Coordinates(ballPrevious, ballNow) / 0.1);

				MovingBall = new MovingObject(ballNow, movingAngle, speed);

				BallObservationsPrevious.removeAllElements();
				BallObservationsNow.removeAllElements();
				return MovingBall;

			}

		return null;

	}

}
