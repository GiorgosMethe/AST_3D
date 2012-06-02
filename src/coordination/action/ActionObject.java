/**
 * 
 */
package coordination.action;

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
public class ActionObject {
	
	public String action;
	public double parametres1;
	public double parametres2;
	public double parametres3;
	
	
	/**
	 * @param action
	 * @param parametres1
	 * @param parametres2
	 * @param parametres3
	 */
	public ActionObject(String action, double parametres1, double parametres2,double parametres3) {
		
		this.action = action;
		this.parametres1 = parametres1;
		this.parametres2 = parametres2;
		this.parametres3 = parametres3;
		
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public double getParametres1() {
		return parametres1;
	}


	public void setParametres1(double parametres1) {
		this.parametres1 = parametres1;
	}


	public double getParametres2() {
		return parametres2;
	}


	public void setParametres2(double parametres2) {
		this.parametres2 = parametres2;
	}


	public double getParametres3() {
		return parametres3;
	}


	public void setParametres3(double parametres3) {
		this.parametres3 = parametres3;
	}
	
	

}
