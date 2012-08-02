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
package motion.utils;

import motion.old.MotionController;
import motion.xml.XMLMovement;

public class PerformMovement {

	public static String run() {

		String AgentAct = "";
		MotionController dnc=new MotionController();
		if (MotionTrigger.getMotion().equalsIgnoreCase("Forwards50")) {
			//AgentAct = XMLMovement.execute("walk_fine");
			AgentAct = dnc.MotionFactory("Forwards50");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("TurnLeft40")) {
			AgentAct = XMLMovement.execute("turn_left");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("fall_left")) {
			AgentAct = XMLMovement.execute("fall_left");
		} else if (MotionTrigger.getMotion().equalsIgnoreCase("fall_right")) {
			AgentAct = XMLMovement.execute("fall_right");
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
