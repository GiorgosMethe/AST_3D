/**
 * 
 */
package communication.oFunctions;

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
public class MessageBuffer {

	static Vector<Integer> InitBuffer = new Vector<Integer>();

	public static boolean addInit(int num){


		if(InitBuffer.size()==Constraints.numberPlayers){
			
			return true;
		
		}else{

			if(!InitBuffer.contains(num)){	

				InitBuffer.addElement(num);	
				
			}
				
		}
		
		return false;

	}




}
