package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/path-sum-iii/
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSum3 {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curSum = 0;
        helper(root, curSum, sum, map);
        return count;
    }

    private void helper(TreeNode root, int sum, int ts, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (map.containsKey(sum - ts)) {
            count += map.get(sum - ts);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(root.left, sum, ts, map);
        helper(root.right, sum, ts, map);
        map.put(sum, map.get(sum) - 1);
    }
}
