package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {
   
	public class Graph{
		
		int totalNodes = 0;
		private Node[] nodes = null;
		
		public Graph(int n){
			this.totalNodes = n;
			this.nodes = new Node[n];
			initialize();
		}
		
		private void initialize(){
			for(int i = 0; i < totalNodes; i++){
				nodes[i] = new Node(i);
			}
		}
		public void addEdge(int i, int j){
			if(i < 0 || i >= totalNodes){
				return;
			}
			if(j < 0 || j >= totalNodes){
				return;
			}
			nodes[i].addChild(nodes[j]);
		}
		
		public Node[] getNodes(){
			return this.nodes;
		}
		
		public Node getNode(int index){
			return this.nodes[index];
		}

		public Graph tranpose() {
			Graph _g = new Graph(this.totalNodes);
			for(Node node : nodes){
				List<Node> children = node.getChildren();
				for(Node child : children){
					_g.addEdge(child.getData(), node.getData());
				}
			}
			return _g;
		}
	}
	
	public class Node{
		
		private int data = 0;
		private boolean visited = false; 
		private List<Node> children = new ArrayList<>();

		public Node(int i) {
			this.data = i;
		}
		
		public void addChild(Node child){
			this.children.add(child);
		}
		
		public List<Node> getChildren(){
			return this.children;
		}
		
		public int getData(){
			return this.data;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}
	}
	
	public static void main(String[] args) {
		StronglyConnectedComponents scc = new StronglyConnectedComponents();
		scc.countSCCOfGraph();
	}
	
	public void countSCCOfGraph(){
		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		Stack<Node> s = new Stack<>();
		dfs(g, s);
		Graph _g = g.tranpose();
		
		countSCC(_g, s);
	}

	private void countSCC(Graph _g, Stack<Node> s) {
		
		while(!s.isEmpty()){
			Node node = _g.getNode(s.pop().getData());
			if(node.isVisited()){
				continue;
			}
			_countSCC(node);
			System.out.println();
		}
		
	}
	
	private void _countSCC(Node node){
		node.setVisited(true);
		System.out.print(node.getData()+" ");
		for(Node n : node.getChildren()){
			if(n.isVisited()){
				continue;
			}
			_countSCC(n);
		}
	}

	private void dfs(Graph g, Stack<Node> s) {
		Node[] nodes = g.getNodes();
		for(Node node : nodes){
			if(node.isVisited()){
				continue;
			}
			_dfs(node, s);
		}
	}

	private void _dfs(Node node, Stack<Node> s) {
		node.setVisited(true);
		//System.out.println(node.getData());
		List<Node> children = node.getChildren();
		for(Node child : children){
			if(child.isVisited()){
				continue;
			}
			_dfs(child,  s);
		}
		s.push(node);
	}
}
