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
package connection;
import connection.Connection;
public class ServerCyrcles {
	
	
	static int Cyrcles=0;;
	Connection con;
	
	public static int getCyrclesNow() {
		return Cyrcles;
	}


	public static void setCyrclesNow(int cyrcles) {
		Cyrcles = cyrcles;
	}
	
	
	
	

}
