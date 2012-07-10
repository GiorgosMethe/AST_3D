package perceptor.localization;

public class CompleteCoordinate {

	public double X, Y, Theta;

	public CompleteCoordinate(double x, double y, double theta) {
		super();
		X = x;
		Y = y;
		Theta = theta;
	}

	public double getX() {
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

	public double getTheta() {
		return Theta;
	}

	public void setTheta(double theta) {
		Theta = theta;
	}

}
