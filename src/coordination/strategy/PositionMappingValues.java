package coordination.strategy;

import java.util.Vector;

public class PositionMappingValues {
	

	public Vector<PositionMapping> PosMap;
	public double cost;
	
	public PositionMappingValues(Vector<PositionMapping> posMap, double cost) {
		
		PosMap = posMap;
		this.cost = cost;
	}

	public Vector<PositionMapping> getPosMap() {
		return PosMap;
	}

	public void setPosMap(Vector<PositionMapping> posMap) {
		PosMap = posMap;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
