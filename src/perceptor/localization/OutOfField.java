package perceptor.localization;

import agent.Constraints;

public class OutOfField {

	public static boolean Check(Coordinate agent){
		
		if((Math.abs(agent.getX())>(Constraints.FieldLength/2)) ||
				((Math.abs(agent.getY())>(Constraints.FieldWidth/2)))){
			
			return true;
			
		}else{
			
			return false;
			
		}

	}
	
	
}
