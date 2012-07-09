package motion.utils;

import motion.xml.XMLMotionStorage;

public class ReadMotionFiles {

	public static void Read() {

		XMLMotionStorage nMs = new XMLMotionStorage();

		// read new XML motion files
		System.out.print("loading new .XML files");
		nMs.StoreMotions();
		System.out.println("OK");

	}

}
