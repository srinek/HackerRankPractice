package trees;

public class TreeMinimun {

	public static void main(String[] args) {
		findMin(null);
	}
	
	private static int findMin(Node root){
		if(root != null){
			if(root.left != null){
				findMin(root.left);
			}
			return root.data;
		}
		return -1;
	}
	
	class Node {
	    int data;
	    Node left;
	    Node right;
	}
}
