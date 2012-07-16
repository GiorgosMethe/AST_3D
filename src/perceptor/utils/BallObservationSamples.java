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
package perceptor.utils;

import perceptor.localization.Coordinate;

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
