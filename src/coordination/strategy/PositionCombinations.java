package coordination.strategy;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;

public class PositionCombinations {

	static long start,end;
	
	private final static int characters[] = {1,2,3,4};

	private static int length = characters.length;

	public static void main(String[] args) {
		List<Integer> source = new LinkedList<Integer>();

		start = System.currentTimeMillis();
		
		// form the source list that have all the possible positions
		for (int i = 0; i < length; i++) {
			source.add(i);
		}

		// create a target list for forming unique combinations
		List<Integer> target = new LinkedList<Integer>();

		combine(source, target);
		end = System.currentTimeMillis();
		System.out.println((end-start));

	}

	public static void combine(List<Integer> source, List<Integer> target) {

		
		// break the recursion
		if (target.size() == length) {
			for (int i = 0; i < length; i++) {				
				//System.out.print(characters[target.get(i)]);				
			}
			//System.out.println();
			
			return;
		}
		for (Integer position : source) {
			//form the target combination by selecting a position from the source
			List<Integer> reducedSource = (List<Integer>)SerializationUtils.clone((LinkedList<Integer>)source);
			reducedSource.remove(position);
			List<Integer> combinedTarget = (List<Integer>)SerializationUtils.clone((LinkedList<Integer>)target);
			combinedTarget.add(position);
			combine(reducedSource, combinedTarget);			
		}
		
		
		source.clear();
		target.clear();
		
	}
}


