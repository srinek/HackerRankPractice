package algo.sort;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?
 */
public class FindMissingPositive {

    public int firstMissingPositive(int[] nums) {

        int missing = 1;
        Set<Integer> visited = new HashSet<>();
        for(int num : nums){
            if(missing == num){
                visited.add(num);
                while(visited.contains(missing)){
                    missing = missing + 1;
                }
            }
            else{
                visited.add(num);
            }
        }

        return missing;
    }
}
