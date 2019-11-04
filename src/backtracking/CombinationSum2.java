package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/combination-sum-ii/
 */
/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
public class CombinationSum2 {

	 public static void main(String[] args) {
		 CombinationSum2 sum2 = new CombinationSum2();
		 //int[] candidates = new int[]{1,1,1,1};
		 int[] candidates = new int[]{2,5,2,1,2};
		 System.out.println(sum2.combinationSum2(candidates, 5));
	}
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	 
		 List<List<Integer>> result = new ArrayList<>();
		 if(candidates == null || candidates.length == 0 || target <= 0){
			 return result;
		 }
		 Arrays.sort(candidates);
		 backtracking(candidates, new ArrayList<Integer>(), result, 0, target);
		 return result;
	 }
	 
	 /*
	  *  [ 2,3,4, 1]  7
	  */
	 private void backtracking(int[] candidates, List<Integer> r, List<List<Integer>> result, int start, int remainder){
		 
		 //System.out.println( "start "+start +" r "+ r + "   remainder "+remainder);
		 if(remainder < 0){
			 return;
		 }
		 if(remainder == 0){
			 result.add(new ArrayList<Integer>(r));
			 return;
		 }
		 for(int i=start; i<candidates.length; i++){
             if(i > start && candidates[i] == candidates[i-1]){
            	 continue;
             }
			 r.add(candidates[i]);
			 backtracking(candidates, r, result, i+1, remainder-candidates[i]);
			 r.remove(r.size()-1);
		 }
	 }
}
