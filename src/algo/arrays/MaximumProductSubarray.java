package algo.arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prod = 1;
        int maxprod = Integer.MIN_VALUE;
        for (int j=0; j<nums.length; j++) {
            prod = prod * nums[j];
            maxprod = Math.max(maxprod, prod);
            if (nums[j] <= 0) {
                prod = 1;
            }
        }
        return maxprod;
    }
}
