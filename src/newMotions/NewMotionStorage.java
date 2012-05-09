package newMotions;


public class NewMotionStorage {
	
	public static Motion walk_fine;
	public static Motion strafe_left;
	public static Motion strafe_right;
	public static Motion turn_left;
	public static Motion turn_right;
	public static Motion rigth_front_front_kick;
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
		
		
	}

	public static Motion getWalk_fine() {
		return walk_fine;
	}

	public static void setWalk_fine(Motion walk_fine) {
		NewMotionStorage.walk_fine = walk_fine;
	}

	public static Motion getStrafe_left() {
		return strafe_left;
	}

	public static void setStrafe_left(Motion strafe_left) {
		NewMotionStorage.strafe_left = strafe_left;
	}

	public static Motion getStrafe_right() {
		return strafe_right;
	}

	public static void setStrafe_right(Motion strafe_right) {
		NewMotionStorage.strafe_right = strafe_right;
	}

	public static Motion getTurn_left() {
		return turn_left;
	}

	public static void setTurn_left(Motion turn_left) {
		NewMotionStorage.turn_left = turn_left;
	}

	public static Motion getTurn_right() {
		return turn_right;
	}

	public static void setTurn_right(Motion turn_right) {
		NewMotionStorage.turn_right = turn_right;
	}

	public static Motion getRigth_front_front_kick() {
		return rigth_front_front_kick;
	}

	public static void setRigth_front_front_kick(Motion rigth_front_front_kick) {
		NewMotionStorage.rigth_front_front_kick = rigth_front_front_kick;
	}
	
	

}
