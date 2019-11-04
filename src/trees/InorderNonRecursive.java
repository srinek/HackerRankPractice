package trees;

import java.util.Stack;

import trees.InOrder.Node;

public class InorderNonRecursive {

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
