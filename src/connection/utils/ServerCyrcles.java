package connection.utils;

public class ServerCyrcles {

	static int Cyrcles = 0;
	static int GameCyrcles = 0;

	public static int getCyrclesNow() {
		return Cyrcles;
	}

	public static void setCyrclesNow(int cyrcles) {
		Cyrcles = cyrcles;
	}

	public static int getGameCyrcles() {
		return GameCyrcles;
	}

	public static void setGameCyrcles(int gameCyrcles) {
		GameCyrcles = gameCyrcles;
	}

}
