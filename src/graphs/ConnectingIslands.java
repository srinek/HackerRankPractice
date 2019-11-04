package graphs;

import java.util.Scanner;

/*
 * https://www.codechef.com/problems/CD1IT5
 */
public class ConnectingIslands {

	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int q = s.nextInt();
		ConnectingIslands cis = new ConnectingIslands();
		DisjointSet ds = cis.new DisjointSet(n);
		for(int i=0; i<q; i++){
		   int t = s.nextInt();
		   if(t == 0){
			   ds.union(ds.getNode(s.nextInt()-1), ds.getNode(s.nextInt()-1));
		   }
		   if(t == 1){
			  if( ds.find(ds.getNode(s.nextInt()-1)).getData() == ds.find(ds.getNode(s.nextInt()-1)).getData()){
				  System.out.println("Yes");
			  }
			  else{
				  System.out.println("No");
			  }
		   }
		}
		s.close();
		
	}
	
	private class Node{
		public int data = 0;
		public int rank = 0;
		public Node parent = null;
		
		public Node(int data){
			this.data = data;
			this.parent = this; // by default parent is itself
		}

		public int getData() {
			return data;
		}

		public int getRank() {
			return rank;
		}

		public Node getParent() {
			return parent;
		}

		public void setData(int data) {
			this.data = data;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}
		
	}
	class DisjointSet {
		
		Node[] nodes = null;
		
		public DisjointSet(int n){
			nodes = new Node[n];
			initialize();
		}
		
		private void initialize() {
			for(int i = 0; i <nodes.length; i++){
				nodes[i] = new Node(i);  
			}
		}
		
		public Node[] getNodes(){
			return nodes;
		}
		
		public Node getNode(int index){
			if(nodes == null || index < 0 || index >= nodes.length){
				return null;
			}
			return nodes[index];
		}
		
		public void union(Node n1, Node n2){
			
			if(n1 == null || n2 == null){
				return;
			}
			Node n1Parent = find(n1);
			Node n2Parent = find(n2);
			if(n1Parent == n2Parent){ // same set
				return;
			}
			
			if(n1.getRank() >= n2.getRank()){
				n2Parent.setParent(n1Parent);
				n1Parent.setRank(Math.max(n1Parent.getRank(), n2Parent.getRank()+1));
			}
			else{
				n1Parent.setParent(n2Parent);
				n2Parent.setRank(Math.max(n2Parent.getRank(), n1Parent.getRank()+1));
			}
			
		}
		
		public Node find(Node n){
			if(n == null){
				return null;
			}
			if(n == n.getParent()){
				return n;
			}
			Node parent = find(n.getParent());
			n.setParent(parent); // path compression
			return parent;
		}
	}
	
	/*class DisjointSet {

		
		
		int[] parent = null; // parent holds the representative of the tree
		int[] rank = null;  // rank holds the height of the tree
		
		public DisjointSet(int n){
			parent = new int[n];
			this.rank = new int[n];
			initialize();
		}

		private void initialize() {
			for(int i = 0; i <parent.length; i++){
				parent[i] = i; // to begin with, all the elements are in their own (disjoint) set. 
			}
			for(int i = 0; i <rank.length; i++){
				rank[i] = 1;
			}
		}
		
		
		 * path compression. find representative for i.
		 
		public int find(int i){
			
			if(i == parent[i]){
				return i;
			}
			int result = find(parent[i]);
			parent[i] = result; // cache the result.
			return result;
		}
		
		 union by rank heuristic.
		 * 
		 
		public void union(int i, int j){
			
			int iRep = find(i);
			int jRep = find(j);
			
			if(iRep == jRep){
				return; // in the same set
			}
			
			int iRank = rank[iRep];
			int jRank = rank[jRep];
			
			if(iRank < jRank){ // merge lower rank under higher rank, so that ranks won't change
				parent[iRep] = jRep;
			}
			else if(iRank > jRank){
				parent[jRep] = iRep;
			}
			else{
				parent[jRep] = iRep;
				rank[jRank]++;
			}
		}
	}*/
}
