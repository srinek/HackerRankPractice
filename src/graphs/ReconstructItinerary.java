package graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */

//Eularian circuit. - starts and ends at the same node, while visiting all edges only once.
// A directed graph has Eularian circuit, if it is
// 1) All vertices with nonzero degree belong to a single strongly connected component.  - A directed graph is strongly connected if there is a path between any two pair of vertices.
// 2) In degree is equal to the out degree for every vertex..
// below algo is Hierholzer algo to find Eularian circuit
public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Node> nodeMap = new HashMap<>();
        for (List<String> ticket: tickets) {
            String src = ticket.get(0);
            Node sn = nodeMap.getOrDefault(src, new Node(src));
            nodeMap.put(src, sn);
            String tar = ticket.get(1);
            Node tn = nodeMap.getOrDefault(tar, new Node(tar));
            nodeMap.put(tar, tn);
            sn.adjList.offer(tn);
        }
        List<String> result = new ArrayList<>();
        dfs(nodeMap, nodeMap.get("JFK"), result);
        return result;
    }

    public void dfs(Map<String, Node> nodeMap, Node s, List<String> result) {
        Collections.sort(s.adjList);
        Queue<Node> q = s.adjList;
        while (!q.isEmpty()) {
            Node n = q.poll();
            dfs(nodeMap, n, result);
        }
        result.add(0, s.val);
    }

    public class Graph {
        public List<Node> nodes = new LinkedList<>();
    }

    public class Node implements Comparable {
        public LinkedList<Node> adjList = new LinkedList<>();
        public String val;
        public boolean visited;
        public Node(String val) {
            this.val = val;
        }

        public int compareTo(Object obj) {
            Node n1 = (Node)obj;
            return this.val.compareTo(n1.val);
        }
    }
}
