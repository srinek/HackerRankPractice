package trees;

public class BSTInsert {

	static class Node {
		int data;
		Node left;
		Node right;

	}

	static Node Insert(Node root, int value) {
		
		if(root == null){
			Node node = createNode(value, null, null);
			return node;
		}
		insertToTree(root, value);
		return root;
	}
	
    static void insertToTree(Node root, int value){
    	if(root.data < value){
        	if(root.right != null){
        		Insert(root.right, value);
        	}
        	else{
        		Node node = createNode(value, null, null);
        		root.right = node;
        	}
        }
        else{
        	if(root.left != null){
        		Insert(root.left, value);
        	}
        	else{
        		Node node = createNode(value, null, null);
        		root.left = node;
        	}
        }
    }

	private static Node createNode(int value, Node root, Node root2) {
		Node n = new Node();
		n.data = value;
		return n;
	}
}
