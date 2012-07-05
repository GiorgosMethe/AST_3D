package action.sensor;

import perceptor.sensors.ForceResistancePerceptor;
import perceptor.sensors.GyroScope;
import action.fsm.CFstates;
import action.simple.StandUp;

public class CheckIfFall {

	public static boolean fallen = false;
	public static double sumDown = 0;
	public static double sumUp = 0;

	public static void Check() {

		if (CFstates.getState().equalsIgnoreCase("Start")) {

			fallen = false;

			if (Math.abs(GyroScope.getAngleY()) > 100
					|| Math.abs(GyroScope.getAngleZ()) > 100) {

				CFstates.setState("WaitForFRP");

			}

		} else if (CFstates.getState().equalsIgnoreCase("WaitForFRP")) {

			fallen = false;

			if (CFstates.getCheckFRPtimer() == 200) {

				CFstates.setState("CheckFRP");
				CFstates.setCheckFRPtimer(0);

			} else {

				CFstates.setCheckFRPtimer(CFstates.getCheckFRPtimer() + 1);

			}

		} else if (CFstates.getState().equalsIgnoreCase("CheckFRP")) {

			fallen = false;

			if (CFstates.getCheckFRPtimer() == 50) {

				if (sumDown > 1500) {

					CFstates.setState("Start");

				} else {

					CFstates.setState("StandUp");

				}

				CFstates.setCheckFRPtimer(0);

				sumDown = 0;

			} else {

				// System.out.println("--");
				if (ForceResistancePerceptor.ForcePerceptors.size() != 0) {

					for (int i = 0; i < ForceResistancePerceptor.ForcePerceptors
							.size(); i++) {

						sumDown += ForceResistancePerceptor.ForcePerceptors
								.elementAt(i).getForce().getZ();

					}

				}

				CFstates.setCheckFRPtimer(CFstates.getCheckFRPtimer() + 1);

			}

		} else if (CFstates.getState().equalsIgnoreCase("StandUp")) {

			fallen = true;

			if (StandUp.Act()) {

				CFstates.setState("CheckIfUp");

			} else {

			}

		} else if (CFstates.getState().equalsIgnoreCase("CheckIfUp")) {

			fallen = true;

			if (CFstates.getCheckFRPtimer() == 20) {

				if (sumUp > 700) {

					CFstates.setState("Start");

				} else {

					CFstates.setState("StandUp");

				}

				sumUp = 0;
				CFstates.setCheckFRPtimer(0);

			} else {

				// System.out.println("--");
				if (ForceResistancePerceptor.ForcePerceptors.size() != 0) {

					for (int i = 0; i < ForceResistancePerceptor.ForcePerceptors
							.size(); i++) {

						sumUp += ForceResistancePerceptor.ForcePerceptors
								.elementAt(i).getForce().getZ();

					}
				}

				CFstates.setCheckFRPtimer(CFstates.getCheckFRPtimer() + 1);
			}
		}

	}

}
