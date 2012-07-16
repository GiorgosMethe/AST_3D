/*******************************************************************************
 * Technical University of Crete
 * 
 * Thesis Project
 * 
 * Author:	Methenitis K. Georgios
 * 
 * Abstract  : Player Behavior and Team Strategy 
 * 			for the RoboCup 3D Simulation League
 * 
 * Date:  		July 2012
 ******************************************************************************/
package motion.xml;

import motion.utils.GetNormalJointValueDegrees;

public class MoveJoints {

	public static String performMove(Phase pha) {

		String[] NaoJoints = { "rae1", "rae2", "rae3", "rae4", "lae1", "lae2",
				"lae3", "lae4", "lle1", "lle2", "lle3", "lle4", "lle5", "lle6",
				"rle1", "rle2", "rle3", "rle4", "rle5", "rle6" };

		boolean[] Move = { false, false, false, false, false, false, false,
				false, false, false, false, false, false, false, false, false,
				false, false, false, false };

		GetNormalJointValueDegrees gNjVd = new GetNormalJointValueDegrees();
		String Str = "";
		if (pha.movements.size() > 0) {
			for (int i = 0; i < pha.movements.size(); i++) {

				String joint = pha.movements.elementAt(i).axis_name;

				if ((MotionPlaying.getMotionName()
						.equalsIgnoreCase("walk_fine"))
						&& (WalkLeaning.getLean().equalsIgnoreCase("left") || WalkLeaning
								.getLean().equalsIgnoreCase("right"))) {

					Float move = pha.movements.elementAt(i).value;

					if (WalkLeaning.getLean().equalsIgnoreCase("left")
							&& pha.getName().equalsIgnoreCase("walk_attempt4")) {
						if (joint.equalsIgnoreCase("lle3")) {
							move = (float) 53;
						} else if (joint.equalsIgnoreCase("lle5")) {
							move = (float) 32;
						}
					} else if (WalkLeaning.getLean().equalsIgnoreCase("right")
							&& pha.getName().equalsIgnoreCase("walk_attempt6")) {
						if (joint.equalsIgnoreCase("rle3")) {
							move = (float) 53;
						} else if (joint.equalsIgnoreCase("rle5")) {
							move = (float) 32;
						}
					}

					for (int j = 0; j < NaoJoints.length; j++) {
						if (NaoJoints[j].equalsIgnoreCase(joint)) {
							Move[j] = true;
						}
					}

					// ////////
					Float velocity = gNjVd.Get(joint, move)
							/ (pha.duration / 20);
					String value2str = Float.toString(velocity);
					Str += "(" + joint + " " + value2str + ")";

				} else {

					for (int j = 0; j < NaoJoints.length; j++) {
						if (NaoJoints[j].equalsIgnoreCase(joint)) {
							Move[j] = true;
						}
					}

					Float move = pha.movements.elementAt(i).value;
					// ///////
					Float velocity = gNjVd.Get(joint, move)
							/ (pha.duration / 20);
					String value2str = Float.toString(velocity);
					Str += "(" + joint + " " + value2str + ")";

				}

			}

			Str += StopJoints(NaoJoints, Move);
		} else {

			Str = "(lae4 0)(rae4 0)(lae3 0)(rae3 0)(lae2 0)(rae2 0)(lae1 0)(rae1 0)(rle1 0)(rle2 0)(rle3 0)(rle4 0)(rle5 0)(rle6 0)(lle1 0)(lle2 0)(lle3 0)(lle4 0)(lle5 0)(lle6 0)";

		}

		return Str;

	}

	public static String StopJoints(String[] NaoJoints, boolean[] Move) {

		String Str = "";
		for (int i = 0; i < NaoJoints.length; i++) {
			if (Move[i] == false) {
				Str += "(" + NaoJoints[i] + " " + 0.0f + ")";
			}
		}

		return Str;

	}

}
