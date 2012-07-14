package action.vision;

import perceptor.joints.HingeJointPerceptor;
import perceptor.localization.LocalizationResults;
import perceptor.vision.Vision;
import perceptor.worldstate.TeamState;

public class FindOpponentsGoal {

	public static double[] Act() {

		double[] OppGoal = new double[3];
		OppGoal[0] = Double.NaN;
		OppGoal[1] = Double.NaN;
		OppGoal[2] = Double.NaN;

		if(Vision.isiSee()){

			if (TeamState.getTeamSide().equalsIgnoreCase("left")) {
				for (int i = 0; i < LocalizationResults.getLandmarks().size(); i++) {

					if (LocalizationResults.getLandmarks().elementAt(i).getName()
							.equals("g1r")) {

						OppGoal[0] = LocalizationResults.getLandmarks()
								.elementAt(i).getHorizontal_Angle();

						if(Double.isNaN(OppGoal[2])){

							OppGoal[2] = LocalizationResults.getLandmarks()
									.elementAt(i).getDistance();

						}else{

							OppGoal[2] = (OppGoal[2] + LocalizationResults.getLandmarks()
									.elementAt(i).getDistance())/2;

						}

					} else if (LocalizationResults.getLandmarks().elementAt(i)
							.getName().equals("g2r")) {

						OppGoal[1] = LocalizationResults.getLandmarks()
								.elementAt(i).getHorizontal_Angle();

						if(Double.isNaN(OppGoal[2])){

							OppGoal[2] = LocalizationResults.getLandmarks()
									.elementAt(i).getDistance();

						}else{

							OppGoal[2] = (OppGoal[2] + LocalizationResults.getLandmarks()
									.elementAt(i).getDistance())/2;

						}

					}
				}
			} else {

				for (int i = 0; i < LocalizationResults.getLandmarks().size(); i++) {

					if (LocalizationResults.getLandmarks().elementAt(i).getName()
							.equals("g1l")) {

						OppGoal[0] = LocalizationResults.getLandmarks()
								.elementAt(i).getHorizontal_Angle()
								+ HingeJointPerceptor.getHj1();

						if(Double.isNaN(OppGoal[2])){

							OppGoal[2] = LocalizationResults.getLandmarks()
									.elementAt(i).getDistance();

						}else{

							OppGoal[2] = (OppGoal[2] + LocalizationResults.getLandmarks()
									.elementAt(i).getDistance())/2;

						}

					} else if (LocalizationResults.getLandmarks().elementAt(i)
							.getName().equals("g2l")) {

						OppGoal[1] = LocalizationResults.getLandmarks()
								.elementAt(i).getHorizontal_Angle()
								+ HingeJointPerceptor.getHj1();

						if(Double.isNaN(OppGoal[2])){

							OppGoal[2] = LocalizationResults.getLandmarks()
									.elementAt(i).getDistance();

						}else{

							OppGoal[2] = (OppGoal[2] + LocalizationResults.getLandmarks()
									.elementAt(i).getDistance())/2;

						}

					}
				}
			}
		}

		return OppGoal;

	}

}
