package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
	public static void main(String[] args) {
		Permutation per = new Permutation();
		System.out.println(per.permute(new int[]{1,2,1}));
	}
	
	
	 
	private List<List<Integer>> permute(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		permuteHelper(arr, 0 , result);
		return result;
	}



	private void permuteHelper(int[] arr, int start, List<List<Integer>> result) {
		
		if(start == arr.length){
			List<Integer> tempList = new ArrayList<>();
		    for(int i=0; i<arr.length; i++){
		    	tempList.add(arr[i]);
		    }
		    result.add(tempList);
			return;
		}
		/*
		 * 1. first iteration swap 0,0  0,1 0,2   
		 * 2. 
		 */
		for(int i=start; i<arr.length; i++){
			if(start != i && arr[start] == arr[i] ){
				continue;
			}
			swap(arr, start, i);
			permuteHelper(arr, start+1, result);
			swap(arr, start, i); // put it back ( backtrack) for next iteration
		}
		
	}



	private void swap(int[] nums, int i, int j){
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}

}
