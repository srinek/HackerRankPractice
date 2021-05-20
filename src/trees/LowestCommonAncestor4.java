package trees;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/
 *
 * Given the root of a binary tree and an array of TreeNode objects nodes,
 * return the lowest common ancestor (LCA) of all the nodes in nodes. All the nodes will exist in the tree,
 * and all values of the tree's nodes are unique.
 *
 * Extending the definition of LCA on Wikipedia: "The lowest common ancestor of n nodes p1, p2, ..., pn in a binary tree T is the lowest node that has every pi as a descendant (where we allow a node to be a descendant of itself) for every valid i". A descendant of a node x is a node y that is on the path from node x to some leaf node.
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [7,6,2,4]
 * Output: 5
 * Explanation: The lowest common ancestor of the nodes 7, 6, 2, and 4 is node 5.
 */
public class LowestCommonAncestor4 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

		final Set<Integer> vals = new HashSet<>();
		for (TreeNode node: nodes) {
			vals.add(node.val);
		}

		return helper(root, vals);
	}

	private TreeNode helper(final TreeNode root, Set<Integer> vals) {
		if(root == null || vals.contains(root.val)){
			return root;
		}
		TreeNode left = helper(root.left, vals);
		TreeNode right = helper(root.right, vals);
		if(left == null){
			return right;
		}
		if(right == null){
			return left;
		}
		return root;
	}
}
