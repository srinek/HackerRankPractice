package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 *
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections
 * forming a network where connections[i] = [a, b] represents a connection between servers a and b.
 * Any server can reach any other server directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 */
public class CriticalConnectionsInaNetwork {

    private static class Vertex {
        public int data;
        public int low = -1;
        public int visited = -1;
        public List<Vertex> adj;
        public Vertex(int data) {
            this.data = data;
            this.adj = new ArrayList<>();
        }
    }

    private static class Graph {
        public final List<Vertex> vertices;
        public Graph(final int nodes) {
            vertices = new ArrayList<>(nodes);
            for (int i=0; i<nodes; i++) {
                vertices.add(new Vertex(i));
            }
        }

        public void addEdge(final int from, final int to) {
            Vertex fromV = vertices.get(from);
            Vertex toV = vertices.get(to);
            fromV.adj.add(toV);
            toV.adj.add(fromV);
        }
    }

    private int time = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        final Graph g = new Graph(n);
        for (List<Integer> con: connections) {
            g.addEdge(con.get(0), con.get(1));
        }
        final List<List<Integer>> result = new ArrayList<>();
        dfs(g.vertices.get(0), null, result);
        return result;
    }


    private void dfs(final Vertex current, final Vertex prev, List<List<Integer>> result) {
        current.visited = current.low = time;
        time++;
        for (final Vertex v: current.adj) {
            if (v == prev) {
                continue;
            }
            if (v.visited == -1) {
                dfs(v, current, result);
                current.low = Math.min(v.low, current.low);
                if (v.low > current.visited) {
                    result.add(List.of(current.data, v.data));
                }
            } else {
                current.low = Math.min(v.low, current.low);
            }
        }
    }

    public static void main(String[] args) {
        final var i = new CriticalConnectionsInaNetwork();
        System.out.println(i.criticalConnections(4, List.of(List.of(0,1), List.of(1,2), List.of(2,0), List.of(1,3))));
    }
}
