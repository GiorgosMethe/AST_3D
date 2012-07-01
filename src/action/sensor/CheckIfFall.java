package action.sensor;

import motion.old.MotionTrigger;
import motion.xml.MotionPlaying;
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

			if ((Math.abs(GyroScope.getAngleY()) + Math.abs(GyroScope
					.getAngleZ())) > 200) {

				CFstates.setState("w82stop");
				System.err.println("EPESA");

			}

		} else if (CFstates.getState().equalsIgnoreCase("w82stop")) {

			if (MotionPlaying.getMotionName() == null) {

				CFstates.setState("CheckFRP");

			} else {

				MotionTrigger.setMotion("");

			}

		} else if (CFstates.getState().equalsIgnoreCase("CheckFRP")) {

			if (CFstates.getCheckFRPtimer() == 20) {

				if (sumDown > 100) {

					CFstates.setState("Start");

				} else {

					CFstates.setState("StandUp");

				}

				CFstates.setCheckFRPtimer(0);
				System.out.println("Sum Down--" + sumDown);
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

			if (StandUp.Act()) {

				CFstates.setState("CheckIfUp");

			} else {

			}

		} else if (CFstates.getState().equalsIgnoreCase("CheckIfUp")) {

			if (CFstates.getCheckFRPtimer() == 20) {

				if (sumUp > 100) {

					CFstates.setState("Start");

				} else {

					CFstates.setState("StandUp");

				}

				System.out.println("Sum Up--" + sumUp);
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
