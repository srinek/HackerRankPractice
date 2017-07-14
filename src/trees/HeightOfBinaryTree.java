package trees;

public class HeightOfBinaryTree {

	class Node {
		int data;
		Node left;
		Node right;
	}

	static int height(Node root) {
		if(root == null){
			return -1;
		}
		int lheight = 1 + height(root.left);
		int rheight = 1 + height(root.right);
		int height = lheight > rheight ? lheight : rheight;
		return height;
	}
}
