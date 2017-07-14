package trees;

public class IsBinarySearchTree {

	class Node {
		int data;
		Node left;
		Node right;
	}

	boolean checkBST(Node root) {
		
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		return checkBST(root, min, max);
	}
	
	boolean checkBST(Node root, int min, int max){
		if(root == null ){
			return true;
		}
		if(!checkValue(root.data, min, max)){
			return false;
		}
		return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
	}
	
	boolean checkValue(int value, int min, int max){
		
		if(value >= max || value <= min){
			return false;
		}
		return true;
	}
}
