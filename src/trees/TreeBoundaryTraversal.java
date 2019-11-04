package trees;

public class TreeBoundaryTraversal {

	static class Node {
		String data;
		Node left;
		Node right;
		boolean visited = false;
		
		public Node(String data){
			this.data = data;
		}
		
		@Override
		public  String toString() {
			StringBuilder str = new StringBuilder();
			str.append("data ");
			str.append(this.data);
			if(this.left != null){
				str.append(", left = ");
				str.append(this.left.data);
			}
			if(this.right != null){
				str.append(", right = ");
				str.append(this.right.data);
			}
			return str.toString();
		}
	}
	
	static class TreeFactory {
		
		public static Node createTree(String[] data){
			
			Node root = null;
			Node[] nodeList = new Node[data.length];
			int i = 0;
			for(String nodeData : data){
				if(i == 0){
					root = nodeList[i] = new Node(nodeData);
				}
				else{
					if(nodeData != null){
						Node parent = nodeList[(i-1)/2];
						nodeList[i] = new Node(nodeData);
						if(parent.left == null){
							parent.left = nodeList[i];
						}
						else if(parent.right == null){
							parent.right = nodeList[i];
						}
					}
				}
				i++;
			}
			
			return root;
		}
	}
	
	public static void main(String[] args) {
		//Node root = TreeFactory.createTree(new String[]{"n1", "n2", "n3", "n4", "n5", "n6", "n7", "n8"});
		Node root = TreeFactory.createTree(new String[]{"20", "8", "22", "4", "12", null, "25", null, null, "10", "14"});
		TreeBoundaryTraversal traversal = new TreeBoundaryTraversal();
		traversal.treeBorderTraversal(root);
	}
	
	public void treeBorderTraversal(Node root){
		traverseRoot(root);
		traverseLeft(root.left);
		travserseRight(root.right);
	}

	private void travserseRight(Node rightNode) {
		if(rightNode != null){
			printData(rightNode);
			traverseLeft(rightNode.right);
			if(rightNode.right == null){
				traverseLeft(rightNode.left);
			}
			traverseLeaves(rightNode.left);
		}
		
	}

	private void traverseLeft(Node leftNode) {
		
		if(leftNode != null){
			printData(leftNode);
			traverseLeft(leftNode.left);
			if(leftNode.left == null){
				traverseLeft(leftNode.right);
			}
			traverseLeaves(leftNode.right);
		}
		
	}

	private void traverseLeaves(Node node) {
		if(node != null){
			if(node.left == null && node.right == null){
				printData(node);
			}
			else{
				traverseLeaves(node.left);
				traverseLeaves(node.right);	
			}
		}
		
	}

	private void traverseRoot(Node root) {
		
		if(root != null){
			printData(root);
		}
		
	}
	
	private void printData(Node root){
		if(!root.visited){
			System.out.println(root.data +"  ");
			root.visited = true;
		}
	}
}
