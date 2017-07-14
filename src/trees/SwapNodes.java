package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwapNodes {
	
	static class Node{
		
		int data;
		int height;
		Node left;
		Node right;
		
		public Node(int data, int height){
			this.data = data;
			this.height = height;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int nodes = scan.nextInt();
		int index = 0;
		Node root = new Node(1, 1);
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		Node temp = null;
		while(index++ < nodes){
			temp = q.poll();
			int left = scan.nextInt();
			if(left != -1){
				Node lNode = new Node(left, temp.height+1);
				temp.left = lNode;
				q.offer(lNode);
			}
			int right = scan.nextInt();
			if(right != -1){
				Node rNode = new Node(right, temp.height+1);
				temp.right = rNode;
				q.offer(rNode);
			}
		}
		int tests = scan.nextInt();
		index = 0;
		q.clear();
		q.offer(root);
		while(index++ < tests){
			int k = scan.nextInt();
			swapNodes(root, k, q);
			inOrder(root);
			q.offer(root);
			System.out.println();
		}
		scan.close();
    }

	private static void inOrder(Node root) {
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
		
	}

	private static void swapNodes(Node root, int k, Queue<Node> q) {
		
		int index = 1;
		while(!q.isEmpty()){
			Node node = q.poll();
			if(node.height % k == 0){
				swap(node);
				//k = ++index * k;
			}
			if(node.left != null){
				q.offer(node.left);
			}
			if(node.right != null){
				q.offer(node.right);
			}
		}
	}

	private static void swap(Node node) {
		
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		
	}

}
