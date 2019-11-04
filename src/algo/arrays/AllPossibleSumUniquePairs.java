package algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer array a and number k, output all unique pairs that sum up to k. Example: for input [1, 3, 2, 5, 46, 6, 7, 4] and k = 5, output (1, 4) ( 3,2).
 * 
 * a = [ 1,3,2,5,46,6,7,4] and k = 5
 * (1,4 ( 3,2)
 * 
 * [ 1,2,3,4,5,6,7,46]
 */
public class AllPossibleSumUniquePairs {

	public static void main(String[] args){
		uniquePairs(new int[]{1, 3, 2, 5, 46, 6, 7, 4}, 5);
	}
	
	public static void uniquePairs(int[] arr, int k){
		
		if(arr == null || k < 0){
			return;
		}
		//sort
		Arrays.sort(arr);
		//eliminate duplicates
		List<Integer> new_arr = new ArrayList<>();
		for(int i=0, l=0; i<arr.length-1; i++){
			if(arr[i] != arr[i+1]){
				new_arr.add(arr[i]);
			}
		}
		if(new_arr.get(new_arr.size()-1) != arr[arr.length-1]){
			new_arr.add(arr[arr.length-1]);
		}
		//two pointer navigation.
		for(int i=0, j= new_arr.size()-1; i<=j; ){
			int sum = new_arr.get(i) + new_arr.get(j);
			if(sum > k){
				j--;
			}
			if(sum < k){
			    i++;
			}
			if(sum == k){
				System.out.println("("+new_arr.get(i)+","+new_arr.get(j)+")");
				i++;
				j--;
			}
			
		}
	}
}
