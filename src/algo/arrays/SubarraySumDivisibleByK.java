package algo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 */
public class SubarraySumDivisibleByK {
    public int subarraysDivByK(int[] a, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for(int i=0; i < a.length; i++) {
            sum = sum + a[i];
            sum = sum % k;
            if (sum < 0) {
                sum = sum + k;
            }
            if (map.containsKey(sum)) {
                res = res + map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
