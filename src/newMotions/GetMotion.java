package newMotions;

public class GetMotion {
	
	public static Motion Get(String name){
		
		if(name.equalsIgnoreCase("walk_fine")){
			Motion mot=NewMotionStorage.getWalk_fine();
			return mot;
		}else if(name.equalsIgnoreCase("strafe_left")){
			Motion mot=NewMotionStorage.getStrafe_left();
			return mot;
		}else if(name.equalsIgnoreCase("strafe_right")){
			Motion mot=NewMotionStorage.getStrafe_right();
			return mot;
		}
		
		
		
		return null;		
	}

}
