package algo.dp;

public class EditDistanceDP {

	
	public static void main(String[] args) {
		int count = matchStrings("ABC", "MN", 3, 2);
		System.out.println(count);
	}

	private static int matchStrings(String a, String b, int m, int n) {
		
		int[][] result = new int[m+1][n+1];
		
		
		for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				if(i == 0){
					result[i][j] = j;
				}
				else if(j == 0){
					result[i][j] = i;
				}
				else if(a.charAt(i-1) == b.charAt(j-1)){
					result[i][j] = result[i-1][j-1];
				}
				else{
					result[i][j] = 1 + findMinimum (result[i-1][j], result[i-1][j-1], result[i][j-1]);
				}
			}
		}
		
		
		return result[m][n];
	}
	
	private static int findMinimum(int i, int j, int k) {
		int min = i;

		if(j < min){
			min = j;
		}
		if(k < min){
			min = k;
		}
		return min;
	}
}

