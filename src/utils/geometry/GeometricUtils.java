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
package utils.geometry;

import perceptor.localization.Coordinate;

import com.vividsolutions.jts.geom.LineSegment;

public class GeometricUtils {

	public static com.vividsolutions.jts.geom.Coordinate FindIntersection(
			Coordinate a1, Coordinate a2, Coordinate b1, Coordinate b2) {

		LineSegment a = new LineSegment();
		a.setCoordinates(
				new com.vividsolutions.jts.geom.Coordinate(a1.X, a1.Y),
				new com.vividsolutions.jts.geom.Coordinate(a2.X, a2.Y));

		LineSegment b = new LineSegment();
		b.setCoordinates(
				new com.vividsolutions.jts.geom.Coordinate(b1.X, b1.Y),
				new com.vividsolutions.jts.geom.Coordinate(b2.X, b2.Y));

		if (a != null && b != null) {

			com.vividsolutions.jts.geom.Coordinate result = a.intersection(b);

			if (result != null) {
				return result;
			} else {
				return null;
			}

		}

		return null;

	}

	public static double FindDistance(Coordinate a1, Coordinate a2,
			Coordinate b1, Coordinate b2) {

		LineSegment a = new LineSegment();
		a.setCoordinates(
				new com.vividsolutions.jts.geom.Coordinate(a1.X, a1.Y),
				new com.vividsolutions.jts.geom.Coordinate(a2.X, a2.Y));

		LineSegment b = new LineSegment();
		b.setCoordinates(
				new com.vividsolutions.jts.geom.Coordinate(b1.X, b1.Y),
				new com.vividsolutions.jts.geom.Coordinate(b2.X, b2.Y));

		if (a != null && b != null) {

			double result = a.distance(b);

			return result;

		} else {

			return 0;

		}

	}

}
