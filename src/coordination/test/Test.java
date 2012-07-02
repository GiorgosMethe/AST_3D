package coordination.test;

import java.util.Vector;


public class Test {

	/**
	 * @param args
	 */
	public static long a, b;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int Counter=0;
		int[] agents = new int[]{1,2,3,4,5,6,7,8};
		int[] positions = new int[]{1,2,3,4,5,6,7,8};
		BestRoleMap[] Best= new BestRoleMap[positions.length];
		Vector<HashMap> temp = new Vector<HashMap>();

		long a12=System.currentTimeMillis();
		
		for(int k=0;k<7;k++){

			Best[k]=new BestRoleMap(new Vector<HashMap>(), 0);
			for(int a=0;a<7;a++){

				
				HashMap a1 = new HashMap(agents[a], positions[k]);
				temp.add(a1);
				Best[k].getBestVector().add(a1);

			}

			temp.removeAllElements();

		}
		b = System.currentTimeMillis();

		System.out.println("Active coordination time: " + (b - a12) + "ms");

		int h=6;
		for(int i=0;i<Best[h].getBestVector().size();i++){
			System.out.print("A "+Best[h].getBestVector().elementAt(i).getNumber());
			System.out.println("--> P "+Best[h].getBestVector().elementAt(i).getPosition());
		}
		

	}
	
}
