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
