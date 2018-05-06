package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	public static class Graph {

		int v = 0;
		Node[] vertices;

		public Graph(int v) {
			this.v = v;
			vertices = new Node[v];
		}

		public void addDefaultNodes() {
			for (int i = 0; i < v; i++) {
				Node n = new Node(i);
				vertices[i] = n;
			}
		}

		public void addEdge(int node1, int node2) {
			vertices[node1].addEdge(vertices[node2]);
		}

		public int getVertexCount() {
			return v;
		}

		public Node[] getVertices() {
			return vertices;
		}

	}

	public static class Node {

		private int data;
		private boolean visited;
		private List<Node> adjList = new LinkedList<>();

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public List<Node> getAdjList() {
			return adjList;
		}

		public void addEdge(Node node) {
			this.adjList.add(node);
		}
	}
	
	public static void sortUtil(Node v, Stack<Node> stack){
		v.setVisited(true);
		List<Node> nodes = v.getAdjList();
		for(Node node : nodes){
			if(!node.isVisited()){
				sortUtil(node, stack);
			}
		}
		stack.push(v);
		
	}

	private static void sort(Graph g) {
		
		Stack<Node> stack = new Stack<>();
		Node[] vertices = g.getVertices();
		
		for(Node v: vertices){
			if(!v.isVisited()){
				sortUtil(v, stack);
			}
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getData() +" ");
		}
	}

	public static void main(String[] args) {
		TopologicalSort traversal = new TopologicalSort();
		Graph g = new Graph(6);
		g.addDefaultNodes();
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(5, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(4, 1);
		traversal.sort(g);
	}
}
