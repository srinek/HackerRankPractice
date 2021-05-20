package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/solution/
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            helper(0, i, nums, new ArrayList<Integer>(), result);
        }
        return result;
    }

    private void helper(int start, int end, int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == end) {
            result.add(new ArrayList(curr));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(i + 1, end, nums, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSets s = new SubSets();
        System.out.println(s.subsets(new int[]{1,2,3}));
    }
}
