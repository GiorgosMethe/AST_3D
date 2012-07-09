package action.vision;

import perceptor.localization.Coordinate;

public class MovingObject {

	public Coordinate Object;
	public float MovingAngle;
	public float Speed;

	public MovingObject(Coordinate object, float movingAngle, float speed) {
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

	public void setMovingAngle(float movingAngle) {
		MovingAngle = movingAngle;
	}

	public double getSpeed() {
		return Speed;
	}

	public void setSpeed(float speed) {
		Speed = speed;
	}

}
