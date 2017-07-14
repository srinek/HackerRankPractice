package trees;

import java.util.Stack;

public class TreeTopView {

	class Node {
		int data;
		Node left;
		Node right;
	}

	void topView(Node root) {
		if(root == null){
			return;
		}
		Stack<Integer> temp = new Stack<>();
		printLeft(root.left, temp);
		while(!temp.isEmpty()){
			System.out.print(temp.pop() +" ");
		}
		printRoot(root);
		printRight(root.right);
		
	}
	
	private void printRight(Node root) {
		if(root != null){
			System.out.print(root.data +" ");
			printRight(root.right);
			if(root.right == null){
				printRight(root.left);
			}
		}
	}

	private void printRoot(Node root) {
		System.out.print(root.data +" ");
	}

	void printLeft(Node root, Stack<Integer> temp){

		if(root != null){
			temp.push(root.data);
			printLeft(root.left, temp);
			if(root.left == null){
				printLeft(root.right, temp);
			}
			
		}
	}
}
