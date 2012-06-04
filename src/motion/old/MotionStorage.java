/***********************************************************************************
 * Copyright 2012, Technical University of Crete
 * Academic Year 2011-2012
 *
 * Thesis Project
 *
 * @author Methenitis Georgios Student ID:2006030085	
 *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League
 * Start date: 25-04-2012											 
 * End date  : xx-xx-2012
 ***********************************************************************************/
package motion.old;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class MotionStorage {

	public static Vector<String> Forwards50;
	public static Vector<String> backwards;
	public static Vector<String> Forwards;
	public static Vector<String> TurnLeft40;
	public static Vector<String> TurnRight40;
	public static Vector<String> SideStepRight;
	public static Vector<String> SideStepLeft;
	public static Vector<String> TurnOver;
	public static Vector<String> StandUpFromFront;
	public static Vector<String> KickForwardRight;
	public static Vector<String> KickForwardLeft;
	public static Vector<String> Init;
	public static Vector<String> newWalk;

	public void StoreMotions() {

		setForwards50(ReadMotions("Forwards50"));
		System.out.print(".");
		setBackwards(ReadMotions("backwards"));
		System.out.print(".");
		setForwards(ReadMotions("Forwards"));
		System.out.print(".");
		setInit(ReadMotions("Init"));
		System.out.print(".");
		setKickForwardLeft(ReadMotions("KickForwardLeft"));
		System.out.print(".");
		setKickForwardRight(ReadMotions("KickForwardRight"));
		System.out.print(".");
		setSideStepLeft(ReadMotions("SideStepLeft"));
		System.out.print(".");
		setSideStepRight(ReadMotions("SideStepRight"));
		System.out.print(".");
		setStandUpFromFront(ReadMotions("StandUpFromFront"));
		System.out.print(".");
		setTurnLeft40(ReadMotions("TurnLeft40"));
		System.out.print(".");
		setTurnRight40(ReadMotions("TurnRight40"));
		System.out.print(".");
		setTurnOver(ReadMotions("TurnOver"));
		System.out.print(".");

	}

	public Vector<String> ReadMotions(String motionName) {

		String MotionFilepath;
		Vector<String> MotionVector = new Vector<String>();

		if (motionName.equalsIgnoreCase("Forwards50")) {

			MotionFilepath = "motions/OldMotions/Forwards50.motion";

		} else if (motionName.equalsIgnoreCase("Forwards")) {

			MotionFilepath = "motions/OldMotions/Forwards.motion";

		} else if (motionName.equalsIgnoreCase("Backwards")) {

			MotionFilepath = "motions/OldMotions/Backwards.motion";

		} else if (motionName.equalsIgnoreCase("SideStepLeft")) {

			MotionFilepath = "motions/OldMotions/SideStepLeft.motion";

		} else if (motionName.equalsIgnoreCase("SideStepRight")) {

			MotionFilepath = "motions/OldMotions/SideStepRight.motion";

		} else if (motionName.equalsIgnoreCase("StandUpFromFront")) {

			MotionFilepath = "motions/OldMotions/StandUpFromFront.motion";

		} else if (motionName.equalsIgnoreCase("TurnLeft40")) {

			MotionFilepath = "motions/OldMotions/TurnLeft40.motion";

		} else if (motionName.equalsIgnoreCase("TurnLeft60")) {

			MotionFilepath = "motions/OldMotions/TurnLeft60.motion";

		} else if (motionName.equalsIgnoreCase("TurnLeft180")) {

			MotionFilepath = "motions/OldMotions/TurnLeft180.motion";

		} else if (motionName.equalsIgnoreCase("TurnRight40")) {

			MotionFilepath = "motions/OldMotions/TurnRight40.motion";

		} else if (motionName.equalsIgnoreCase("TurnRight60")) {

			MotionFilepath = "motions/OldMotions/TurnRight60.motion";

		} else if (motionName.equalsIgnoreCase("Init")) {

			MotionFilepath = "motions/OldMotions/KickForwardRight.motion";

		} else if (motionName.equalsIgnoreCase("KickForwardRight")) {

			MotionFilepath = "motions/OldMotions/KickForwardRight.motion";

		} else if (motionName.equalsIgnoreCase("leftFall")) {

			MotionFilepath = "motions/OldMotions/leftFall.motion";

		} else if (motionName.equalsIgnoreCase("KickSideRight")) {

			MotionFilepath = "motions/OldMotions/KickSideRight.motion";

		} else if (motionName.equalsIgnoreCase("TurnOver")) {

			MotionFilepath = "motions/OldMotions/TurnOver.motion";

		} else if (motionName.equalsIgnoreCase("KickForwardLeft")) {

			MotionFilepath = "motions/OldMotions/KickForwardLeft.motion";

		} else {

			MotionFilepath = "";
		}

		try {

			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(MotionFilepath);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				// System.out.println (strLine);
				MotionVector.add(strLine);
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

		return MotionVector;

	}

	public static Vector<String> getForwards50() {
		return Forwards50;
	}

	public static void setForwards50(Vector<String> forwards50) {
		Forwards50 = forwards50;
	}

	public static Vector<String> getBackwards() {
		return backwards;
	}

	public static void setBackwards(Vector<String> backwards) {
		MotionStorage.backwards = backwards;
	}

	public static Vector<String> getForwards() {
		return Forwards;
	}

	public static void setForwards(Vector<String> forwards) {
		Forwards = forwards;
	}

	public static Vector<String> getTurnLeft40() {
		return TurnLeft40;
	}

	public static void setTurnLeft40(Vector<String> turnLeft40) {
		TurnLeft40 = turnLeft40;
	}

	public static Vector<String> getTurnRight40() {
		return TurnRight40;
	}

	public static void setTurnRight40(Vector<String> turnRight40) {
		TurnRight40 = turnRight40;
	}

	public static Vector<String> getSideStepRight() {
		return SideStepRight;
	}

	public static void setSideStepRight(Vector<String> sideStepRight) {
		SideStepRight = sideStepRight;
	}

	public static Vector<String> getSideStepLeft() {
		return SideStepLeft;
	}

	public static void setSideStepLeft(Vector<String> sideStepLeft) {
		SideStepLeft = sideStepLeft;
	}

	public static Vector<String> getTurnOver() {
		return TurnOver;
	}

	public static void setTurnOver(Vector<String> turnOver) {
		TurnOver = turnOver;
	}

	public static Vector<String> getStandUpFromFront() {
		return StandUpFromFront;
	}

	public static void setStandUpFromFront(Vector<String> standUpFromFront) {
		StandUpFromFront = standUpFromFront;
	}

	public static Vector<String> getKickForwardRight() {
		return KickForwardRight;
	}

	public static void setKickForwardRight(Vector<String> kickForwardRight) {
		KickForwardRight = kickForwardRight;
	}

	public static Vector<String> getKickForwardLeft() {
		return KickForwardLeft;
	}

	public static void setKickForwardLeft(Vector<String> kickForwardLeft) {
		KickForwardLeft = kickForwardLeft;
	}

	public static Vector<String> getInit() {
		return Init;
	}

	public static void setInit(Vector<String> init) {
		Init = init;
	}

	public static Vector<String> getNewWalk() {
		return newWalk;
	}

	public static void setNewWalk(Vector<String> newWalk) {
		MotionStorage.newWalk = newWalk;
	}

}
