package newMotions;

public class GetPhase {
	
	public static Phase get(Motion motion, String PhaseName){
		
		if(motion!=null){
			
			for(int i=0;i<motion.getPhases().size();i++){
			
				if(motion.getPhases().elementAt(i).getName().equalsIgnoreCase(PhaseName)){
					
					return motion.getPhases().elementAt(i);
					
				}
								
			}
			
			
			return null;
						
			
			
		}else{
			
			return null;

		}

		
	}
	
	public static String getNext(Motion motion, String PhaseName){
	
		if(motion!=null){
			
			Phase phase = GetPhase.get(motion, PhaseName);	
			
			for(int i=0;i<motion.getPhases().size();i++){
				
				if(motion.getPhases().elementAt(i).getName().equalsIgnoreCase(phase.getNextPhase())){
					
					return motion.getPhases().elementAt(i).getName();
					
				}
								
			}
			
			
			return null;
			
			
			
		}else{
			
			return null;

		}

		
	}
	

}
