package trees;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
 *
 * The length of the path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,5,1,1,5]
 * Output: 2
 * Example 2:
 *
 *
 * Input: root = [1,4,5,4,4,5]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 * The depth of the tree will not exceed 1000.
 */
public class LongestUniValuePath {
    class Pair {
        int count;
        TreeNode node;
        Pair(int count, TreeNode node) {
            this.count = count;
            this.node = node;
        }
    }

    int total = 0;
    public int longestUnivaluePath(TreeNode root) {
        uniPath(root);
        return total > 0 ? total - 1 : 0;
    }

    private Pair uniPath(TreeNode node) {
        if (node == null) {
            return new Pair(0, null);
        }
        if (node.left == null && node.right == null) {
            return new Pair(1, node);
        }
        Pair left = uniPath(node.left);
        Pair right = uniPath(node.right);
        if ((left.count == 0 || left.node.val == node.val) && (right.count == 0 || right.node.val == node.val)) {
            total = Math.max(total, left.count + right.count + 1);
            return new Pair(Math.max(left.count, right.count) + 1, node);
        }
        if ((left.count == 0 || left.node.val == node.val)) {
            total = Math.max(total, left.count + 1);
            return new Pair(left.count + 1, node);
        }
        if ((right.count == 0 || right.node.val == node.val)) {
            total = Math.max(total, right.count + 1);
            return new Pair(right.count + 1, node);
        }
        return new Pair(1, node);
    }
}
