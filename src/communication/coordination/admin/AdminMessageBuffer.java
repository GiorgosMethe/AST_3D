/**
 * 
 */
package communication.coordination.admin;

import java.util.Vector;

import agent.Constraints;
import coordination.CoordinationMessageUpdate;

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
public class AdminMessageBuffer {
	
	static Vector<Integer> InitBuffer = new Vector<Integer>();
	static Vector<Integer> StartBuffer = new Vector<Integer>();
	
	static Vector<Integer> c1Buffer = new Vector<Integer>();
	static Vector<String> CoordinationMessage1Buffer = new Vector<String>();
	
	static Vector<Integer> c2Buffer = new Vector<Integer>();
	static Vector<String> CoordinationMessage2Buffer = new Vector<String>();
	
	static Vector<String> CoordinationMessage = new Vector<String>();

	public static boolean addInit(int num){


		if(InitBuffer.size()==Constraints.numberPlayers-1){

			InitBuffer.removeAllElements();
			return true;

		}else{

			if(!InitBuffer.contains(num)){	

				InitBuffer.addElement(num);	

			}

		}

		return false;

	}
	
	public static boolean addC1(int num, String msg){


		if(c1Buffer.size()==Constraints.numberPlayers-1){

			//c1Buffer.removeAllElements();
			return true;

		}else{

			if(!c1Buffer.contains(num)){	

				c1Buffer.addElement(num);	
				CoordinationMessage1Buffer.addElement(msg);

			}

		}

		return false;

	}
	
	public static boolean addC2(int num, String msg){


		if(c2Buffer.size()==Constraints.numberPlayers-1){

			//c2Buffer.removeAllElements();
			addC1C2(CoordinationMessage1Buffer, CoordinationMessage2Buffer);
			return true;

		}else{

			if(!c2Buffer.contains(num)){	

				c2Buffer.addElement(num);
				CoordinationMessage2Buffer.addElement(msg);

			}

		}

		return false;

	}
	
	public static void addC1C2(Vector <String> c1 , Vector <String> c2){
		
		for(int i=0;i<c1.size();i++){
			
			for(int j=0;j<c2.size();j++){
				
				String[] c1num = c1.elementAt(i).split(",");
				String[] c2num = c2.elementAt(j).split(",");
				
				int c1numInt = Integer.parseInt(c1num[1]);
				int c2numInt = Integer.parseInt(c2num[1]);
				
				if(c1numInt == c2numInt){
					
					String CompleteCoordMessage = c1.elementAt(i)+","+c2.elementAt(j);
					CoordinationMessage.addElement(CompleteCoordMessage);
					
					
				}
	
			}
						
		}
		
		CoordinationMessageUpdate.update(CoordinationMessage);
		
		CoordinationMessage.removeAllElements();
		CoordinationMessage1Buffer.removeAllElements();
		CoordinationMessage2Buffer.removeAllElements();	
		c1Buffer.removeAllElements();
		c2Buffer.removeAllElements();
	}

}
