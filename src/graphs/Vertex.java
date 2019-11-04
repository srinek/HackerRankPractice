package graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

	private T data;
	private int index;
	private List<Vertex<T>> adjList = new ArrayList<>();
	private int inDegree;
	private int outDegree;
	private boolean visited = false;
	
	public Vertex(T data, int index){
		this.data = data;
		this.index = index;
	}
	
	public void addAdjList(Vertex<T> node){
		this.adjList.add(node);
	}
	
	public void bumpInDegree(){
		this.inDegree++;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public List<Vertex<T>> getAdjList() {
		return adjList;
	}

	public void setAdjList(List<Vertex<T>> adjList) {
		this.adjList = adjList;
	}

	public int getInDegree() {
		return inDegree;
	}

	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}

	public int getOutDegree() {
		return this.adjList.size();
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	@Override
	public String toString() {
		
		return this.data +" "+this.index +" "+this.isVisited();
	}
	
}
