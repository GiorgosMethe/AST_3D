package localization;

public class CompleteCoordinate extends Coordinate {

	public double Theta;

	public CompleteCoordinate(double x, double y, double Theta) {
		super(x, y);
		Theta = this.Theta;
	}

	public double getTheta() {
		return Theta;
	}

	public void setTheta(double theta) {
		Theta = theta;
	}

}
