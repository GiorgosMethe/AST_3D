package action.simple;

import motion.utils.MotionTrigger;
import motion.xml.WalkLeaning;
import perceptor.joints.HingeJointPerceptor;
import perceptor.vision.Ball;
import perceptor.vision.Vision;
import action.vision.VisionType;

public class WalkToBall {

	public static int TrueCounter = 0;

	public static boolean Act() {

		VisionType.setType(1);


		if (Vision.isiSee()) {

			if (Ball.isSeeTheBall()) {

				if ((Ball.RealDistance() < 0.805) && (Ball.getDistance() < 0.8)) {

					MotionTrigger.setMotion("");
					return true;


				} else {

					float AngleThresholdBigTurn;
					float AngleThresholdWalkLeaningTurn;
					if (Ball.getDistance() < 1) {

						AngleThresholdBigTurn = 8;
						AngleThresholdWalkLeaningTurn = 2;

					} else {

						AngleThresholdBigTurn = 20;
						AngleThresholdWalkLeaningTurn = 5;
					}

					if ((Math.abs(HingeJointPerceptor.getHj1()
							+ Math.abs(Ball.getAngleX()))) > AngleThresholdBigTurn) {

						if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > 0) {

							MotionTrigger.setMotion("TurnLeft40");
							return false;

						} else {

							MotionTrigger.setMotion("TurnRight40");
							return false;

						}

					} else if ((Math.abs(HingeJointPerceptor.getHj1()
							+ Math.abs(Ball.getAngleX()))) > AngleThresholdWalkLeaningTurn) {

						if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > 0) {

							WalkLeaning.setLean("left");
							return false;

						} else {

							WalkLeaning.setLean("right");
							return false;
						}

					} else {

						if (Ball.getDistance() < 2) {
							MotionTrigger.setMotion("Forwards50");
							WalkLeaning.setLean("slow");
						} else {
							MotionTrigger.setMotion("Forwards50");
							WalkLeaning.setLean("");
						}
						return false;
					}

				}

			}
		}
		return false;



	}
}