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

				if ((Ball.RealDistance() < 0.79)) {

					if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) < -5) {

						MotionTrigger.setMotion("SideStepRight");
						return false;

					} else if ((HingeJointPerceptor.getHj1() + Ball.getAngleX()) > 5) {

						MotionTrigger.setMotion("SideStepLeft");
						return false;

					} else {

						WalkToBall.TrueCounter++;
						if (WalkToBall.TrueCounter == 10) {
							WalkToBall.TrueCounter = 0;
							return true;
						}
						MotionTrigger.setMotion("");
					}

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
			return false;

		}
		return false;

	}
}