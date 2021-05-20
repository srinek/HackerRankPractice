package algo.arrays;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 *
 * Follow up: Your solution should run in O(log n) time and O(1) space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 */
public class SingleElementInSortedArray {

	public static void main(String[] args) {
		SingleElementInSortedArray sol = new SingleElementInSortedArray();
		
		//System.out.println(sol.singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,5}));
		System.out.println(sol.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
		
	}
	public int singleNonDuplicate(int[] nums) {

		int l = 0, r = nums.length-1, mid = 0;

		while(l <= r){
			mid = (l+r)/2;
			if(mid == 0 || mid == nums.length -1){
				return nums[mid];
			}

			if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
				return nums[mid];
			}
			if(nums[mid] == nums[mid-1]){
				if( (mid-1-l)%2 == 1 ){
					r = mid-2;
				}
				else{
					l = mid+1;
				}
			}
			else{  // equals to mid+1
				if( (r - mid + 1)%2 == 1 ){
					l = mid + 2;
				}
				else{
					r = mid-1;
				}
			}
		}
		return nums[mid];
	}

}
