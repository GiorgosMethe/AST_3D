package perceptor.localization;

public class DangerousObject {

	public float ThetaStart;
	public float ThetaEnd;
	public float Distance;

	public DangerousObject(float thetaStart, float thetaEnd, float distance) {
		super();
		ThetaStart = thetaStart;
		ThetaEnd = thetaEnd;
		Distance = distance;
	}

	public float getThetaStart() {
		return ThetaStart;
	}

	public void setThetaStart(float thetaStart) {
		ThetaStart = thetaStart;
	}

	public float getThetaEnd() {
		return ThetaEnd;
	}

	public void setThetaEnd(float thetaEnd) {
		ThetaEnd = thetaEnd;
	}

	public float getDistance() {
		return Distance;
	}

	public void setDistance(float distance) {
		Distance = distance;
	}

}
