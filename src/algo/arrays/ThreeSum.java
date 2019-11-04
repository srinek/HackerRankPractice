package algo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/3sum/
 * 
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {
	
	
	public static void main(String[] args) {
		ThreeSum sum = new ThreeSum();
		System.out.println(sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}


	
	public List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		if(nums.length == 0){
			return result;
		}
		
		Arrays.sort(nums);
		// -4, -1, -1, 0, 1,2
		for(int i=0; i<nums.length-2; i++){
			
			if(i>0 && nums[i] == nums[i-1]){
				continue;
			}
			
			int sum = -nums[i];
			int lo  = i+1; 
			int hi = nums.length-1;
			
			while(lo < hi){
				
				if(nums[lo] + nums[hi] == sum){
					result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					while(lo < hi && nums[lo] == nums[lo+1]){
						lo++;
					}
					while(lo < hi && nums[lo] == nums[lo+1]){
						hi--;
					}
					lo++;
					hi--;
				}
				else if(nums[lo] + nums[hi] < sum){
					lo++;
				}
				else{
					hi--;
				}
				
			}
			
		}
		
		return result;
        
    }
}
