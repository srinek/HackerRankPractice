package algo.sort;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
 *
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int[] result = new int[n];
        int i = n - 1;
        while (i >= 0) {
            if (Math.abs(nums[l]) < Math.abs(nums[r])) {
                result[i] = nums[r] * nums[r];
                r--;
            } else {
                result[i] = nums[l] * nums[l];
                l++;
            }
            i--;
        }
        return result;
    }
}
