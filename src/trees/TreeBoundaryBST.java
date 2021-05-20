package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBoundaryBST {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, false));
        q.offer(null);
        Pair prev = null;
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {

            Pair cur = q.poll();
            if(cur == null) {
                if(prev != null) {
                    result.add(prev.node.val);
                    q.offer(null);
                }
                prev = cur;
                continue;
            }
            if(cur.node.left != null) {
                q.offer(new Pair(cur.node.left, isLeaf(cur.node.left)));
            }
            if(cur.node.right != null) {
                q.offer(new Pair(cur.node.right, isLeaf(cur.node.right)));
            }
            if (cur.leaf) {
                result.add(cur.node.val);
            }
            if (prev == null) {
                result.add(cur.node.val);
            }
            prev = cur;
        }
        return result;
    }

    private Boolean isLeaf(final TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    private class Pair {
        public TreeNode node;
        public boolean leaf;
        public Pair(TreeNode node, Boolean leaf) {
            this.node = node;
            this.leaf = leaf;
        }
    }
}
