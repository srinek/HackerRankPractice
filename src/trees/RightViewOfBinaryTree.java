package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 */
public class RightViewOfBinaryTree {

	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        printRightView(root, result, 0);
        return result;
    }
    int maxLevel = -1;
    private void printRightView(TreeNode node, List<Integer> result, int level){
        
        if(node == null){
            return;
        }
        
        if(maxLevel < level){
            result.add(node.val);
            maxLevel = level;
        }
        printRightView(node.right, result, level+1);
        printRightView(node.left, result, level+1);
    }
    
}
