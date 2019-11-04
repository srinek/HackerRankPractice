package trees;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class ZiZagTreeTraversal {

	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		
		dfs(root, result, 0);
		
		return result;
	}

	private void dfs(TreeNode node, List<List<Integer>> result, int level) {


		if(node ==  null){
			return;
		}
		
		if(result.size() <= level ){
			List<Integer> temp = new ArrayList<>();
			result.add(temp);
		}
		
		if(level % 2 == 0){
			result.get(level).add(node.val);
		}
		else{
			result.get(level).add(0, node.val);
		}
		dfs(node.left, result, level+1);
		dfs(node.right, result, level+1);
	}
}
