package trees;

public class PostOrder {

	class Node {
	    int data;
	    Node left;
	    Node right;
	}

	
	void postOrder(Node root) {
		
		if(root.left != null){
			postOrder(root.left);
		}
		if(root.right != null){
			postOrder(root.right);
		}
		System.out.print(root.data +" ");
		
		
	}
}
