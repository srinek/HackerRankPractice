package algo.dp;

public class CutRodDP {

	public static void main(String[] args) {
		//int arr[] = { 3, 5, 8, 9, 10, 17, 17, 20 };
		// int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		 //int arr[] = {4, 2,3,1};
		int arr[] = {2,5 ,7 , 8};
		System.out.println(optimumCost(arr, arr.length));
	}

	private static int optimumCost(int[] prices, int n) {

		int cost = 0;
		
		int[][] result = new int[n+1][n+1];
		
		for(int i = 1; i < result.length; i++){
			for(int j = 1; j < result.length; j++){
				
				if(j >= i){
					result[i][j] = Math.max( result[i-1][j] , prices[i-1] + result[i][j-i]);
				}
				else{
					result[i][j] = result[i-1][j];
				}
			}
		}
		return result[n][n];
	}

}
