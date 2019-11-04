package algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * Given an unsorted array of integers containing duplicates, find all possible 
 * sequences, using values no more times than they appear in the input.
 * Program must prefer creating the longest possible sequences from the input.
 *
 * Example Array: 8, 3, 4, 9, 5, 12, 4, 5, 6, 9
 * Example Output: [3, 4, 5, 6], [4, 5], [8, 9]
 */
public class PrintNumbersInSequence {

	//static int[] data = { 8, 3, 4, 9, 5, 12, 4, 5, 6, 9 };
	//static int[] data = { 1,1,1,1,1,2,3,2,2,2,2,4,5,3,6,3};
	static int[] data = { 1,1,1,1,1};

	public static void main(String[] args) {

		// Arrays.sort(data);

		List<List<Integer>> output = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		System.out.println(Arrays.toString(data));
		// 3 4 4 4 4 5 5 5 5 6 8 10 11
		// 3 4 5 6 8 10 11
		Map<Integer, Integer> map = new TreeMap<>();
		for (int k = 0; k < data.length; k++) {
			map.put(data[k], map.getOrDefault(data[k], 0) + 1);
		}
		System.out.println(map);
		while (map.size() > 0) {
			Set<Integer> sortedSet = map.keySet();
			int prev = -1;
			int i = 0;
			Iterator<Integer> setIter = sortedSet.iterator();
			while (setIter.hasNext()) {
				int elem = setIter.next();
				if (i == 0) {
					prev = elem;
				} else {

					if (prev + 1 == elem) {
						if (i == 1) {
							tempList.add(prev);
						}
						tempList.add(elem);
					} else {
						if (tempList.size() > 1) {
							output.add(tempList);
						}
						tempList = new ArrayList<>();
						tempList.add(elem);
					}
				}

				if (map.containsKey(elem)) {
					map.put(elem, map.get(elem) - 1);
					if (map.get(elem) <= 0) {
						setIter.remove();
					}
				}

				i++;
				prev = elem;
			}
			if (tempList.size() > 1) {
				output.add(tempList);
			}
			tempList = new ArrayList<>();

		}

		System.out.println(output);

	}
}
