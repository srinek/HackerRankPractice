package algo.dp;

public class MinCostPath {
	
	
	public static void main(String[] args) {
		
		MinCostPath mcp = new MinCostPath();
		int[][] input = {{1, 2, 3},{4, 8, 2},{1, 5, 3}};
		System.out.println(mcp.minCostPathDynamic(input, 2, 2));
		
	}

	/*
	 *   1 2 3
	 *   4 8 2
	 *   1 5 3
	 */
	private int minCostPathDynamic(int[][] input, int m, int n) {
		
		int[][] result = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				if(i<=0 && j<=0){
					result[i][j] =  input[0][0];
				}
				else if(j <= 0){
					result[i][j] = input[i][0] + result[i-1][0];
				}
				else if(i <= 0){
					result[i][j] = input[0][j] + result[0][j-1];
				}
				else{
					result[i][j] = input[i][j] + min(result[i][j-1], result[i-1][j], result[i-1][j-1]);
				}
			}
		}
		
		return result[m][n];
	}
	
	/*
	 *   1 2 3
	 *   4 8 2
	 *   1 5 3
	 */
	private int minCostPath(int[][] input, int m, int n) {
		
		if(m<=0 && n<=0){
			return input[0][0];
		}
		if(m <= 0){
			return input[0][n] + minCostPath(input, 0, n-1);
		}
		if(n <= 0){
			return input[m][0] + minCostPath(input, m-1, 0);
		}
		
		int min1 = minCostPath(input, m-1, n);
		int min2 = minCostPath(input, m, n-1);
		int min3 = minCostPath(input, m-1, n-1);
		return   input[m][n] + min(min1, min2, min3);
	}

	private int min(int min1, int min2, int min3) {
		int min = min1;
		if(min2 < min){
			min = min2;
		}
		if(min3 < min){
			min = min3;
		}
		return min;
	}
	
	
	
}
