package action.vision;

import perceptor.joints.HingeJointPerceptor;
import perceptor.localization.LocalizationResults;
import perceptor.worldstate.TeamState;

public class FindOpponentsGoal {

	public static double[] Act() {

		double[] OppGoal = new double[2];
		OppGoal[0] = Double.NaN;
		OppGoal[1] = Double.NaN;

		boolean IseeGoal = false;
		if (TeamState.getTeamSide().equalsIgnoreCase("left")) {
			for (int i = 0; i < LocalizationResults.getLandmarks().size(); i++) {

				if (LocalizationResults.getLandmarks().elementAt(i).getName()
						.equals("g1r")) {

					OppGoal[0] = LocalizationResults.getLandmarks()
							.elementAt(i).getHorizontal_Angle()
							+ HingeJointPerceptor.getHj1();

				} else if (LocalizationResults.getLandmarks().elementAt(i)
						.getName().equals("g2r")) {

					OppGoal[1] = LocalizationResults.getLandmarks()
							.elementAt(i).getHorizontal_Angle()
							+ HingeJointPerceptor.getHj1();

				}
			}
		} else {

			for (int i = 0; i < LocalizationResults.getLandmarks().size(); i++) {

				if (LocalizationResults.getLandmarks().elementAt(i).getName()
						.equals("g1l")) {

					OppGoal[0] = LocalizationResults.getLandmarks()
							.elementAt(i).getHorizontal_Angle()
							+ HingeJointPerceptor.getHj1();

				} else if (LocalizationResults.getLandmarks().elementAt(i)
						.getName().equals("g2l")) {

					OppGoal[1] = LocalizationResults.getLandmarks()
							.elementAt(i).getHorizontal_Angle()
							+ HingeJointPerceptor.getHj1();

				}
			}
		}

		return OppGoal;

	}

}
