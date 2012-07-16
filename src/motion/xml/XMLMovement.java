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

import motion.xml.check.Check4Change;
import connection.utils.ServerCyrcles;

public class XMLMovement {

	public static String execute(String name) {

		Motion motion = null;
		Phase phase;
		boolean ChangeFlag = false;

		int MoveCategory = 0;

		ChangeFlag = Check4Change.check(name);

		if (ChangeFlag) {

			motion = GetMotion.Get(name);

		} else {

			motion = GetMotion.Get(MotionPlaying.getMotionName());

		}

		if (MotionPlaying.getMotionName() == null) {

			if (motion != null) {

				MotionPlaying.setMotionName(motion.getName());
				MotionPlaying.setMotionPhase(motion.getFirstPhase());
				MotionPlaying.setStartCyrcle(ServerCyrcles.getCyrclesNow());
				MoveCategory = 1;

			} else {

			}

		} else {

			MoveCategory = 2;
			phase = GetPhase.get(motion, MotionPlaying.getMotionPhase());
			if ((phase.getDuration() / 20) <= (ServerCyrcles.getCyrclesNow() - MotionPlaying
					.getStartCyrcle())) {
				MoveCategory = 3;

				if (ChangeFlag == false) {

					if (phase.getFinalize() != null) {

						if (phase.getFinalize().equalsIgnoreCase(
								MotionPlaying.MotionPhase)) {

							MotionPlaying.setMotionName(null);
							MotionPlaying.setMotionPhase(null);
							return "(lae4 0)(rae4 0)(lae3 0)(rae3 0)(lae2 0)(rae2 0)(lae1 0)(rae1 0)(rle1 0)(rle2 0)(rle3 0)(rle4 0)(rle5 0)(rle6 0)(lle1 0)(lle2 0)(lle3 0)(lle4 0)(lle5 0)(lle6 0)";

						} else {

							MotionPlaying.setMotionPhase(GetPhase.get(motion,
									phase.getFinalize()).getName());
							MotionPlaying.setStartCyrcle(ServerCyrcles
									.getCyrclesNow());
						}
					} else {

						if (GetPhase.getNext(motion,
								MotionPlaying.getMotionPhase()) == null) {

							MotionPlaying.setMotionName(null);
							MotionPlaying.setMotionPhase(null);
							return "(lae4 0)(rae4 0)(lae3 0)(rae3 0)(lae2 0)(rae2 0)(lae1 0)(rae1 0)(rle1 0)(rle2 0)(rle3 0)(rle4 0)(rle5 0)(rle6 0)(lle1 0)(lle2 0)(lle3 0)(lle4 0)(lle5 0)(lle6 0)";
						}
						MotionPlaying.setMotionPhase(GetPhase.getNext(motion,
								MotionPlaying.getMotionPhase()));
						MotionPlaying.setStartCyrcle(ServerCyrcles
								.getCyrclesNow());

					}
				} else {
					if (GetPhase
							.getNext(motion, MotionPlaying.getMotionPhase()) == null) {

						MotionPlaying.setMotionName(null);
						MotionPlaying.setMotionPhase(null);
						return "(lae4 0)(rae4 0)(lae3 0)(rae3 0)(lae2 0)(rae2 0)(lae1 0)(rae1 0)(rle1 0)(rle2 0)(rle3 0)(rle4 0)(rle5 0)(rle6 0)(lle1 0)(lle2 0)(lle3 0)(lle4 0)(lle5 0)(lle6 0)";
					}
					MotionPlaying.setMotionPhase(GetPhase.getNext(motion,
							MotionPlaying.getMotionPhase()));
					MotionPlaying.setStartCyrcle(ServerCyrcles.getCyrclesNow());
				}
			}

		}

		if (MoveCategory == 1 || MoveCategory == 3) {

			return MoveJoints.performMove(GetPhase.get(motion,
					MotionPlaying.getMotionPhase()));

		}

		return "";

	}

}
