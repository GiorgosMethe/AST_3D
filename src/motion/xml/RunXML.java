package motion.xml;

import motion.old.MotionTrigger;

public class RunXML {

	public static String run() {

		String AgentAct = "";

		if (MotionTrigger.getMotion().equalsIgnoreCase("Forwards50")) {
			AgentAct = XMLMovement.execute("walk_fine");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("TurnLeft40")) {
			AgentAct = XMLMovement.execute("turn_left");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("TurnRight40")) {
			AgentAct = XMLMovement.execute("turn_right");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("SideStepRight")) {
			AgentAct = XMLMovement.execute("strafe_right");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("SideStepLeft")) {
			AgentAct = XMLMovement.execute("strafe_left");
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
