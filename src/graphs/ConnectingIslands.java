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
			   ds.union(s.nextInt(), s.nextInt());
		   }
		   if(t == 1){
			  if( ds.find(s.nextInt()) == ds.find(s.nextInt())){
				  System.out.println("Yes");
			  }
			  else{
				  System.out.println("No");
			  }
		   }
		}
		s.close();
		
	}
	
	class DisjointSet {

		
		
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
		
		/*
		 * path compression. find representative for i.
		 */
		public int find(int i){
			
			if(i == parent[i]){
				return i;
			}
			int result = find(parent[i]);
			parent[i] = result; // cache the result.
			return result;
		}
		
		/* union by rank heuristic.
		 * 
		 */
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
	}
}
