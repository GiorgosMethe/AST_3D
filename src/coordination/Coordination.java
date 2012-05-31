/**
 * 
 */
package coordination;

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
public class Coordination {
	
	public static void MakeCoordination(CoordinationMessage message){
		
		
		
		System.out.println("message");
		System.out.println(message.getNumber());
		System.out.println(message.getBallDistance());
		System.out.println(message.getBallX());
		System.out.println(message.getBallY());
		System.out.println(message.getPlayerTheta());

		
	}

}
