package geometry;

import perceptor.localization.Coordinate;
import com.vividsolutions.jts.geom.LineSegment;



public class GeometricUtils {
	
	
	public static com.vividsolutions.jts.geom.Coordinate FindIntersection(Coordinate a1, Coordinate a2,Coordinate b1, Coordinate b2){
		
		
		
		LineSegment a = new LineSegment();
		a.setCoordinates(new com.vividsolutions.jts.geom.Coordinate(a1.X, a1.Y),
				new com.vividsolutions.jts.geom.Coordinate(a2.X, a2.Y));
		
		LineSegment b = new LineSegment();
		b.setCoordinates(new com.vividsolutions.jts.geom.Coordinate(b1.X, b1.Y),
				new com.vividsolutions.jts.geom.Coordinate(b2.X, b2.Y));
		
		
		return a.intersection(b);
		
	}
	

}
