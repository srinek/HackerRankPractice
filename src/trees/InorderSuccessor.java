package trees;

public class InorderSuccessor {
	
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
	}

	private TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		
		if(root == null){
			return null;
		}
		
		if( root.val <= p.val ){
			
			return inorderSuccessor(root.right, p);
		}
		TreeNode temp = inorderSuccessor(root.left, p);
		return temp != null ? temp : root;
		
	}
}
