/**
 * 
 */
package communication.coordination;

import java.util.Vector;

import agent.Constraints;

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
public class CoordinationMessageBuffer {
	static Vector<Integer> Coordination1numBuffer = new Vector<Integer>();
	static Vector<String> Coordination1msgBuffer = new Vector<String>();
	
	static Vector<Integer> Coordination2numBuffer = new Vector<Integer>();
	static Vector<String> Coordination2msgBuffer = new Vector<String>();
	
	public static boolean CoordinationReceiver1(int num,String msg){
		
		if(Coordination1numBuffer.size()==Constraints.numberPlayers-1){
			
			Coordination1numBuffer.removeAllElements();
			return true;
		
		}else{

			if(!Coordination1numBuffer.contains(num)){	

				Coordination1numBuffer.addElement(num);	
				
			}
				
		}
		
		return false;
		
	}
	
	public static boolean CoordinationReceiver2(int num,String msg){
		
		if(Coordination2numBuffer.size()==Constraints.numberPlayers-1){
			
			Coordination2numBuffer.removeAllElements();
			return true;
		
		}else{

			if(!Coordination2numBuffer.contains(num)){	

				Coordination2numBuffer.addElement(num);	
				
			}
				
		}
		
		
		return false;
		
	}

}
