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
package motion.kinematics;

public class DirectKinematics {

	public static JointPosition2D CalculatePosition(JointPosition2D position,
			float length, float theta) {

		float dx = (float) (position.PositionX + (length * Math.sin(Math
				.toRadians(theta))));

		float dy = (float) (position.PositionY + (length * Math.cos(Math
				.toRadians(theta))));

		JointPosition2D Result = new JointPosition2D(dx, dy);
		return Result;
	}

}
