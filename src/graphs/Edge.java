package graphs;

public class Edge {

	
	private Vertex node1;
	private Vertex node2;
	private int weight;
	
	public Edge(Vertex node1, int weight, Vertex node2){
		this.node1 = node1;
		this.node2 = node2;
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
