package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/combination-sum/
 * 
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */

/*
 * 2 2 3 3
 * 
 * f({2}, 0, 5)                  i=0
 *   f({2,2}, 0, 3)              i=0
 *     f({2,2,2}, 0, 1)          i=0
 *       f({2,2,2,2}, 0, -1)     i=0
 *       f({2,2,2,3}, 1, -1)     i=1
 *       f({2,2,2,6}, 1, -1)     i=2
 *       f({2,2,2,7}, 1, -1)     i=3
 *     f({2,2,2,3}, 0, -1)       i=1
 *     f({2,2,2,6}, 0, -1)       i=2
 *     f({2,2,2,7}, 0, -1)       i=3
 *   f({2,2,3}, 0, 3)            i=1
 */
public class CombinationSum {
	
	public static int count;

	public static void main(String[] args) {
		CombinationSum combinationSum = new CombinationSum();
		 int[] inp = new int[]{2,3};
		// int[] inp = new int[]{7,6,3,2};
		System.out.println(combinationSum.combinationSum(inp, 7));
		System.out.println(count);
	}
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<>();
	        if(candidates == null || target <= 0){
	        	return result;
	        }
	        //Arrays.sort(candidates);
	        this.helper(candidates, 0, new ArrayList<Integer>(), result, target);
	        return result;
	 }
	 
	 private void helper(int[] inp, int start, ArrayList<Integer> r, List<List<Integer>> result, int remainder){
		 count++;
		 if(remainder < 0){
			 return;
		 }
		 if(remainder == 0){
			 result.add(new ArrayList(r));
			 return;
		 }
		 for(int i=start; i<inp.length; i++){
			 r.add(inp[i]);
			 this.helper(inp, i, r, result, remainder-inp[i]);
			 //System.out.println(r);
			 r.remove(r.size()-1);
			 //System.out.println(r);
			 //System.out.println("--------------------------"+ (i+1));
		 }
	 }

}
