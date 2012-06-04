package motion.kinematics;

public class JointPosition2D {

	public float PositionX;
	public float PositionY;

	public JointPosition2D(float positionX, float positionY) {

		PositionX = positionX;
		PositionY = positionY;
	}

	public float getPositionX() {
		return PositionX;
	}

	public void setPositionX(float positionX) {
		PositionX = positionX;
	}

	public float getPositionY() {
		return PositionY;
	}

	public void setPositionY(float positionY) {
		PositionY = positionY;
	}

}
