package trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/validate-binary-tree-nodes/
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
 *
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 *
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * Output: true
 * Example 2:
 *
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * Output: false
 * Example 3:
 *
 *
 * Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * Output: false
 * Example 4:
 *
 *
 * Input: n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 * leftChild.length == rightChild.length == n
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 */
public class ValidateBinaryTreeNodes {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;
        boolean visited;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        TreeNode root = null;
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeMap.put(i, new TreeNode(i));
        }
        for (int i = 0; i < n; i++) {
            TreeNode node = nodeMap.get(i);
            if (leftChild[i] != -1) {
                node.left = nodeMap.get(leftChild[i]);
                if (nodeMap.get(leftChild[i]).parent != null) {
                    return false;
                }
                nodeMap.get(leftChild[i]).parent = node;
            }
            if (rightChild[i] != -1) {
                node.right = nodeMap.get(rightChild[i]);
                if (nodeMap.get(rightChild[i]).parent != null) {
                    return false;
                }
                nodeMap.get(rightChild[i]).parent = node;
            }
        }
        TreeNode node = nodeMap.get(0);
        while (node.parent != null) {
            node = node.parent;
        }
        //dfs
        dfs(node);
        for (int i = 0; i < n; i++) {
            if (!nodeMap.get(i).visited) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node) {
        if (node == null || node.visited) {
            return;
        }
        node.visited = true;
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        ValidateBinaryTreeNodes vb = new ValidateBinaryTreeNodes();
        boolean result = vb.validateBinaryTreeNodes(6, new int[]{1,-1,-1,4,-1,-1}, new int[]{2,-1,-1,5,-1,-1});
        System.out.println(result);
    }
}
