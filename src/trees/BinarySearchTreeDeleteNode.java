package trees;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
 * @author nnekkant
 *
 */

public class BinarySearchTreeDeleteNode {


	public TreeNode deleteNode(TreeNode root, int key){

		
		if(root == null){
			return null;
		}
		
		if(root.val == key){
			if(root.left == null && root.right == null){
				root = null;
			}
			else if(root.right != null){
				root.val = successor(root);
				root.right = deleteNode(root.right, root.val);
			}
			else{
				root.val = predecessor(root);
				root.left = deleteNode(root.left, root.val);
			}
		}
		else if( key < root.val){
			root.left = deleteNode(root.left, key);
		}
		else{
			root.right = deleteNode(root.right, key);
		}
		
		return root;
	}
	
	private int successor(TreeNode node){
		
		node = node.right;
		
		while(node.left != null){
			node = node.left;
		}
		return node.val;
	}
	
	private int predecessor(TreeNode node){
		
		node = node.left;
		
		while(node.right != null){
			node = node.right;
		}
		return node.val;
	}
	
	private static class TreeNode{
		
		int val;
		
		TreeNode left;
		TreeNode right;
		
	}
}



