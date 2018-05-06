package graphs;

public class DisjointSet {

	
	
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
	
	// drive code from gfg
	public static void main(String[] args) {

		        // Let there be 5 persons with ids as
		        // 0, 1, 2, 3 and 4
		        int n = 5;
		        DisjointSet ds =
		                       new DisjointSet(n);
		 
		        // 0 is a friend of 2
		        ds.union(0, 2);
		 
		        // 4 is a friend of 2
		        ds.union(4, 2);
		 
		        // 3 is a friend of 1
		        ds.union(3, 1);
		 
		        // Check if 4 is a friend of 0
		        if (ds.find(4) == ds.find(0)){
		            System.out.println("Yes");
		        }
		        else{
		            System.out.println("No");
		        }
		        // Check if 1 is a friend of 0
		        if (ds.find(1) == ds.find(0)){
		            System.out.println("Yes");
		        }
		        else{
		            System.out.println("No");
		        }
	}
}
