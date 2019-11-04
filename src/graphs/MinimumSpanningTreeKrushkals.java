package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MinimumSpanningTreeKrushkals {

	public static class Graph{
		
		int v = 0;
		int e = 0;
		List<Edge> edges = new ArrayList<>();
		Node[] vertices;
		
		public Graph(int v){
			this.v = v;
			vertices = new Node[v];
		}
		
		public void addNodes(int[] data){
			for(int i = 0; i < v; i++){
				Node n = new Node(data[i], i);
				vertices[i] = n;
			}
		}
		
		public void addEdge(int node1, int weight, int node2){
			Edge edge = new Edge(vertices[node1], weight, vertices[node2] );
			edges.add(edge);
		    vertices[node1].addEdge(vertices[node2]);
		    vertices[node2].addEdge(vertices[node1]);
		}
		
		public int getVertexCount(){
			return v;
		}

		public Node[] getVertices() {
			return vertices;
		}
		
		public List<Edge> getEdges(){
			return this.edges;
		}
		
		public Node getVertex(int index){
			return vertices[index];
		}
		
	}
	
	public static class EdgeComparator implements Comparator<Edge>{

		@Override
		public int compare(Edge o1, Edge o2) {
			if(o1.getWeight() > o2.weight){
				return 1;
			}
			if(o1.getWeight() < o2.weight){
				return -1;
			}
			return 0;
		}
		
	}
	
	public static class Edge{
		
		private int weight;
		private Node node1;
		private Node node2;
		
		public Edge(Node node1, int weight, Node node2) {
			super();
			this.weight = weight;
			this.node1 = node1;
			this.node2 = node2;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public Node getNode1() {
			return node1;
		}

		public void setNode1(Node node1) {
			this.node1 = node1;
		}

		public Node getNode2() {
			return node2;
		}

		public void setNode2(Node node2) {
			this.node2 = node2;
		}
		
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			str.append("[");
			str.append(node1.getData());
			str.append(" , ");
			str.append(weight);
			str.append(" , ");
			str.append(node2.getData());
			str.append("]");
			return str.toString();
		}

	}
	
	public static class Node{
		
		private int data;
		private int index; // node index in Graph
		private boolean visited;
		private List<Node> adjList = new LinkedList<>();
		
		public Node(int data, int index){
			this.data = data;
			this.index = index;
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

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}
		
    // find parent(rep) for the set
	private static Node findParent(Node[] parent, int i){
		
		if(parent[i].getIndex() == i){
			return parent[i];
		}
		Node result = null;
		result = findParent(parent, parent[i].getIndex());
		parent[i] = result;
		return result;
	}
	
	private static void union(Node[] parent, int[] rank, int i, int j){
		
		Node iRep = findParent(parent, i);
		Node jRep = findParent(parent, j);
		
		if(iRep == jRep){
			return; // same set. no merge needed
		}
		// not equal , get the ranks
		int iRank = rank[iRep.getIndex()];
		int jRank = rank[jRep.getIndex()];
		if(iRank > jRank){
			parent[jRep.getIndex()] = iRep;
		}
		else if(iRank < jRank){
			parent[iRep.getIndex()] = jRep;
		}
		else{
			parent[jRep.getIndex()] = iRep;
			rank[iRep.getIndex()]++;
		}
	}
	
	public static void main(String[] args){
		/*Graph g= new Graph(9);
		g.addNodes(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
		g.addEdge(0, 4, 1);
		g.addEdge(0, 8, 7);
		g.addEdge(1, 8, 2);
		g.addEdge(1, 11, 7);
		g.addEdge(7, 7, 8);
		g.addEdge(7, 1, 6);
		g.addEdge(2, 7, 3);
		g.addEdge(2, 2, 8);
		g.addEdge(2, 4, 5);
		g.addEdge(8, 6, 6);
		g.addEdge(6, 2, 5);
		g.addEdge(5, 10, 4);
		g.addEdge(3, 9, 4);
		g.addEdge(3, 14, 5);*/
		Graph g= new Graph(5);
		g.addNodes(new int[]{2,8,5,6,4});
		g.addEdge(0, 2, 1);
		g.addEdge(0, 4, 2);
		g.addEdge(1, 6, 3);
		g.addEdge(3, 2, 2);
		g.addEdge(2, 10, 4);
		
		List<Edge> mstEdges = new ArrayList<>();
		List<Edge> edges = g.getEdges();
		Collections.sort(edges, new EdgeComparator());
		Node[] parent = new Node[g.v];
		for(int i = 0; i < g.v; i++){
			parent[i] = g.getVertex(i); //initialize to itself
		}
		int[] rank = new int[g.v];
		Arrays.fill(rank, 1);
		for(int i = 0; i < edges.size(); i++){
			if(mstEdges.size() >= g.v ){
				break;
			}
			Node node1 = edges.get(i).getNode1();
			Node node2 = edges.get(i).getNode2();
			// check if the mstedges form a circle.
			if(findParent(parent, node1.getIndex()) == findParent(parent, node2.getIndex())){
				//circle
				continue;
			}
			union(parent, rank, node1.getIndex(), node2.getIndex());
			
			mstEdges.add(edges.get(i));
		}
		System.out.println(mstEdges);
	}
}
