/**
 * 
 */
package coordination.communication;

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
public class CoordinationMessage {
	
	public int number;
	public int PlayerX,PlayerY;
	public int BallDistance,BallTheta;
	
	
	
	
	/**
	 * @param number
	 * @param playerX
	 * @param playerY
	 * @param ballDistance
	 * @param ballTheta
	 */
	public CoordinationMessage(int number, int playerX, int playerY,int ballDistance, int ballTheta) {
		
		this.number = number;
		PlayerX = playerX;
		PlayerY = playerY;
		BallDistance = ballDistance;
		BallTheta = ballTheta;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPlayerX() {
		return PlayerX;
	}
	public void setPlayerX(int playerX) {
		PlayerX = playerX;
	}
	public int getPlayerY() {
		return PlayerY;
	}
	public void setPlayerY(int playerY) {
		PlayerY = playerY;
	}
	public int getBallDistance() {
		return BallDistance;
	}
	public void setBallDistance(int ballDistance) {
		BallDistance = ballDistance;
	}
	public int getBallTheta() {
		return BallTheta;
	}
	public void setBallTheta(int ballTheta) {
		BallTheta = ballTheta;
	}

	
	
	


}
