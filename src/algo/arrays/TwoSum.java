package algo.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2,7, 6, 8], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {

	/*public int[] findTwoSum(int[] input, int target){
		
		if(input == null){
			return new int[]{};
		}
		int[] result = new int[2];
		Arrays.sort(input);
		int i=0, j=input.length-1;
		while(i<=j){
			int left = input[i];
			int right = input[j];
			if(left+right > target){
				right--;
			}
			else if(left+right < target){
				left++;
			}
			else{
				result[0] = i;
				result[1] = j;
			}
		}
		return result;
		
	}*/
	
	public int[] findTwoSum(int[] input, int target){
		
		if(input == null){
			return new int[]{};
		}
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<input.length; i++){
			if(i == 0){
				map.put(input[i], i);
			}
			else{
				int reminder = target - input[i];
				if(map.get(reminder) != null ){
					result[0] = map.get(reminder);
					result[1] = i;
				}
				else{
					map.put(input[i], i);				
				}
			}
		}
		return result;
		
	}
}
