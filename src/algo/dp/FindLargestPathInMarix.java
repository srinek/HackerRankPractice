package algo.dp;

public class FindLargestPathInMarix {
	
	private int findLargestPathInMatrix(int[][] matrix, int n){
		
		int result = 0;
		int[][] memo = new int[n][n];
		
		for(int i=0; i<memo.length; i++){
			for(int j=0; j<memo[i].length; j++){
				memo[i][j] = -1;
			}
			
		}
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				memo[i][j] = findLargestPathFromACell(matrix, memo, i, j, n);
				result = Math.max(memo[i][j], result);
			}
		}
		
		return result;
		
	}

	private int findLargestPathFromACell(int[][] matrix, int[][] memo, int i, int j, int n) {
		
		if(i < 0 || j < 0 || i >= n || j>=n){
			return 0;
		}
		
		if(memo[i][j] != -1){
			return memo[i][j];
		}
		
		if(j < n-1 && matrix[i][j]+1 == matrix[i][j+1]){
			memo[i][j] = 1+ findLargestPathFromACell(matrix, memo, i, j+1, n);
			return memo[i][j];
		}
		if(j > 0 && matrix[i][j]+1 == matrix[i][j-1]){
			memo[i][j] =  1+ findLargestPathFromACell(matrix, memo, i, j-1, n);
			return memo[i][j];
		}
		if(i < n-1 && matrix[i][j]+1 == matrix[i+1][j]){
			memo[i][j] =  1+ findLargestPathFromACell(matrix, memo, i+1, j, n);
			return memo[i][j];
		}
		if(i > 0 && matrix[i][j]+1 == matrix[i-1][j]){
			memo[i][j] =  1+ findLargestPathFromACell(matrix, memo, i-1, j, n);
			return memo[i][j];
		}
		
		memo[i][j] = 1;
		return memo[i][j]; 
	}
	
	public static void main (String[] args) 
    {
        int  mat[][] = { {1, 2, 9},
                         {5, 3, 8},
                         {4, 6, 7} };
        
        FindLargestPathInMarix m = new FindLargestPathInMarix();
        
        System.out.println("Length of the longest path is " + 
        		m.findLargestPathInMatrix(mat, mat.length));
    }

}
