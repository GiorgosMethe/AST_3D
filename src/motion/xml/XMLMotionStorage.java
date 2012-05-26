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
package motion.xml;


public class XMLMotionStorage {
	
	public static Motion walk_fine;
	public static Motion strafe_left;
	public static Motion strafe_right;
	public static Motion turn_left;
	public static Motion turn_right;
	public static Motion rigth_front_front_kick;
	public static Motion right_strong_kick;
	ReadXMLFile rXMLf=new ReadXMLFile();
	
	public void StoreMotions(){
		
		walk_fine=rXMLf.readMotion("walk_fine");
		setWalk_fine(walk_fine);
		System.out.print(".");
		
		strafe_left=rXMLf.readMotion("strafe_left");
		setStrafe_left(strafe_left);
		System.out.print(".");
		
		strafe_right=rXMLf.readMotion("strafe_right");
		setStrafe_right(strafe_right);
		System.out.print(".");
		
		turn_left=rXMLf.readMotion("turn_left");
		setTurn_left(turn_left);
		System.out.print(".");
		
		turn_right=rXMLf.readMotion("turn_right");
		setTurn_right(turn_right);
		System.out.print(".");
		
		rigth_front_front_kick=rXMLf.readMotion("rigth_front_front_kick");
		setRigth_front_front_kick(rigth_front_front_kick);
		System.out.print(".");
		
		right_strong_kick=rXMLf.readMotion("strong_right_kick");
		setRight_strong_kick(right_strong_kick);
		System.out.print(".");
		
		
	}

	public static Motion getWalk_fine() {
		return walk_fine;
	}

	public static void setWalk_fine(Motion walk_fine) {
		XMLMotionStorage.walk_fine = walk_fine;
	}

	public static Motion getStrafe_left() {
		return strafe_left;
	}

	public static void setStrafe_left(Motion strafe_left) {
		XMLMotionStorage.strafe_left = strafe_left;
	}

	public static Motion getStrafe_right() {
		return strafe_right;
	}

	public static void setStrafe_right(Motion strafe_right) {
		XMLMotionStorage.strafe_right = strafe_right;
	}

	public static Motion getTurn_left() {
		return turn_left;
	}

	public static void setTurn_left(Motion turn_left) {
		XMLMotionStorage.turn_left = turn_left;
	}

	public static Motion getTurn_right() {
		return turn_right;
	}

	public static void setTurn_right(Motion turn_right) {
		XMLMotionStorage.turn_right = turn_right;
	}

	public static Motion getRigth_front_front_kick() {
		return rigth_front_front_kick;
	}

	public static void setRigth_front_front_kick(Motion rigth_front_front_kick) {
		XMLMotionStorage.rigth_front_front_kick = rigth_front_front_kick;
	}

	public static Motion getRight_strong_kick() {
		return right_strong_kick;
	}

	public static void setRight_strong_kick(Motion right_strong_kick) {
		XMLMotionStorage.right_strong_kick = right_strong_kick;
	}


	
	
	
	

}
