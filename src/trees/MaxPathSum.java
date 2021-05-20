package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */
public class MaxPathSum {

int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxValue;
    }
    
    private int maxPathSumHelper(TreeNode node) {
        if (node == null){
          return 0;  
        } 
        
        int leftSum = Math.max(0, maxPathSumHelper(node.left));
        int rightSum = Math.max(0, maxPathSumHelper(node.right));
        maxValue = Math.max(maxValue, leftSum+rightSum+node.val);
        return Math.max(leftSum, rightSum)+node.val;
    }
	
	
}

class TreeNode {
    public static TreeNode fromArray(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();
            if (arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                q.offer(node.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public String toString() {
	    StringBuilder str = new StringBuilder();
	    str.append("[");
	    str.append(this.val);
        str.append(",");
	    if (left != null) {
            str.append(left.toString());
        } else {
            str.append("null");
        }
        str.append(",");
        if (right != null) {
            str.append(right.toString());
        } else {
            str.append("null");
        }
        str.append("]");
        return str.toString();
    }

}
