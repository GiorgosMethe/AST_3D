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
package motion.old;

import java.util.Vector;

import motion.utils.GetNormalJointValue;
import motion.utils.GetNormalJointValueDegrees;
import connection.utils.ServerCyrcles;

public class Motions {

	private static int motionOffsetValues;

	public static String Motion(String motionName, int i, int SpeedControl,
			double hardness) {

		boolean xml = false;
		String msg = "";
		Vector<String> MotionVector = new Vector<String>();
		MotionVector = readMotion(motionName);
		GetNormalJointValueDegrees gNjVd = new GetNormalJointValueDegrees();
		GetNormalJointValue gNjV = new GetNormalJointValue();

		String MotionPoseSplit = "";

		if (MotionVector.elementAt(0).equalsIgnoreCase("#WEBOTS_MOTION,V1.0")) {
			MotionPoseSplit = ",";
			motionOffsetValues = 2;
		} else if (MotionVector.elementAt(0).equalsIgnoreCase("XML_Motion")) {
			MotionPoseSplit = ",";
			motionOffsetValues = 1;
			xml = true;
			System.out.println("xml");
		} else {
			MotionPoseSplit = "%";
			motionOffsetValues = 1;
		}

		String[] joint = MotionVector.elementAt(1).split(MotionPoseSplit);
		String[] value = MotionVector.elementAt(i + 1).split(MotionPoseSplit);

		for (int x = 0; x < joint.length; x++) {

			String jointReal = "";
			if (xml == true) {
				jointReal = joint[x];
			} else {
				if (joint[x].equalsIgnoreCase("LHipYawPitch")) {
					jointReal = "lle1";
				} else if (joint[x].equalsIgnoreCase("LHipRoll")) {
					jointReal = "lle2";
				} else if (joint[x].equalsIgnoreCase("LHipPitch")) {
					jointReal = "lle3";
				} else if (joint[x].equalsIgnoreCase("LKneePitch")) {
					jointReal = "lle4";
				} else if (joint[x].equalsIgnoreCase("LAnklePitch")) {
					jointReal = "lle5";
				} else if (joint[x].equalsIgnoreCase("LAnkleRoll")) {
					jointReal = "lle6";
				} else if (joint[x].equalsIgnoreCase("RHipYawPitch")) {
					jointReal = "rle1";
				} else if (joint[x].equalsIgnoreCase("RHipRoll")) {
					jointReal = "rle2";
				} else if (joint[x].equalsIgnoreCase("RHipPitch")) {
					jointReal = "rle3";
				} else if (joint[x].equalsIgnoreCase("RKneePitch")) {
					jointReal = "rle4";
				} else if (joint[x].equalsIgnoreCase("RAnklePitch")) {
					jointReal = "rle5";
				} else if (joint[x].equalsIgnoreCase("RAnkleRoll")) {
					jointReal = "rle6";
				} else if (joint[x].equalsIgnoreCase("HeadYaw")) {
					jointReal = "he1";
				} else if (joint[x].equalsIgnoreCase("HeadPitch")) {
					jointReal = "he2";
				} else if (joint[x].equalsIgnoreCase("LShoulderPitch")) {
					jointReal = "lae1";
				} else if (joint[x].equalsIgnoreCase("LShoulderRoll")) {
					jointReal = "lae2";
				} else if (joint[x].equalsIgnoreCase("LElbowYaw")) {
					jointReal = "lae3";
				} else if (joint[x].equalsIgnoreCase("LElbowRoll")) {
					jointReal = "lae4";
				} else if (joint[x].equalsIgnoreCase("RShoulderPitch")) {
					jointReal = "rae1";
				} else if (joint[x].equalsIgnoreCase("RShoulderRoll")) {
					jointReal = "rae2";
				} else if (joint[x].equalsIgnoreCase("RElbowYaw")) {
					jointReal = "rae3";
				} else if (joint[x].equalsIgnoreCase("RElbowRoll")) {
					jointReal = "rae4";
				}
			}

			if (MotionVector.elementAt(0).equalsIgnoreCase("XML_Motion")) {

				float a = (float) (Float.valueOf(value[x + motionOffsetValues]
						.trim()) * hardness);
				float a1 = gNjVd.Get(jointReal, a);

				float a2 = (a1 / SpeedControl)
						* (ServerCyrcles.ServerStep / 20);

				String str = Float.toString(a2);

				msg += "(" + jointReal + " " + str + ")";

			} else {

				float a = (float) (Float.valueOf(value[x + motionOffsetValues]
						.trim()) * hardness);
				float a1 = gNjV.Get(jointReal, a);

				float a2 = (a1 / SpeedControl)
						* (ServerCyrcles.ServerStep / 20);

				String str = Float.toString(a2);

				msg += "(" + jointReal + " " + str + ")";

			}

		}

		return msg;
	}

	public static Vector<String> readMotion(String motionName) {

		if (motionName.equalsIgnoreCase("Forwards50")) {

			return MotionStorage.getForwards50();

		} else if (motionName.equalsIgnoreCase("Forwards")) {

			return MotionStorage.getForwards();

		} else if (motionName.equalsIgnoreCase("Backwards")) {

			return MotionStorage.getBackwards();

		} else if (motionName.equalsIgnoreCase("SideStepLeft")) {

			return MotionStorage.getSideStepLeft();

		} else if (motionName.equalsIgnoreCase("SideStepRight")) {

			return MotionStorage.getSideStepRight();

		} else if (motionName.equalsIgnoreCase("StandUpFromFront")) {

			return MotionStorage.getStandUpFromFront();

		} else if (motionName.equalsIgnoreCase("TurnLeft40")) {

			return MotionStorage.getTurnLeft40();

		} else if (motionName.equalsIgnoreCase("TurnRight40")) {

			return MotionStorage.getTurnRight40();

		} else if (motionName.equalsIgnoreCase("Init")) {

			return MotionStorage.getInit();

		} else if (motionName.equalsIgnoreCase("KickForwardRight")) {

			return MotionStorage.getKickForwardRight();

		} else if (motionName.equalsIgnoreCase("TurnOver")) {

			return MotionStorage.getTurnOver();

		} else if (motionName.equalsIgnoreCase("KickForwardLeft")) {

			return MotionStorage.getKickForwardLeft();

		} else if (motionName.equalsIgnoreCase("newWalk")) {

			return MotionStorage.getNewWalk();

		} else {

			return null;
		}

	}

	public static String StopBehavior() {

		String str = "(lae4 0)(rae4 0)(lae3 0)(rae3 0)(lae2 0)(rae2 0)(lae1 0)(rae1 0)(rle1 0)(rle2 0)(rle3 0)(rle4 0)(rle5 0)(rle6 0)(lle1 0)(lle2 0)(lle3 0)(lle4 0)(lle5 0)(lle6 0)";
		return str;

	}

}
