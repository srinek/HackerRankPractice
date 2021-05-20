package algo.arrays;


/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Input: nums = [34, 45,65,73, 89,4, 8, 10, 12], target = 3
Output: -1
 */

public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
	   SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
	   System.out.println(sol.search(new int[]{1}, 1));
	   System.out.println(sol.search(new int[]{3,1}, 3));
	   System.out.println(sol.search(new int[]{4,5,6,7,0,1,2}, 3));
	}

	//[4,5,6,7,0,1,2]
	//[0,1,2,4,5,6,7]
	public int search(int[] nums, int target) {
	
		if(nums == null){
			return -1;
		}
	    int l=0, r=nums.length-1, mid = 0;
	    
	    while(l < r){
	    	mid = l + (r-l)/2;
	    	if(nums[mid] > nums[r]){
	    		l = mid + 1 ;
	    	}
	    	else{
	    		r = mid;
	    	}
	    }
	    
	    int rotatedBy = l;
	    l = 0; r = nums.length; mid = 0;
	    int rmid = 0;
	    while(l < r){
	    	mid = (l+r)/2;
	    	rmid = rotatedBy+mid >= nums.length ? (rotatedBy+mid-nums.length) : rotatedBy+mid;
	    	if(target == nums[rmid]){
	    		return rmid;
	    	}
	    	if(target > nums[rmid]){
	    		l = mid + 1;
	    	}
	    	else{
	    		r = mid;
	    	}
	    }
	    
	    return -1;
	}
}
