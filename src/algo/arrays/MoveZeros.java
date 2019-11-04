package algo.arrays;

/*
 * https://leetcode.com/problems/move-zeroes/
 * 
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeros {
	
    public void moveZeroes(int[] nums) {
        
        int i=0, j=0;
        // 1 2 3 0 4 5 6
        while( j<nums.length){
            
            if(nums[j] != 0){
                swap(nums, i, j);
                j++;
                i++;
            }
            else{
                j++;
            }
        }
        
    }
    
    public void swap(int[] nums, int i, int j){
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
