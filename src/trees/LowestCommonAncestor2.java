package trees;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
 *Given the root of a binary tree, return the lowest common ancestor (LCA) of two given nodes, p and q. If either node p or q does not exist in the tree, return null. All values of the nodes in the tree are unique.
 *
 * According to the definition of LCA on Wikipedia:
 * "The lowest common ancestor of two nodes p and q in a binary tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)".
 * A descendant of a node x is a node y that is on the path from node x to some leaf node.
 */
public class LowestCommonAncestor2 {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	boolean pf;
	boolean qf;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		final TreeNode lca = lcaUtil(root, p, q);
		if (pf && qf) {
			return lca;
		}
		return null;
	}

	private TreeNode lcaUtil(final TreeNode root, final TreeNode p, final TreeNode q) {
		if (root == null) {
			return root;
		}
		TreeNode left = lcaUtil(root.left, p, q);
		TreeNode right = lcaUtil(root.right, p, q);
		if (root.val == p.val) {
			pf = true;
			return root;
		}
		if (root.val == q.val) {
			qf = true;
			return root;
		}
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		return root;
	}
}
