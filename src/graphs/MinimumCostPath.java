package graphs;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostPath {
	
	public static void main(String[] args) {
		
		//int[][] grid = {{3, 2, 1}, {4, 1, 3}, {5, 3, 7}};
		int[][] grid = {{1, 2, 3}, {4,8,2}, {1,5,3}};
		//minCost(grid);
		minCostDP(grid);
	}
	
	private static void minCostDP(int[][] in){
		
		if(in == null || in.length == 0){
			return;
		}
		int[][] result = new int[in.length+1][in[0].length+1];
		
		int m = result.length;
		int n = result[0].length;
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				
				if(i==0 && j==0){
					result[i][j] = 0;
				}
				else if(i==0 || j==0){
					result[i][j] = Integer.MAX_VALUE;
				}
				else{
					result[i][j] = in[i-1][j-1] + min(result[i-1][j-1], result[i-1][j], result[i][j-1]);
				}
			}
		}
		
		System.out.println(result[m-1][n-1]);
	}
	
	

	
	private static int min(int i, int j, int k) {
		
		int ret = Math.min(i, j);
		ret = Math.min(ret, k);
		return ret;
		
	}

	private static void minCost(int[][] in) {
		
		List<MinCostIndex> indexes = new ArrayList<>();
		MinCostIndex index = new MinCostIndex(0, 0);
		indexes.add(index);
		
		findMin(0, 0, in, indexes);
		
		int cost = 0;
		for(MinCostIndex minIndex : indexes){
			cost += in[minIndex.getI()][minIndex.getJ()];
		}
		
		System.out.println(cost);
	}
	
	/*
	 *   3 2 1
	 *   4 1 3
	 *   5 3 7
	 */
	private static void findMin(int row, int col, int[][] in, List<MinCostIndex> indexes) {
		
		if(row >= in.length || col >= in.length){
			return;
		}
		in[row][col] = Integer.MAX_VALUE ; 
		int min = Integer.MAX_VALUE ;
		int minX = row, minY = col;
		//for(int i=row; i < row+2; i++ ){
			if(col -1 >= 0 && in[row][col-1] < min){
				min = in[row][col-1];
				minX = row;
				minY = col-1;
			}
			if(col + 1 < in.length && in[row][col+1]  < min){
				min = in[row][col+1];
				minX = row;
				minY = col+1;
			}
		//}
		//for(int i=col; i < col+2; i++ ){
			if(row -1 >= 0 && in[row-1][col] < min){
				min = in[row-1][col];
				minY = col;
				minX = row-1;
			}
			if(row + 1 < in.length && in[row+1][col] < min){   // it is a square. so m === n
				min = in[row+1][col];
				minY = col;
				minX = row+1;
			}
		//}
		MinCostIndex index = new MinCostIndex(minX, minY);
		indexes.add(index);
		findMin(minX, minY, in, indexes);
	}



	public static class MinCostIndex{
		int i, j;
		
		public MinCostIndex(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}
	}
}
