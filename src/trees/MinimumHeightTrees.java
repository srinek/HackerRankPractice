package trees;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 *
 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
 *
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
 *
 * Return a list of all MHTs' root labels. You can return the answer in any order.
 *
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]]
 * Output: [1]
 * Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 * Example 2:
 *
 *
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * Output: [3,4]
 * Example 3:
 *
 * Input: n = 1, edges = []
 * Output: [0]
 * Example 4:
 *
 * Input: n = 2, edges = [[0,1]]
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * All the pairs (ai, bi) are distinct.
 * The given input is guaranteed to be a tree and there will be no repeated edges.
 */
public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        Graph g = new Graph(n);
        for(int[] edge: edges) {
            g.addEdge(edge);
        }
        LinkedList<Node> leaves = new LinkedList<>();
        for (Node node: g.nodes) {
            if (node.isLeaf()) {
                leaves.offer(node);
            }
        }
        while(n > 2) {
            n = n - leaves.size();
            Set<Node> nLeaves = new HashSet<>();
            while (!leaves.isEmpty()) {
                Node leaf = leaves.poll();
                nLeaves.addAll(g.remove(leaf.val));
            }
            leaves.addAll(nLeaves);
        }

        List<Integer> result = new ArrayList<>();
        for (Node leaf: leaves) {
            result.add(leaf.val);
        }
        return result;
    }

    public static class Graph {

        public List<Node> nodes = new ArrayList<>();
        public Graph(int n) {
            for(int i=0; i<n; i++) {
                nodes.add(new Node(i));
            }
        }

        public void addEdge(int[] e) {
            nodes.get(e[0]).adj.add(nodes.get(e[1]));
            nodes.get(e[1]).adj.add(nodes.get(e[0]));
            nodes.get(e[0]).degree++;
            nodes.get(e[1]).degree++;
        }

        public List<Node> remove(int nodeIndex) {
            Node temp = nodes.get(nodeIndex);
            List<Node> nLeaves = new ArrayList<>();
            for(Node n: temp.adj) {
                n.degree--;
                if(n.isLeaf()) {
                    nLeaves.add(n);
                }
                n.adj.remove(temp);
            }
            return nLeaves;
        }
    }

    public static class Node {
        public int val;
        public Set<Node> adj = new HashSet<>();
        public int degree;

        public Node(int val) {
            this.val = val;
        }

        public boolean isLeaf() {
            if (degree <= 1) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MinimumHeightTrees i = new MinimumHeightTrees();
        /*System.out.println(i.findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}));
        System.out.println(i.findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
        System.out.println(i.findMinHeightTrees(1, new int[][]{}));
        System.out.println(i.findMinHeightTrees(2, new int[][]{{0,1}}));
        System.out.println(i.findMinHeightTrees(3, new int[][]{{0,1}, {0,2}}));
        System.out.println(i.findMinHeightTrees(3, new int[][]{{0,1}, {0,2}}));*/
        System.out.println(i.findMinHeightTrees(6, new int[][]{{0,1}, {0,2}, {0,3}, {3,4}, {4,5}}));
    }
}
