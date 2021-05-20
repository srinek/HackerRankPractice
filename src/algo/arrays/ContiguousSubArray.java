package algo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array/
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousSubArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (indexMap.containsKey(sum)) {
                max = Math.max(max, i - indexMap.get(sum));
            }
            indexMap.put(sum, i);
        }
        return max;
    }

    public static void main(String[] args) {
        ContiguousSubArray sub = new ContiguousSubArray();
        sub.findMaxLength(new int[]{0,0,0,0,1,1,0,0,0,0,1,1,1,1,0,0});
    }
}
