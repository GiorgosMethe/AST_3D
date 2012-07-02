package coordination.test;

import java.util.Vector;

public class BestRoleMap {
	
	public Vector<HashMap> BestVector = new Vector<HashMap>();
	public float cost;

	public BestRoleMap(Vector<HashMap> bestVector, float cost) {
		BestVector = bestVector;
		this.cost = cost;
	}
	public Vector<HashMap> getBestVector() {
		return BestVector;
	}
	public void setBestVector(Vector<HashMap> bestVector) {
		BestVector = bestVector;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	

}
