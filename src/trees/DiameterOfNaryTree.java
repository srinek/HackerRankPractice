package trees;

import java.util.*;

/**
 * https://leetcode.com/problems/diameter-of-n-ary-tree/solution/
 *
 * Given a root of an N-ary tree, you need to compute the length of the diameter of the tree.
 *
 * The diameter of an N-ary tree is the length of the longest path between any two nodes in the tree. This path may or may not pass through the root.
 *
 * (Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * Explanation: Diameter is shown in red color.
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,null,3,4,null,5,null,6]
 * Output: 4
 * Example 3:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 7
 *
 *
 * Constraints:
 *
 * The depth of the n-ary tree is less than or equal to 1000.
 * The total number of nodes is between [1, 104].
 */
public class DiameterOfNaryTree {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    int max = 0;
    public int diameter(Node root) {
        helper(root);
        return max;
    }

    private int helper(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        pq.add(0);
        for (Node child: root.children) {
            int h = helper(child);
            // System.out.println(root.val +" "+h);
            pq.add(h);
        }
        int h1 = pq.poll();
        int h2 = pq.poll();
        max = Math.max(max, h1 + h2);
        return 1 + h1;
    }
}
