package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreePrims {

	public static class Graph{
		
		int v = 0;
		int e = 0;
		int index = 0;
		List<Edge> edges = new ArrayList<>();
		List<Vertex> vertices = new ArrayList<>() ;
		
		public Graph(int v){
			this.v = v;
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
		
		public List<Edge> findMST(){
			
			List<Edge> mstEdges = new ArrayList<>();
			if(this.vertices == null || this.vertices.size() == 0){
				return mstEdges;
			}
			List<Vertex> visited = new ArrayList<>();
			PriorityQueue<Vertex> heap = new PriorityQueue<>();
			heap.add(this.vertices.get(0));
			Vertex parent = null;
			while(!heap.isEmpty() && visited.size() <= this.vertices.size()-1){
			    Vertex v =	heap.poll();
			    Edge mstEdge = v.getKeyConnectedEdge();
			    if(mstEdge != null){
			    	mstEdges.add(mstEdge);
			    }
			    parent = v;
			    visited.add(v);
			    List<Vertex> adjNodes = v.getAdjList();
			    for(Vertex adjNode : adjNodes){
			    	if(visited.contains(adjNode)){
			    		continue;
			    	}
			    	Edge connectedEdge = findEdge(parent, adjNode);
			    	adjNode.setKey(connectedEdge.getWeight());
			    	adjNode.setKeyConnectedEdge(connectedEdge);
			    	heap.add(adjNode);
			    }
			}
			
			return mstEdges;
			
		}

		private Edge findEdge(Vertex node1, Vertex node2) {
			if(node1 == node2){  // same node
				return null;
			}
			for(Edge eachEdge : this.edges){
				if(eachEdge.node1.equals(node1) && node2.equals(eachEdge.node2)){
					return eachEdge;
				}
			}
			return null;
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
		private int key = 0;
		private Edge keyConnectedEdge = null; // edge corresponds to the key
		
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
		
		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public Edge getKeyConnectedEdge() {
			return keyConnectedEdge;
		}

		public void setKeyConnectedEdge(Edge keyConnectedEdge) {
			this.keyConnectedEdge = keyConnectedEdge;
		}

		@Override
		public int compareTo(Vertex v) {
			if(this.key > v.key){
				return 1;
			}
			if(this.key < v.key){
				return -1;
			}
			return 0;
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
		//g.addNodes(new int[]{2,8,5,6,4});
		Vertex v1 = g.createVertex(2);
		Vertex v2 = g.createVertex(8);
		Vertex v3 = g.createVertex(5);
		Vertex v4 = g.createVertex(6);
		Vertex v5 = g.createVertex(4);
		Vertex v6 = g.createVertex(7);
		g.addEdge(v1, 2, v2);
		g.addEdge(v1, 4, v3);
		g.addEdge(v2, 6, v4);
		g.addEdge(v3, 2, v5);
		g.addEdge(v4, 10, v6);
		g.addEdge(v5, 12, v6);
		
		List<Edge> edges = g.getEdges();
		
		List<Edge> mstEdges = g.findMST();
		
		System.out.println(mstEdges);
	}
}
