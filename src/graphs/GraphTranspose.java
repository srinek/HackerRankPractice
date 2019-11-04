package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphTranspose {

public static class Graph{
		
		int v = 0;
		int e = 0;
		int index = 0;
		List<Edge> edges = new ArrayList<>();
		List<Vertex> vertices = new ArrayList<>() ;
		
		public Graph(){
		}
		
		/*public void addNodes(int[] data){
			for(int i = 0; i < v; i++){
				Vertex n = new Vertex(data[i], i);
				vertices[i] = n;
			}
		}*/
		
		public void addEdge(Vertex node1, int weight, Vertex node2){
			Edge edge = new Edge(node1, weight, node2);
			edges.add(edge);
			node1.addEdge(edge);
		}
		
		public Vertex createVertex(int v1){
			Vertex n = new Vertex(v1, index++);
			vertices.add(n);
			return n;
		}
		
		public int getVertexCount(){
			return v;
		}

		public List<Vertex> getVertices() {
			return vertices;
		}
		
		public List<Edge> getEdges(){
			return this.edges;
		}
		
		public Vertex getVertex(int index){
			return vertices.get(index);
		}
		
		public void transpose(){
			
			for(Edge e : edges){
				System.out.println(e);
			}
			System.out.println();
			for(Edge e : this.edges){
				swapNodes(e);
			}
			for(Edge e : edges){
				System.out.println(e);
			}
		}
		
		public void swapNodes(Edge e){
			
			Vertex temp = e.node1;
			e.node1 = e.node2;
			e.node2 = temp;
		}
		
	}
	
	public static class Edge implements Comparable<Edge>{
		
		private int weight;
		private Vertex node1;
		private Vertex node2;
		
		public Edge(Vertex node1, int weight, Vertex node2) {
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

		public Vertex getNode1() {
			return node1;
		}

		public void setNode1(Vertex node1) {
			this.node1 = node1;
		}

		public Vertex getNode2() {
			return node2;
		}

		public void setNode2(Vertex node2) {
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
		
		@Override
		public int compareTo(Edge e) {
			if(this.getWeight() > e.weight){
				return 1;
			}
			if(this.getWeight() < e.weight){
				return -1;
			}
			return 0;
		}

	}
	
	public static class Vertex implements Comparable<Vertex>{
		
		private int data;
		private int index; // node index in Graph
		private boolean visited;
		private List<Vertex> adjList = new LinkedList<>();
		private List<Edge> edges = new ArrayList<>();
		
		public Vertex(int data, int index){
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
		public List<Vertex> getAdjList() {
			return adjList;
		}
		
		public void addEdge(Edge e){
			this.edges.add(e);
			this.adjList.add(e.node2);
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
		
		public List<Edge> getEdges(){
			return this.edges;
		}

		@Override
		public int compareTo(Vertex v) {
			if(this.index > v.index){
				return 1;
			}
			if(this.index < v.index){
				return -1;
			}
			return 0;
		}
	}
		
	
	public static void main(String[] args) {
		
		Graph g = new Graph();
		Vertex v0 = g.createVertex(2);
		Vertex v1 = g.createVertex(3);
		Vertex v2 = g.createVertex(4);
		Vertex v3 = g.createVertex(5);
		Vertex v4 = g.createVertex(6);
		g.addEdge(v0, 0, v1);
		g.addEdge(v1, 0, v2);
		g.addEdge(v1, 0, v3);
		g.addEdge(v1, 0, v4);
		g.addEdge(v4, 0, v0);
		g.addEdge(v3, 0, v2);
		g.addEdge(v3, 0, v4);
		g.transpose();
	}
   
	
}
