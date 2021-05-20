package trees;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 */
public class LowestCommonAncestorOfBST {

	class Node {
		int data;
		Node left;
		Node right;
	}

	// note: this question is specifically for BST.
	static Node lca(Node root,int v1,int v2)
	{

	    if(root.data < v1 && root.data < v2){
	        return lca(root.right,v1,v2);
	    }
	    if(root.data > v1 && root.data > v2){
	        return lca(root.left,v1,v2);
	    }

	    return root;
	}

}
