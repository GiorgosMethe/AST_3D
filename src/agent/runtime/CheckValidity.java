package agent.runtime;

import agent.constraints.Constraints;

public class CheckValidity {

	public void Number(final int number) {

		if (number > Constraints.numberPlayers) {
			System.err.println("error number (1-" + Constraints.numberPlayers
					+ ")");
			System.exit(1);
		}

	}

}
