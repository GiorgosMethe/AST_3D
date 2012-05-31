/**
 * 
 */
package coordination;

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
	public int PlayerX,playerY,playerTheta;
	public int ballX,ballY,BallTheta;
	/**
	 * @param number
	 * @param playerX
	 * @param playerY
	 * @param playerTheta
	 * @param ballX
	 * @param ballY
	 * @param ballTheta
	 */
	public CoordinationMessage(int number, int playerX, int playerY,int playerTheta, int ballX, int ballY, int ballTheta) {
	
		this.number = number;
		PlayerX = playerX;
		this.playerY = playerY;
		this.playerTheta = playerTheta;
		this.ballX = ballX;
		this.ballY = ballY;
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
		return playerY;
	}
	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}
	public int getPlayerTheta() {
		return playerTheta;
	}
	public void setPlayerTheta(int playerTheta) {
		this.playerTheta = playerTheta;
	}
	public int getBallX() {
		return ballX;
	}
	public void setBallX(int ballX) {
		this.ballX = ballX;
	}
	public int getBallY() {
		return ballY;
	}
	public void setBallY(int ballY) {
		this.ballY = ballY;
	}
	public int getBallTheta() {
		return BallTheta;
	}
	public void setBallTheta(int ballTheta) {
		BallTheta = ballTheta;
	}
	


}
