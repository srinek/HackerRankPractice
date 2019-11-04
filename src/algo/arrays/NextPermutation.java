package algo.arrays;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/next-permutation/
 */
/*
 * implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 -> 1,3,2
3,2,1 -> 1,2,3
1,1,5 -> 1,5,1
199 -> 919
 */
public class NextPermutation {
	
	public static void main(String[] args) {
		NextPermutation next = new NextPermutation();
		//int[] nums = new int[]{2,3,5,8,7,6,4,1};
		//int[] nums = new int[]{1,5,8,4,7,6,5,3,1};
		int[] nums = new int[]{2,3,1,3,3}; // 2,3,3,1,3
		//int[] nums = new int[]{1,9,9}; // 9,1,9
		 next.nextPermutation(nums);
		 System.out.println(Arrays.toString(nums));
	}

	 // 876
	 public void nextPermutation(int[] nums) {
		 
		 int k = 0, nextMax = Integer.MAX_VALUE, nextMaxIndex = -1;
		 int i=nums.length-1;
		 while(i>0){
			 if(nums[i-1] < nums[i]){
				 k=i;
				 while(k < nums.length){
					 if(nums[k] <= nextMax && nums[k] > nums[i-1]){
						 nextMax =   nums[k]; 
						 nextMaxIndex = k;
					 }
					 k++;
				 }
				 swap(i-1, nextMaxIndex, nums);
				 break;
			 }
			 i--;
		 }
		 int begin = i, end = nums.length-1;
		 while(begin < end){
			 swap(begin, end,nums);
			 begin++;
			 end--;
		 }
	 }

	private void swap(int i, int j, int[] nums) {
		
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}
}
