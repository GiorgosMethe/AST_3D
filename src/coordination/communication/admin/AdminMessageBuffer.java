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
package coordination.communication.admin;

import java.util.Vector;

import connection.utils.ServerCyrcles;

import agent.constraints.Constraints;
import coordination.communication.message.CoordinationVectorUpdate;
import coordination.main.CoordinationRun;

public class AdminMessageBuffer {

	static Vector<Integer> InitBuffer = new Vector<Integer>();
	static Vector<Integer> StartBuffer = new Vector<Integer>();

	static Vector<Integer> cBuffer = new Vector<Integer>();
	static Vector<String> CoordinationMessageBuffer = new Vector<String>();

	public static boolean addInit(int num) {

		if (InitBuffer.size() == Constraints.numberPlayers - 1) {

			InitBuffer.removeAllElements();
			return true;

		} else {

			if (!InitBuffer.contains(num)) {

				System.out.println("init message "+ServerCyrcles.getCyrclesNow());

				InitBuffer.addElement(num);

			}

		}

		return false;

	}

	public static boolean addC(int num, String msg) {

		if(CoordinationRun.getStep() == 0){

			if (cBuffer.size() == Constraints.numberPlayers - 1) {

				CoordinationVectorUpdate.update(CoordinationMessageBuffer);
				CoordinationMessageBuffer.removeAllElements();
				cBuffer.removeAllElements();

				return true;

			} else {

				boolean flag = false;

				for (int i = 0; i < cBuffer.size(); i++) {
					if (cBuffer.elementAt(i) == num) {
						flag = true;
						break;
					}
				}

				if (flag) {

				} else {
					System.out.println("cBuffer message "+ServerCyrcles.getCyrclesNow());
					cBuffer.addElement(num);
					CoordinationMessageBuffer.addElement(msg);
				}

			}

			

		}
		
		return false;

	}

}
