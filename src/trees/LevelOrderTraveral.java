package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraveral {

	class Node {
		int data;
		Node left;
		Node right;
	}

	void levelOrder(Node root) {
		
		if(root == null){
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			root = q.poll();
			if(root != null){
				System.out.print(root.data +" ");
				q.offer(root.left);
				q.offer(root.right);
			}
		}
	}

}
