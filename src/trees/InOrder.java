package trees;

import java.util.Stack;

public class InOrder {

	class Node {
	    int data;
	    Node left;
	    Node right;
	}

	

	void inOrder(Node root) {
		if(root.left != null){
			inOrder(root.left);
		}
		System.out.print(root.data + " ");
		if(root.right != null){
			inOrder(root.right);
		}
	}
	
	void inOrderIterative(Node root) {
		
		Stack<Node> stack = new Stack<>();
		
		while(true){
			if(root != null){
				stack.push(root);
				root = root.left;
			}
			else if(!stack.isEmpty()){
				root = stack.pop();
				System.out.print(root.data + " ");
				root = root.right;
			}
			else{
				break;
			}
		}
	}
}
