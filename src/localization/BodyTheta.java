package localization;

public class BodyTheta {

	public float ThetaStart;
	public float ThetaEnd;

	public BodyTheta(float thetaStart, float thetaEnd) {
		ThetaStart = thetaStart;
		ThetaEnd = thetaEnd;
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

}
