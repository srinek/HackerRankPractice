package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOfTrees {
	
	public static void main(String[] args) {
		
		
		List<List<Integer>> forest = new ArrayList<>(); // new int[][]{{1,2,3},{0,0,4},{7,6,5}};
		
		forest.add(Arrays.asList(1,2,3));
		forest.add(Arrays.asList(0, 0, 4));
		forest.add(Arrays.asList(7, 6, 5));
		
		CutOfTrees trees = new CutOfTrees();
		
		System.out.println(trees.cutOffTree(forest));
		
	}
	
	public int cutOffTree(List<List<Integer>> forest) {
        
        if(forest == null){
            return -1;
        }
        int m = forest.size();
        int n =  m > 0 ? forest.get(0).size() : 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0]-b[0]);
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(forest.get(i).get(j) > 1){
                    pq.offer(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        
        int sr = 0, sc = 0, tr = 0, tc = 0, ans = 0;
        
        while(!pq.isEmpty()){
        	
        	int[] tree = pq.poll();
        	
        	tr = tree[1];
        	tc = tree[2];
        	
        	int dist = dist(forest, sr,  sc, tr, tc);
        	
        	sr = tree[1];
        	sc = tree[2];
            
        	if( dist <0 ){
        		return -1;
        	}
        	ans += dist;
        }
        
        return ans;
    }
    
    private int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

	private int dist(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
		
		int m = forest.size();
        int n =  m > 0 ? forest.get(0).size() : 0;
		
        boolean[][] visited = new boolean[m][n];
		Queue<int[]> bfs = new LinkedList<>();
		
		bfs.offer(new int[]{sr, sc, 0});
		
        visited[sr][sc] = true;
        
		while(!bfs.isEmpty()){
			
			int[] cur = bfs.poll();
			
			if(cur[0] == tr && cur[1] == tc){
				return cur[2];
			}
			
			for(int i=0; i<4; i++){
				int r = cur[0] + dir[i][0];
				int c = cur[1] + dir[i][1];
				
				if(r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || forest.get(r).get(c) == 0 ){
					continue;
				}
				visited[r][c] = true;
				bfs.offer(new int[]{r, c, cur[2]+1});
				
			}
		}
		
		return -1;
	}

}
