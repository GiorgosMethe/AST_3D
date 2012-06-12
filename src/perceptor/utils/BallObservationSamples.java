/**
 * 
 */
package perceptor.utils;

import localization.Coordinate;

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
public class BallObservationSamples {

	public Coordinate BallPosition;
	public Coordinate SumOfObservations;
	public float weight;
	public int samplesNum;

	/**
	 * @param ballPosition
	 * @param sumOfObservations
	 * @param weight
	 * @param samplesNum
	 */
	public BallObservationSamples(Coordinate ballPosition,
			Coordinate sumOfObservations, float weight, int samplesNum) {

		BallPosition = ballPosition;
		SumOfObservations = sumOfObservations;
		this.weight = weight;
		this.samplesNum = samplesNum;
	}

	public Coordinate getBallPosition() {
		return BallPosition;
	}

	public void setBallPosition(Coordinate ballPosition) {
		BallPosition = ballPosition;
	}

	public Coordinate getSumOfObservations() {
		return SumOfObservations;
	}

	public void setSumOfObservations(Coordinate sumOfObservations) {
		SumOfObservations = sumOfObservations;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getSamplesNum() {
		return samplesNum;
	}

	public void setSamplesNum(int samplesNum) {
		this.samplesNum = samplesNum;
	}

}
