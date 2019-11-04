package algo;

/**
 * 1 / \ 2 3 / \ /\ 4 5 6 7
 * 
 * @author nnekkant
 *
 */

// 1 2 4 5 3 6 7
public class TreeTraversal<T> {

	private static class TreeNode<T> {

		public T val;

		public TreeNode<T> left;

		public TreeNode<T> right;
		
		public TreeNode(T val){
			this.val = val;
		}

	}

	private static TreeNode<Integer> makeTree(){
		
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<Integer>(3);
		root.left.left = new TreeNode<Integer>(4);
		root.left.right = new TreeNode<Integer>(5);
		root.right.left = new TreeNode<Integer>(6);
		root.right.right = new TreeNode<Integer>(7);
		
		String someting = "";
		
		return root;
	}
	
	public static void main(String[] args) {
		TreeTraversal<Integer> tree = new TreeTraversal<>();
		TreeNode<Integer> root = makeTree();
		tree.printPreorder(root);
		System.out.println();
		tree.printInorder(root);
	} 
	
	public void printPreorder(TreeNode<T> root) {
        
		if(root == null){
			return;
		}
		System.out.print(root.val + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	public void printInorder(TreeNode<T> root) {
        
		if(root == null){
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}
}
