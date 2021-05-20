package graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/redundant-connection/
 *
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 */
public class RedundantConnection {

    public static class Graph {
        final List<Node> nodes;
        public Graph(int n) {
            nodes = new ArrayList(n);
            for(int i=0; i<n; i++) {
                Node node = new Node(i+1);
                nodes.add(node);
            }
        }

        public void addEdge(int from , int to) {
            nodes.get(from-1).adj.add(nodes.get(to-1));
            nodes.get(to-1).adj.add(nodes.get(from-1));
        }

    }

    public static class Node {

        public int visited;
        public int low;
        public int data;
        public List<Node> adj = new ArrayList<>();
        public Node(int n) {
            data = n;
        }
    }

    public static class Pair {
        public int l;
        public int r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair)o;
            if(p.l == l && p.r == r) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return l * r;
        }
    }

    public int timer = 1;
    public int resultIndex = Integer.MIN_VALUE;

    public int[] findRedundantConnection(int[][] edges) {

        Graph g = new Graph(edges.length);
        Map<Pair, Integer> map = new HashMap<>();
        int i = 0;
        for(int[] e: edges) {
            g.addEdge(e[0], e[1]);
            map.put(new Pair(e[0], e[1]), i++);
        }
        dfs(g.nodes.get(0), null, map);
        return edges[resultIndex];
    }

    public void dfs(final Node n, final Node p, Map<Pair, Integer> map) {
        n.visited = n.low = timer++;
        List<Node> adj = n.adj;
        for(Node a: adj) {
            if( a == p) {
                continue;
            }
            if(a.visited == 0) {
                dfs(a, n, map);
                n.low = Math.min(a.low, n.low);
            } else {
                n.low = Math.min(a.low, n.low);
            }
            if(a.low <= n.visited) {
                if(map.containsKey(new Pair(a.data, n.data))) {
                    resultIndex = Math.max(map.get(new Pair(a.data, n.data)), resultIndex);
                } else if (map.containsKey(new Pair(n.data, a.data))) {
                    resultIndex = Math.max(map.get(new Pair(n.data, a.data)), resultIndex);
                }
            }
        }

    }

    public static void main(String[] args) {
        RedundantConnection i = new RedundantConnection();
        System.out.println(Arrays.toString(i.findRedundantConnection(new int[][]{{1,2}, {1,3}, {2,3}})));
        System.out.println(Arrays.toString(i.findRedundantConnection(new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}})));
    }
}
