package graphs;

import java.util.Scanner;

/*
 * https://leetcode.com/problems/graph-valid-tree/
 * 
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 */
public class GraphValid {
	
	public static void main(String[] args) {
		
		GraphValid graphValid = new GraphValid();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int n1 = scanner.nextInt();
		int[][] edges = new int[n1][2];
		for(int i=0; i<n1; i++){
			edges[i][0] =  scanner.nextInt();
			edges[i][1] =  scanner.nextInt();
		}
		scanner.close();
		System.out.println(graphValid.validTree(n, edges));
	}

	public boolean validTree(int n, int[][] edges) {
		
		Graph g = new Graph(n);
		
		for(int i=0; i<edges.length; i++){
				Node n1 = g.getNode(edges[i][0]);
				Node n2 = g.getNode(edges[i][1]);
				boolean result = g.union(n1, n2);
				if(!result){
					return false;
				}
		}
		if(!g.dfsTree()){
			return false;
		}
		return true;
	}
	
	private static class Graph{
		
		Node[] nodes = null;
		
		public Graph(int n){
			this.nodes = new Node[n];
			for(int i=0; i<n; i++){
				nodes[i] = new Node(i);
			}
		}
		
		public boolean dfsTree() {
			if(nodes == null || nodes.length == 0){
				return false;
			}
			Node parent = find(nodes[0]);
			for(int i=1; i<this.nodes.length; i++){
				if(parent != find(nodes[i])){
					return false;
				}
			}
			return true;
		}

		public Node getNode(int index){
			return this.nodes[index];
		}
		
		// merges nodes by rank
		public boolean union(Node n1, Node n2){
		   	
			if(n1 == null || n2 == null){
				return true; // couldn't be in same set
			}
			
			
			Node n1Parent = this.find(n1);
			Node n2Parent = this.find(n2);
			
			if(n1Parent == n2Parent){ //same set
				return false;
			}
			
			int n1Rank = n1Parent.rank;
			int n2Rank = n2Parent.rank;
			
			
			if(n1Rank >= n2Rank){
				n2Parent.parent = n1Parent.parent;
				n1Parent.rank++;
			}
			else{
				n1Parent.parent = n2Parent.parent;
				n2Parent.rank++;
			}
			
			return true;
		}
		
		// returns parent
		public Node find(Node n){
			
			Node parent = n.parent;
			if(parent == n){
				return parent;
			}
			parent = find(parent);
			//path compression
			n.parent = parent;
			return parent;
		}
		
	}
	
	private static class Node{
		
		public int data;
		public Node parent;
		public int rank = 0;
		
		
		public Node(int data){
			this.data = data;
			this.parent = this; // by default, parent is self
		}
	}
}
