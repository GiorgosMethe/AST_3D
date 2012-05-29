/**
 * 
 */
package communication.oFunctions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class MessageDecoder {
	
	
	public static void MessageHandlerAdmin(String msg){
		
		
		if(msg.startsWith("i,")){
			
			String[] splittedMsg = msg.split(",");

			
			
			System.out.println(MessageBuffer.addInit(Integer.parseInt(splittedMsg[1])));
			
		}
		
	}
	
	
	
	public static void MessageHandlerPlayer(String msg){
		
		
		
	}
	
	
	

}
