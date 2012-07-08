package motion.utils;

import motion.old.MotionTrigger;
import motion.xml.XMLMovement;

public class PerformMovement {

	public static String run() {

		String AgentAct = "";

		if (MotionTrigger.getMotion().equalsIgnoreCase("Forwards50")) {
			AgentAct = XMLMovement.execute("walk_fine");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("Forwards50s")) {
			AgentAct = XMLMovement.execute("walk_fine_s");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("TurnLeft40")) {
			AgentAct = XMLMovement.execute("turn_left");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("TurnRight40")) {
			AgentAct = XMLMovement.execute("turn_right");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("SideStepRight")) {
			AgentAct = XMLMovement.execute("strafe_right");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("SideStepLeft")) {
			AgentAct = XMLMovement.execute("strafe_left");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("stand_back")) {
			AgentAct = XMLMovement.execute("stand_back");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("stand_front")) {
			AgentAct = XMLMovement.execute("stand_front");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase(
				"KickForwardRight")
				|| MotionTrigger.getMotion()
						.equalsIgnoreCase("KickForwardLeft")) {
			AgentAct = XMLMovement.execute("strong_right_kick");
		} else {
			AgentAct = XMLMovement.execute("");
		}

		return AgentAct;

	}

}
