package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeFromLevelOrderTraversal {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val) {
            this.val = val;
        }
    }
// 8,5,11,null,null,10,12,7,null
    public Node makeTree(Integer[] data) {

        if (data.length == 0) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(data[0]);
        q.offer(root);
        boolean left = true;
        Node cur = null;
        for (int i=1; i<data.length; i++) {
            Node temp = null;
            if (data[i] != null) {
                temp = new Node(data[i]);
                q.offer(temp);
            }
            if (left) {
                cur = q.poll();
                cur.left = temp;
                left = false;
            } else {
                cur.right = temp;
                left = true;
            }
        }
        return root;
    }

    public boolean isBST(Node root) {
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeFromLevelOrderTraversal i = new BinaryTreeFromLevelOrderTraversal();
        System.out.println(i.makeTree(new Integer[] {8,5,11,null,null,10,12,7,null}));
    }
}
