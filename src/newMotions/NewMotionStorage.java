package newMotions;


public class NewMotionStorage {
	
	public static Motion walk_fine;
	public static Motion strafe_left;
	public static Motion strafe_right;
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
	
	
	

}
