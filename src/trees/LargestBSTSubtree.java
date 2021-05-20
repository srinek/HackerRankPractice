package trees;

/**
 * https://leetcode.com/problems/largest-bst-subtree/
 * Given the root of a binary tree, find the largest subtree, which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.
 *
 * A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties:
 *
 * The left subtree values are less than the value of their parent (root) node's value.
 * The right subtree values are greater than the value of their parent (root) node's value.
 * Note: A subtree must include all of its descendants.
 *
 * Follow up: Can you figure out ways to solve it with O(n) time complexity?
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [10,5,15,1,8,null,7]
 * Output: 3
 * Explanation: The Largest BST Subtree in this case is the highlighted one. The return value is the subtree's size, which is 3.
 * Example 2:
 *
 * Input: root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -104 <= Node.val <= 104
 */
public class LargestBSTSubtree {
    static class Result {
        Integer size;
        int lower;
        int higher;
        Result(Integer size, int lower, int higher) {
            this.size = size;
            this.lower = lower;
            this.higher = higher;
        }

        public String toString() {
            return this.lower + " " + this.higher;
        }
    }
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        isBST(root, null);
        return max;
    }

    private Result isBST(TreeNode node, TreeNode parent) {
        if (node == null) {
            return new Result(0, parent.val, parent.val); // a null child means it is a valid bst.
        }
        Result left = isBST(node.left, node);
        Result right = isBST(node.right, node);
        if (left == null || right == null ||
            (left.size != 0 && node.val <= left.higher) ||
            (right.size != 0 && node.val >= right.lower)) {
            return null; // not a BST;
        }
        int size = left.size + right.size + 1;
        max = Math.max(size, max);
        return new Result(size, left.lower, right.higher);
    }

    public static void main(String[] args) {
        LargestBSTSubtree sub = new LargestBSTSubtree();
        //System.out.println(sub.largestBSTSubtree(TreeNode.fromArray(new Integer[] {10, 5, 15, 1, 7, null, 7})));
        System.out.println(sub.largestBSTSubtree(TreeNode.fromArray(new Integer[] {4,2,7,2,3,5,null,2,null,null,null,null,null,1})));
    }
}
