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

import motion.old.CurrentMotion;
import motion.old.MotionController;
import motion.xml.MotionPlaying;
import motion.xml.XMLMovement;

public class PerformMovement {

	public static boolean OldOn = false;
	public static String OldMotion = "";

	public static String run() {

		String AgentAct = "";

		if (OldOn) {

			AgentAct = MotionController.MotionFactory(OldMotion);
			if (CurrentMotion.getCurrentMotionPlaying().equalsIgnoreCase("")) {
				OldOn = false;
			}

		} else {

			if (MotionTrigger.getMotion().equalsIgnoreCase("Forwards50")) {
				AgentAct = XMLMovement.execute("walk_fine");
			} else if (MotionTrigger.getMotion().equalsIgnoreCase("TurnLeft40")) {

				if (MotionPlaying.getMotionName() == null) {
					AgentAct = MotionController.MotionFactory("TurnLeft40");
					OldOn = true;
					OldMotion = "TurnLeft40";
				} else {

					AgentAct = XMLMovement.execute("");

				}
			} else if (MotionTrigger.getMotion().equalsIgnoreCase("fall_left")) {
				AgentAct = XMLMovement.execute("fall_left");
			} else if (MotionTrigger.getMotion().equalsIgnoreCase("fall_right")) {
				AgentAct = XMLMovement.execute("fall_right");
			} else if (MotionTrigger.getMotion()
					.equalsIgnoreCase("TurnRight40")) {

				if (MotionPlaying.getMotionName() == null) {
					AgentAct = MotionController.MotionFactory("TurnRight40");
					OldOn = true;
					OldMotion = "TurnRight40";
				} else {

					AgentAct = XMLMovement.execute("");

				}
			} else if (MotionTrigger.getMotion().equalsIgnoreCase(
					"SideStepRight")) {
				AgentAct = XMLMovement.execute("strafe_right");
			} else if (MotionTrigger.getMotion().equalsIgnoreCase(
					"SideStepLeft")) {
				AgentAct = XMLMovement.execute("strafe_left");
			} else if (MotionTrigger.getMotion().equalsIgnoreCase("stand_back")) {
				AgentAct = XMLMovement.execute("stand_back");
			} else if (MotionTrigger.getMotion()
					.equalsIgnoreCase("stand_front")) {
				AgentAct = XMLMovement.execute("stand_front");
			} else if (MotionTrigger.getMotion().equalsIgnoreCase(
					"KickForwardRightOld")) {
				if (MotionPlaying.getMotionName() == null) {
					AgentAct = MotionController
							.MotionFactory("KickForwardRight");
					OldOn = true;
					OldMotion = "KickForwardRight";
				} else {

					AgentAct = XMLMovement.execute("");
				}

			} else if (MotionTrigger.getMotion().equalsIgnoreCase(
					"KickForwardLeftOld")) {
				if (MotionPlaying.getMotionName() == null) {
					AgentAct = MotionController
							.MotionFactory("KickForwardLeft");
					OldOn = true;
					OldMotion = "KickForwardLeft";
				} else {

					AgentAct = XMLMovement.execute("");
				}
			} else if (MotionTrigger.getMotion().equalsIgnoreCase(
					"KickForwardRightNormal")) {
				AgentAct = XMLMovement.execute("rigth_front_front_kick");

			} else if (MotionTrigger.getMotion().equalsIgnoreCase(
					"KickForwardRight")) {
				AgentAct = XMLMovement.execute("strong_right_kick");

			} else if (MotionTrigger.getMotion().equalsIgnoreCase("init")) {
				AgentAct = XMLMovement.execute("init");

			} else {
				AgentAct = XMLMovement.execute("");
			}
		}

		return AgentAct;

	}

}
