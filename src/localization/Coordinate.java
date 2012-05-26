/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/
package localization;

public class Coordinate {
	public double X,Y;
	public Coordinate(double x, double y){
		X=x;
		Y=y;
	}
	public  double getX() {
		return X;
	}
	public void setX(double x) {
		X = x;
	}
	public double getY() {
		return Y;
	}
	public void setY(double y) {
		Y = y;
	}
	
	public static Coordinate addCoordinate(Coordinate a, Coordinate b){
		
		Coordinate c = new Coordinate((a.X + b.X),(b.Y + b.Y));
		
		return c;
		
		
	}

}