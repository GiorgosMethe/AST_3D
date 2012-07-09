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

package action.vision;

import motion.utils.GetNormalJointValue;
import perceptor.joints.HingeJointPerceptor;
import perceptor.localization.LocalizationResults;
import perceptor.vision.Ball;
import perceptor.vision.Vision;
import connection.utils.ServerCyrcles;

public class HeadMovement {

	public static boolean HeadAtBall;
	static GetNormalJointValue gNjV = new GetNormalJointValue();

	public static String MoveHead(int type) {

		String Action = "";

		if (type == 1) {
			HeadAtBall = false;
			Action = MoveHeadToBall();
		} else if (type == 2) {
			Action = MoveHeadToLocalize();
		} else if (type == 3) {
			Action = MoveHeadToLocalizeBall();
		} else if (type == 4) {
			Action = MoveHeadStraight();
		} else if (type == 5) {
			Action = MoveHeadToLocalizeAgent();
		} else if (type == 6) {
			Action = Observe();
		}

		return Action;

	}

	public static String Observe() {

		int cycles = ServerCyrcles.getCyrclesNow();
		float moveX = (float) (2.09 * Math.sin(cycles / 15));
		float moveY = (float) (0.59 * Math.sin(cycles / 8) - 0.078);
		String str = "";

		float realMoveX = gNjV.Get("he1", moveX) / 5;
		float realMoveY = gNjV.Get("he2", moveY) / 5;
		str = "(" + "he1" + " " + realMoveX + ")" + "(" + "he2" + " "
				+ realMoveY + ")";

		return str;
	}

	public static String MoveHeadToLocalize() {

		int cycles = ServerCyrcles.getCyrclesNow();
		float moveX = (float) (2.09 * Math.sin(cycles / 15));
		float moveY = (float) (0.59 * Math.sin(cycles / 8) - 0.078);
		String str = "";

		if (Vision.isiSee() == true) {
			if (LocalizationResults.getLandmarks().size() <= 3) {

				float realMoveX = gNjV.Get("he1", moveX) / 5;
				float realMoveY = gNjV.Get("he2", moveY) / 5;
				str = "(" + "he1" + " " + realMoveX + ")" + "(" + "he2" + " "
						+ realMoveY + ")";

			} else {

				double AngleX = 0;
				double AngleY = 0;
				for (int i = 0; i < LocalizationResults.getLandmarks().size(); i++) {

					AngleX = AngleX
							+ LocalizationResults.getLandmarks().elementAt(i).Horizontal_Angle;

				}

				AngleX = AngleX / LocalizationResults.getLandmarks().size();
				AngleY = gNjV.Get("he2", 10) / 5;
				str = "(" + "he1" + " " + centerToLocateX(AngleX) + ")" + "("
						+ "he2" + " " + centerToLocateY(AngleY) + ")";

			}
		}
		return str;
	}

	public static String MoveHeadToLocalizeBall() {

		int cycles = ServerCyrcles.getCyrclesNow();
		float moveX = (float) (2.09 * Math.sin(cycles / 15));
		float moveY = (float) (0.59 * Math.sin(cycles / 8) - 0.078);
		String str = "";

		if (Vision.isiSee() == true) {
			if (LocalizationResults.getLandmarks().size() <= 1
					&& Ball.isSeeTheBall() == false) {

				float realMoveX = gNjV.Get("he1", moveX) / 8;
				float realMoveY = gNjV.Get("he2", moveY) / 8;
				str = "(" + "he1" + " " + realMoveX + ")" + "(" + "he2" + " "
						+ realMoveY + ")";

			} else {

				double AngleX = 0;
				double AngleY = 0;
				for (int i = 0; i < LocalizationResults.getLandmarks().size(); i++) {

					AngleX = AngleX
							+ LocalizationResults.getLandmarks().elementAt(i).Horizontal_Angle;
					AngleY = AngleY
							+ LocalizationResults.getLandmarks().elementAt(i).Vertical_Angle;

				}
				AngleX = AngleX + Ball.getAngleX();
				AngleY = AngleY + Ball.getAngleY();

				str = "(" + "he1" + " " + centerToLocateX(AngleX) + ")" + "("
						+ "he2" + " " + centerToLocateY(AngleY) + ")";

			}
		}
		return str;
	}

	public static String MoveHeadToLocalizeAgent() {

		int cycles = ServerCyrcles.getCyrclesNow();
		float moveX = (float) (2.09 * Math.sin(cycles / 15));
		float moveY = (float) (0.59 * Math.sin(cycles / 8) - 0.078);
		String str = "";

		float realMoveX = gNjV.Get("he1", moveX) / 8;
		float realMoveY = gNjV.Get("he2", moveY) / 8;

		if (Vision.isiSee()) {
			if (LocalizationResults.getLandmarks().size() >= 2) {
				str = "(" + "he1" + " " + "0.0f" + ")" + "(" + "he2" + " "
						+ "0.0f" + ")";
			} else {

				str = "(" + "he1" + " " + realMoveX + ")" + "(" + "he2" + " "
						+ realMoveY + ")";
			}
		}

		return str;
	}

	public static String MoveHeadStraight() {

		String str = "";

		float realMoveX = gNjV.Get("he1", 0) / 10;
		float realMoveY = gNjV.Get("he2", 0) / 10;
		str = "(" + "he1" + " " + realMoveX + ")" + "(" + "he2" + " "
				+ realMoveY + ")";

		return str;
	}

	public static String MoveHeadToBall() {

		int cycles = ServerCyrcles.getCyrclesNow();
		float moveX = (float) (2.09 * Math.sin(cycles / 15));
		float moveY = (float) (0.59 * Math.sin(cycles / 8) - 0.078);
		String str = "";

		if (Vision.isiSee() == true) {

			if (Ball.isSeeTheBall() == true) {
				str = "(" + "he1" + " " + centerTheBallX() + ")" + "(" + "he2"
						+ " " + centerTheBallY() + ")";
			} else {
				float realMoveX = gNjV.Get("he1", moveX) / 5;
				float realMoveY = gNjV.Get("he2", moveY) / 5;
				str = "(" + "he1" + " " + realMoveX + ")" + "(" + "he2" + " "
						+ realMoveY + ")";
			}

		}
		return str;
	}

	public static float centerTheBallX() {
		float x = 0;
		if (Math.abs(HingeJointPerceptor.getHj1()) < 125) {

			if (Ball.getAngleX() > 5) {
				x = 1;
				HeadAtBall = false;
			}
			if (Ball.getAngleX() < -5) {
				x = -1;
				HeadAtBall = false;
			}
		} else {

		}

		if (x == 0) {
			HeadAtBall = true;
		}
		return x;
	}

	public static float centerTheBallY() {
		float x = 0;
		if (Math.abs(HingeJointPerceptor.getHj2()) < 45) {

			if (Ball.getAngleY() > 5) {
				x = 1;

			}
			if (Ball.getAngleY() < -5) {
				x = -1;

			}
		} else {

		}
		return x;
	}

	public static float centerToLocateX(double AngleX) {

		float x = 0;
		if (Math.abs(AngleX) < 125) {

			if (AngleX > 5) {
				x = 1;
			}
			if (AngleX < -5) {
				x = -1;
			}
		} else {

		}
		return x;
	}

	public static float centerToLocateY(double AngleY) {

		float x = 0;
		if (Math.abs(AngleY) < 45) {

			if (AngleY > 5) {
				x = 1;
			}
			if (AngleY < -5) {
				x = -1;
			}
		} else {

		}
		return x;
	}

}