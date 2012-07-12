/**
 * 
 */
package coordination.communication.message;

import perceptor.localization.Coordinate;

/***********************************************************************************
 * Copyright 2012, Technical University of Crete Academic Year 2011-2012
 * 
 * Thesis Project
 * 
 * @author Methenitis Georgios Student ID:2006030085
 * 
 *         Abstract: Player Behavior and Team Strategy for the RoboCup 3D
 *         Simulation League Start date: 25-04-2012 End date : xx-xx-2012
 ***********************************************************************************/
public class CoordinationMessage {

	public int type;
	public int number;
	public Coordinate Player;
	public Coordinate Ball;
	public int BallDistance, BallTheta;
	public double RealDistance;

	public CoordinationMessage(int type, int number, Coordinate player,
			Coordinate ball, int ballDistance, int ballTheta,
			double realDistance) {
		super();
		this.type = type;
		this.number = number;
		Player = player;
		Ball = ball;
		BallDistance = ballDistance;
		BallTheta = ballTheta;
		RealDistance = realDistance;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Coordinate getPlayer() {
		return Player;
	}

	public void setPlayer(Coordinate player) {
		Player = player;
	}

	public Coordinate getBall() {
		return Ball;
	}

	public void setBall(Coordinate ball) {
		Ball = ball;
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

	public double getRealDistance() {
		return RealDistance;
	}

	public void setRealDistance(double realDistance) {
		RealDistance = realDistance;
	}

}
