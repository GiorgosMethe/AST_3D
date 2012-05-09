package newMotions;

public class Check4Change {

	public static boolean check(String name){
		
		if(MotionPlaying.getMotionName()==null||MotionPlaying.getMotionName().equalsIgnoreCase("")){
			
			return true;	
			
		}else{
			
			if(!MotionPlaying.getMotionName().equalsIgnoreCase(name)){
				
				return false;
				
			}
			
		}
		
		return true;	
		
	}
	
}
