package trees;

import java.util.HashMap;
import java.util.Map;

public class VerticalSumOfBinaryTree {

	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	private static void printVericalSum(Node root, int columIndex, Map<Integer, Integer> map) {
		if (root == null) {
			return;
		}
		int sum = map.get(columIndex) != null ? map.get(columIndex) + root.data : root.data;
		map.put(columIndex, sum);
		printVericalSum(root.left, columIndex-1, map);
		printVericalSum(root.right, columIndex+1, map);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.setLeft(new Node(2));
		root.setRight(new Node(3));
		root.getLeft().setLeft(new Node(4));
		root.getLeft().setRight(new Node(5));
		root.getRight().setLeft(new Node(6));
		root.getRight().setRight(new Node(7));
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		printVericalSum(root, 0, map);
		System.out.println(map);
	}
}
