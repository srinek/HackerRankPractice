package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pathList = new ArrayList<>();
        helper(root, targetSum, 0, pathList, result);
        return result;
    }

    private void helper(TreeNode root, int ts, int sum, List<Integer> pathList, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        pathList.add(root.val);
        if (root.left == null && root.right == null) {
            sum = sum + root.val;
            if (sum == ts) {
                result.add(new ArrayList<Integer>(pathList));
            }
        } else {
            helper(root.left, ts, sum + root.val, pathList, result);
            helper(root.right, ts, sum + root.val, pathList, result);
        }
        pathList.remove(pathList.size() - 1);
    }
}
