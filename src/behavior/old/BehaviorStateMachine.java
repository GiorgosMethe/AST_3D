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
package behavior.old;

public class BehaviorStateMachine {
	
	
	public static String Name;
	public static String State;
	
	
	public BehaviorStateMachine(String Name,String State){
		BehaviorStateMachine.setName(Name);
		BehaviorStateMachine.setState(State);
	}
	
	
	
	public static String getName() {
		return Name;
	}
	public static void setName(String name) {
		Name = name;
	}
	public static String getState() {
		return State;
	}
	public static void setState(String state) {
		State = state;
	}
	

}
