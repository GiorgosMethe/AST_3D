package action.vision;

import perceptor.localization.Coordinate;

public class MovingObject {

	public Coordinate Object;
	public double MovingAngle;
	public double Speed;

	public MovingObject(Coordinate object, double movingAngle, double speed) {
		Object = object;
		MovingAngle = movingAngle;
		Speed = speed;
	}

	public Coordinate getObject() {
		return Object;
	}

	public void setObject(Coordinate object) {
		Object = object;
	}

	public double getMovingAngle() {
		return MovingAngle;
	}

	public void setMovingAngle(double movingAngle) {
		MovingAngle = movingAngle;
	}

	public double getSpeed() {
		return Speed;
	}

	public void setSpeed(double speed) {
		Speed = speed;
	}

}
