package trees;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 * 
 * 
 * @author Nanda
 * 
 *         Invert a binary tree.
 * 
 *         Example:
 * 
 *         Input:
 * 
 *         4 / \ 2 7 / \ / \ 1 3 6 9 Output:
 * 
 *         4 / \ 7 2 / \ / \ 9 6 3 1
 *
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		invertTree(root.left);
		invertTree(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		return root;
	}

	private static class TreeNode {

		public int val;
		public TreeNode left;
		public TreeNode right;
	}
}
