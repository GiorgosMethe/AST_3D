package motion.old;

import motion.utils.MotionTrigger;
import behavior.old.BehaviorDone;
import connection.utils.ServerCyrcles;

public class MotionController {

	private static String Str;

	private static int endMotionPose;
	private static int speedControl;
	private static int speed;
	private static int poseOffset;

	public static String MotionFactory(String Motion) {

		int Current = ServerCyrcles.getCyrclesNow();
		int pose = 0;
		Str = "";
		double hardness = 1;

		if (Motion.equalsIgnoreCase("TurnRight40")) {

			endMotionPose = 72;
			speed = 1;
			speedControl = 11;
			poseOffset = 1;
			hardness = 0.4 + (0.6 * ((Math.min(40,
			Math.abs(motion.utils.MotionTrigger.getTurn()))) / 40));

		} else if (Motion.equalsIgnoreCase("TurnLeft40")) {

			endMotionPose = 72;
			speed = 1;
			speedControl = 11;
			poseOffset = 1;
			hardness = 0.4 + (0.6 * ((Math.min(40,
			Math.abs(motion.utils.MotionTrigger.getTurn()))) / 40));

		} else if (Motion.equalsIgnoreCase("KickForwardRight")) {

			endMotionPose = 61;
			speed = 3;
			speedControl = 9;
			poseOffset = 1;

		} else if (Motion.equalsIgnoreCase("KickForwardLeft")) {

			endMotionPose = 61;
			speed = 3;
			speedControl = 9;
			poseOffset = 1;

		} else {

		}

		// there is no any motion in progress
		if (CurrentMotion.getCurrentMotionPlaying().equalsIgnoreCase("")) {
			System.out.println("there is no any motion in progress");
			CurrentMotion.setCurrentMotionPlaying(Motion);
			CurrentMotion.setInitCyrcles(0);
			CurrentMotion.setCurrentMotionPlaying(Motion);
			CurrentMotion.setStartMotionCyrcles(Current);
			CurrentMotion.setMotionPose(0);
			CurrentMotion.setPoseEnding(false);
			return "";

		} else {
			
			System.out.println("play");

			if ((Current - CurrentMotion.getStartMotionCyrcles()) % speed == 0) {
				
				int previousPose = CurrentMotion.getMotionPose();
				pose = previousPose + poseOffset;
				CurrentMotion.setMotionPose(pose);

				if (pose >= endMotionPose) {
					
					CurrentMotion.setPoseEnding(true);
					BehaviorDone.setBehaviorDone(true);
					CurrentMotion.setStartMotionCyrcles(0);
					CurrentMotion.setEndMotionCyrcles(0);
					CurrentMotion.setCurrentMotionCyrcles(0);
					CurrentMotion.setCurrentMotionPlaying("");
					CurrentMotion.setMotionPose(0);
					return Motions.StopBehavior();

				} else {
					
					CurrentMotion.setMotionPose(pose);
					return Motions.Motion(Motion, pose, speedControl, hardness);
					
				}

			}

		}
		return Str;

	}
}
