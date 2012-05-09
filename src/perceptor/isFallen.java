/***********************************************************************************
 * 				  Copyright 2012, Technical University of Crete				       *
 * 							 Academic Year 2011-2012					           *
 ***********************************************************************************
 * 								Thesis Project								       *
 ***********************************************************************************
 * @author Methenitis Georgios													   *
 * Abstract: Player Behavior and Team Strategy for the RoboCup 3D Simulation League*
 * Start date: 25-04-2012														   *																	 
 * End date  : xx-xx-2012														   *																			   *
 ***********************************************************************************/
package perceptor;

import behavior.BehaviorStateMachine;

public class isFallen {
	
	public void Check(){
		
		if((Math.abs(GyroScope.getAngleZ())+Math.abs(GyroScope.getAngleZ()+Math.abs(GyroScope.getAngleZ())))>500){
			BehaviorStateMachine.setName("Fallen");
			BehaviorStateMachine.setState("start");
		}
	}

}
