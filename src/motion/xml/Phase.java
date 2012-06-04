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
package motion.xml;

import java.util.Vector;

public class Phase {

	public String name;
	public String nextPhase;
	public String finalize;
	public int duration;
	public int Phase_num;
	public boolean isFinal;
	public Vector<Move> movements = new Vector<Move>();

	public Phase(String name, String nextPhase, String finalize, int duration,
			int phase_num, boolean isFinal, Vector<Move> movements) {

		this.name = name;
		this.nextPhase = nextPhase;
		this.finalize = finalize;
		this.duration = duration;
		Phase_num = phase_num;
		this.isFinal = isFinal;
		this.movements = movements;
	}

	public Phase() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNextPhase() {
		return nextPhase;
	}

	public void setNextPhase(String nextPhase) {
		this.nextPhase = nextPhase;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPhase_num() {
		return Phase_num;
	}

	public void setPhase_num(int phase_num) {
		Phase_num = phase_num;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	public Vector<Move> getMovements() {
		return movements;
	}

	public void setMovements(Vector<Move> movements) {
		this.movements = movements;
	}

	public String getFinalize() {
		return finalize;
	}

	public void setFinalize(String finalize) {
		this.finalize = finalize;
	}

}
