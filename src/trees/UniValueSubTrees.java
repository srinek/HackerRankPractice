package trees;

/**
 * Given the root of a binary tree, return the number of uni-value subtrees.
 *
 * A uni-value subtree means all nodes of the subtree have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,1,5,5,5,null,5]
 * Output: 4
 * Example 2:
 *
 * Input: root = []
 * Output: 0
 * Example 3:
 *
 * Input: root = [5,5,5,5,5,null,5]
 * Output: 6
 */
public class UniValueSubTrees {
    class Pair {
        TreeNode node;
        boolean isUni;
        Pair(TreeNode node, boolean isnUni) {
            this.node = node;
            this.isUni = isnUni;
        }
    }
    int total = 0;
    public int countUnivalSubtrees(TreeNode root) {
        uniHelper(root);
        return total;
    }

    private Pair uniHelper(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            total++;
            return new Pair(node, true);
        }
        Pair left = uniHelper(node.left);
        Pair right = uniHelper(node.right);
        boolean isUni = false;
        if ( (left == null || (left.isUni && left.node.val == node.val)) && (right == null || (right.isUni && right.node.val == node.val))) {
            total++;
            isUni = true;
        }
        return new Pair(node, isUni);
    }
}
