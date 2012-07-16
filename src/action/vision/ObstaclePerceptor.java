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
package action.vision;

import java.util.Vector;

import perceptor.localization.Coordinate;
import perceptor.localization.Landmark;
import perceptor.localization.LocalizationResults;

public class ObstaclePerceptor {

	public static Vector<Landmark> CoPlayers = new Vector<Landmark>();
	public static Vector<Landmark> OpPlayers = new Vector<Landmark>();
	public static Vector<Landmark> Posts = new Vector<Landmark>();
	public static Vector<Landmark> Obstacles = new Vector<Landmark>();
	public static Coordinate alternative = null;

	/*
	 * This method is responsible for percepting possible obstacles for the
	 * agent. To be considered an item as an obstacle must be at most 2 meters
	 * away from our agent.
	 * 
	 * Obstacle Perception cycle lasts until head reach one of the two edges of
	 * the head horizontal joint
	 * 
	 * In every cycle we have a complete sight of our environment as we percept
	 * everything around us (360 degrees).
	 */

	public static Coordinate Percept(Coordinate Target) {

		if ((HeadMovement.HeadAtRight) || (HeadMovement.HeadAtLeft)) {

			ObstaclePerceptor.Obstacles.removeAllElements();
			ObstaclePerceptor.Obstacles.addAll(ObstaclePerceptor.CoPlayers);
			ObstaclePerceptor.Obstacles.addAll(ObstaclePerceptor.OpPlayers);
			ObstaclePerceptor.Obstacles.addAll(ObstaclePerceptor.Posts);
			ObstaclePerceptor.alternative = ObstacleAvoidance.CheckForObstacle(
					Target, ObstaclePerceptor.Obstacles);
			ObstaclePerceptor.CoPlayers.removeAllElements();
			ObstaclePerceptor.OpPlayers.removeAllElements();
			ObstaclePerceptor.Posts.removeAllElements();

		}

		if (ObstaclePerceptor.CoPlayers.size() == 0) {

			for (int i = 0; i < LocalizationResults.getCoplayers().size(); i++) {
				if (LocalizationResults.getCoplayers().elementAt(i)
						.getDistance() < 2) {
					ObstaclePerceptor.CoPlayers.add(LocalizationResults
							.getCoplayers().elementAt(i));
				}
			}

		} else {

			for (int i = 0; i < LocalizationResults.getCoplayers().size(); i++) {

				if (LocalizationResults.getCoplayers().elementAt(i)
						.getDistance() < 2) {

					boolean isItSeen = false;

					for (int j = 0; j < ObstaclePerceptor.CoPlayers.size(); j++) {

						if (ObstaclePerceptor.CoPlayers
								.elementAt(j)
								.getName()
								.equalsIgnoreCase(
										LocalizationResults.getCoplayers()
												.elementAt(i).getName())) {

							isItSeen = true;

							double sumCos = Math
									.cos(Math
											.toRadians(ObstaclePerceptor.CoPlayers
													.elementAt(j)
													.getHorizontal_Angle()))
									+ Math.cos(Math
											.toRadians(LocalizationResults
													.getCoplayers()
													.elementAt(i)
													.getHorizontal_Angle()));

							double sumSin = Math
									.sin(Math
											.toRadians(ObstaclePerceptor.CoPlayers
													.elementAt(j)
													.getHorizontal_Angle()))
									+ Math.sin(Math
											.toRadians(LocalizationResults
													.getCoplayers()
													.elementAt(i)
													.getHorizontal_Angle()));

							ObstaclePerceptor.CoPlayers.elementAt(j)
									.setHorizontal_Angle(
											Math.toDegrees(Math.atan2(sumSin,
													sumCos)));

						}

					}

					if (!isItSeen) {
						ObstaclePerceptor.CoPlayers.add(LocalizationResults
								.getCoplayers().elementAt(i));
					}

				}

			}
		}

		if (ObstaclePerceptor.OpPlayers.size() == 0) {

			for (int i = 0; i < LocalizationResults.getRivals().size(); i++) {
				if (LocalizationResults.getRivals().elementAt(i).getDistance() < 2) {
					ObstaclePerceptor.OpPlayers.add(LocalizationResults
							.getRivals().elementAt(i));
				}
			}

		} else {

			for (int i = 0; i < LocalizationResults.getRivals().size(); i++) {

				if (LocalizationResults.getRivals().elementAt(i).getDistance() < 2) {

					boolean isItSeen = false;

					for (int j = 0; j < ObstaclePerceptor.OpPlayers.size(); j++) {

						if (ObstaclePerceptor.OpPlayers
								.elementAt(j)
								.getName()
								.equalsIgnoreCase(
										LocalizationResults.getRivals()
												.elementAt(i).getName())) {

							isItSeen = true;

							double sumCos = Math
									.cos(Math
											.toRadians(ObstaclePerceptor.OpPlayers
													.elementAt(j)
													.getHorizontal_Angle()))
									+ Math.cos(Math
											.toRadians(LocalizationResults
													.getRivals().elementAt(i)
													.getHorizontal_Angle()));

							double sumSin = Math
									.sin(Math
											.toRadians(ObstaclePerceptor.OpPlayers
													.elementAt(j)
													.getHorizontal_Angle()))
									+ Math.sin(Math
											.toRadians(LocalizationResults
													.getRivals().elementAt(i)
													.getHorizontal_Angle()));

							ObstaclePerceptor.OpPlayers.elementAt(j)
									.setHorizontal_Angle(
											Math.toDegrees(Math.atan2(sumSin,
													sumCos)));

						}

					}

					if (!isItSeen) {
						ObstaclePerceptor.OpPlayers.add(LocalizationResults
								.getRivals().elementAt(i));
					}

				}

			}
		}

		if (ObstaclePerceptor.Posts.size() == 0) {

			for (int i = 0; i < LocalizationResults.getLandmarks().size(); i++) {
				if (LocalizationResults.getLandmarks().elementAt(i).getName()
						.equalsIgnoreCase("g1r")
						|| LocalizationResults.getLandmarks().elementAt(i)
								.getName().equalsIgnoreCase("g2r")
						|| LocalizationResults.getLandmarks().elementAt(i)
								.getName().equalsIgnoreCase("g1l")
						|| LocalizationResults.getLandmarks().elementAt(i)
								.getName().equalsIgnoreCase("g2l")) {

					if (LocalizationResults.getLandmarks().elementAt(i)
							.getDistance() < 2) {
						ObstaclePerceptor.Posts.add(LocalizationResults
								.getLandmarks().elementAt(i));
					}

				}

			}

		} else {

			for (int i = 0; i < LocalizationResults.getLandmarks().size(); i++) {

				if (LocalizationResults.getLandmarks().elementAt(i).getName()
						.equalsIgnoreCase("g1r")
						|| LocalizationResults.getLandmarks().elementAt(i)
								.getName().equalsIgnoreCase("g2r")
						|| LocalizationResults.getLandmarks().elementAt(i)
								.getName().equalsIgnoreCase("g1l")
						|| LocalizationResults.getLandmarks().elementAt(i)
								.getName().equalsIgnoreCase("g2l")) {

					if (LocalizationResults.getLandmarks().elementAt(i)
							.getDistance() < 2) {

						boolean isItSeen = false;

						for (int j = 0; j < ObstaclePerceptor.Posts.size(); j++) {

							if (ObstaclePerceptor.Posts
									.elementAt(j)
									.getName()
									.equalsIgnoreCase(
											LocalizationResults.getLandmarks()
													.elementAt(i).getName())) {

								isItSeen = true;

								double sumCos = Math.cos(Math
										.toRadians(ObstaclePerceptor.Posts
												.elementAt(j)
												.getHorizontal_Angle()))
										+ Math.cos(Math
												.toRadians(LocalizationResults
														.getLandmarks()
														.elementAt(i)
														.getHorizontal_Angle()));

								double sumSin = Math.sin(Math
										.toRadians(ObstaclePerceptor.Posts
												.elementAt(j)
												.getHorizontal_Angle()))
										+ Math.sin(Math
												.toRadians(LocalizationResults
														.getLandmarks()
														.elementAt(i)
														.getHorizontal_Angle()));

								ObstaclePerceptor.Posts.elementAt(j)
										.setHorizontal_Angle(
												Math.toDegrees(Math.atan2(
														sumSin, sumCos)));

							}

						}

						if (!isItSeen) {
							ObstaclePerceptor.Posts.add(LocalizationResults
									.getLandmarks().elementAt(i));
						}

					}

				}

			}
		}

		return ObstaclePerceptor.alternative;

	}

}
