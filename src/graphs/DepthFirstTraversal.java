package graphs;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstTraversal {

	public static class Graph{
		
		int v = 0;
		Node[] vertices;
		public Graph(int v){
			this.v = v;
			vertices = new Node[v];
		}
		
		public void addDefaultNodes(){
			for(int i = 0; i < v; i++){
				Node n = new Node(i);
				vertices[i] = n;
			}
		}
		
		public void addEdge(int node1, int node2){
			vertices[node1].addEdge(vertices[node2]);
		}
		
		public int getVertexCount(){
			return v;
		}

		public Node[] getVertices() {
			return vertices;
		}
		
	}
	
	public static class Node{
		
		private int data;
		private boolean visited;
		private List<Node> adjList = new LinkedList<>();
		
		public Node(int data){
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
		public void addEdge(Node node){
			this.adjList.add(node);
		}
	}
	
	public void dfsUtil(Node vertex){
		vertex.setVisited(true);
		System.out.print(vertex.getData() +" ");
		List<Node> adjList = vertex.getAdjList();
		for(Node n : adjList){
			if(!n.isVisited()){
				dfsUtil(n);
			}
		}
	}
	
	public void dfs(Graph g){
		if(g  == null){
			return;
		}
		Node[] vertices = g.getVertices();
		for(Node n : vertices){
			if(!n.isVisited()){
				dfsUtil(n);
			}
		}
	}
	
	public static void main(String[] args){
		DepthFirstTraversal traversal = new DepthFirstTraversal();
		Graph g= new Graph(4);
		g.addDefaultNodes();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		traversal.dfs(g);
	}
}
