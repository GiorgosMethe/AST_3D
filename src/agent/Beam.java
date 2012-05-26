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

package agent;

public class Beam {

	public String Init(int number){

		String beam;
		String beamX = null;
		String beamY = null;
		String beamTheta = null;
		if(number==1){
			beamX="-14.5"; beamY="0.0"; beamTheta="0.0";
		}else if(number==2){
			beamX="-12.5"; beamY="-5.0"; beamTheta="0.0";
		}else if(number==3){
			beamX="-12.5"; beamY="5.0"; beamTheta="0.0";
		}else if(number==4){
			beamX="-12.5"; beamY="0.0"; beamTheta="0.0";
		}else if(number==5){
			beamX="-8.0"; beamY="-3.0"; beamTheta="0.0";
		}else if(number==6){
			beamX="-10.0"; beamY="0.0"; beamTheta="0.0";
		}else if(number==7){
			beamX="-5.0"; beamY="3.0"; beamTheta="0.0";
		}else if(number==8){
			beamX="-8.0"; beamY="3.0"; beamTheta="0.0";
		}else if(number==9){
			beamX="-4.0"; beamY="2.0"; beamTheta="0.0";
		}else if(number==10){
			beamX="-4.0"; beamY="-2.0"; beamTheta="0.0";
		}else if(number==11){
			beamX="-5.0"; beamY="0.0"; beamTheta="0.0";
		}else{
			
		}
		
		beam=beamX+" "+beamY+" "+beamTheta;

		return beam;
	}

}
