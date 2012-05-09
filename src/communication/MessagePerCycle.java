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
package communication;

import agent.AgentType;
import connection.ServerCyrcles;

public class MessagePerCycle {

	public static boolean PerNumCircles(int number){

		int MaxNum=7;

		if (ServerCyrcles.getCyrclesNow()%4==0){

			if(WhoSent.getCounter()==MaxNum){
				WhoSent.setCounter(1);
			}else{
				WhoSent.setCounter(WhoSent.getCounter()+1);
			}
			
			if(AgentType.getPlayerNum()==WhoSent.getCounter()){
				return true;
			}else{
				return false;
			}
		}else{

			return false;
		}
		
	}
}