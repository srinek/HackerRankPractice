package trees;

public class Preorder {

	
	class Node {
	    int data;
	    Node left;
	    Node right;
	}
	
	private void preOrder(Node root) {
		if(root == null){
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
}

