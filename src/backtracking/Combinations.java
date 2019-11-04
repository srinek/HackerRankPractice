package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Combinations {
	
	public static void main(String[] args) {
		Combinations combinations = new Combinations();
		System.out.println(combinations.combine(3, 3));
	}

	public List<List<Integer>> combine(int n, int k) {
	
		LinkedList<List<Integer>> result = new LinkedList<>();
		if(n < k){
    		return result;
    	}
		Queue<List<Integer>> q = new LinkedList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		q.offer(temp);
		for(int i=2; i<=n; i++){
			helper(i, k, q, result);
		}
		int size = q.size();
		while(size-- > 0){
			List<Integer> l = q.poll();
			if(l.size() == k){
				result.add(l);
			}
		}
		
		return result;
	}
	
	private void helper(int current, int k, Queue<List<Integer>> q, LinkedList<List<Integer>> result){
		
		int size = q.size();
		boolean currentAdded = false;
		while(size-- > 0){
			
			List<Integer> temp = q.poll();
			if(temp.size() == k){
				result.add(temp);
			}
			else{
				q.offer(temp);
				List<Integer> newTemp = new ArrayList<>(temp);
				newTemp.add(current);
				q.offer(newTemp);
				if(!currentAdded){
					List<Integer> curTemp = new ArrayList<>();
					curTemp.add(current);
					q.offer(curTemp);
					currentAdded = true;
				}
				
			}
		}
	}
	
   /* public List<List<Integer>> combine(int n, int k) {
        
    	
    	LinkedList<List<Integer>> result = new LinkedList<>();
    	if(n < k){
    		return result;
    	}
    	helper(n, k, result, 1, null);
    	return result;
    }

	private void helper(int n, int k, LinkedList<List<Integer>> result, int start, LinkedList<Integer> list) {
		
		if(list != null && list.size() == k){
			result.add(list);
			return;
		}
		for(int i = start; i<= n; i++){
			LinkedList<Integer> templist = new LinkedList<>();
			for(int j=0; list != null &&  j < list.size(); j++){
				templist.add(list.get(j));
			}
			templist.add(i);
			helper(n, k, result, i+1, templist);
		}
	}*/

}
