package algo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * You are given an integer array nums and an integer x.
 * In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x.
 * Note that this modifies the array for future operations.
 *
 * Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * Example 2:
 *
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * Example 3:
 *
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 */
public class MinimumOpsToReduceXtoZero {

    public int minOperationsAlt(int[] nums, int x) {
        int currentSum = 0;
        int total = 0;
        for (int i=0; i<nums.length; i++) {
            total += nums[i];
        }
        int req = total - x;
        int res = -1;
        int left =0;
        for (int right=0; right<nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > req && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == req) {
                res = Math.max(res, right-left+1);
            }
        }
        return res != -1 ? nums.length - res : -1;
    }

    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num: nums) {
            target += num;
        }
        if (target == 0) return nums.length;
        final Map<Integer, Integer> mem = new HashMap<>();
        mem.put(0, -1);
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (mem.containsKey(sum-target)) {
                res = Math.max(res, i-mem.get(sum-target));
            }
            mem.put(sum, i);
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}
