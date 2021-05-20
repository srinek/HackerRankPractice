package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph<T> {


	private List<Vertex<T>> vertexList = new ArrayList<>();
	private List<Edge> edges = new ArrayList<>();
	
	private int index = 0;
	
	
	public List<Vertex<T>> getVertexList() {
		return vertexList;
	}

	public void setVertexList(List<Vertex<T>> vertexList) {
		this.vertexList = vertexList;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public Graph(){
		
	}
	
	public Vertex<T> createVertex(T data){
		
		for(Vertex<T> ev : this.vertexList){
			if(ev.getData().equals(data)){
				return ev;
			}
		}
		Vertex<T> v = new Vertex<T>(data, index++);
		this.vertexList.add(v);
		return v;
	}
	
	public void createVertices(T[] data){
		for(T d : data){
			Vertex<T> v = new Vertex<T>(d, index++);
			this.vertexList.add(v);
		}
	}
	
	public void addEdge(Vertex<T> v1, int weight, Vertex<T> v2){
		Edge e = new Edge(v1, weight, v2);
		edges.add(e);
		v1.addAdjList(v2);
		v2.bumpInDegree();
	}
	
	public void addEdge(int index1, int weight, int index2){
		Vertex v1 = this.vertexList.get(index1);
		Vertex v2 = this.vertexList.get(index2);
		this.addEdge(v1, weight, v2);
	}
	
	// dfs for strongly connected component (SCC)
	public void dfs(Stack<Vertex<T>> s){
		if(s == null ){
			return;
		}
		for(Vertex<T> v : this.vertexList){
			if(!v.isVisited()){
				dfsUtil(v, s);
			}
			break; // break after first vertex
		}
	}
	
	public void dfs(){
		for(Vertex<T> v : this.vertexList){
			if(!v.isVisited()){
				dfsUtil(v, null);
			}
			break; // break after first vertex
		}
	}
	
	private void dfsUtil(Vertex<T> v, Stack<Vertex<T>> s){
		v.setVisited(true);
		List<Vertex<T>> adjList = v.getAdjList();
		for(Vertex<T> adj : adjList){
			if(!adj.isVisited()){
				dfsUtil(adj, s);
			}
		}
		if(s != null){
			s.push(v);
		}
	}

	/**
	 * https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
	 * @return
	 */
	public boolean isStronglyConnected(){
		Stack<Vertex<T>> s = new Stack<>();
		this.dfs(s);
		//check if this is a forest ?
		for(Vertex<T> v : this.vertexList){
			if(!v.isVisited()){
				return false;
			}
		}
		Graph<T> _g = transpose();
		_g.dfs();
		for(Vertex<T> v : _g.getVertexList()){
			if(!v.isVisited()){
				return false;
			}
		}
		return true;
	}

	private Graph<T> transpose() {
		Graph<T> _g = new Graph<>();
		for(Vertex<T> v : this.vertexList){
			_g.createVertex(v.getData());
		}
		for(Edge e : edges){
			_g.addEdge(e.getNode2().getIndex(), e.getWeight(), e.getNode1().getIndex());
		}
		return _g;
	}

	@Override
	public String toString() {
		String str = "";
		for(Edge e : this.edges){
			str += "["+e.getNode1() +"---->"+e.getNode2()+"]";
		}
		return str;
	}
	
	
}
