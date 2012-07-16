/*******************************************************************************
 * Technical University of Crete
 * 
 * Thesis Project
 * 
 * Author:	Methenitis K. Georgios
 * 
 * Abstract  : Player Behavior and Team Strategy 
 * 			for the RoboCup 3D Simulation League
 * 
 * Date:  		July 2012
 ******************************************************************************/
package motion.utils;

import motion.old.MotionStorage;
import motion.xml.XMLMotionStorage;

public class ReadMotionFiles {

	public static void Read() {

		MotionStorage Ms = new MotionStorage();
		XMLMotionStorage nMs = new XMLMotionStorage();

		// read old .motion files
		System.out.print("loading old .motion files");
		Ms.StoreMotions();
		System.out.println("OK");

		// read new XML motion files
		System.out.print("loading new .XML files");
		nMs.StoreMotions();
		System.out.println("OK");

	}

}
