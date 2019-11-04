package trees;

import java.util.ArrayList;
import java.util.List;

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
