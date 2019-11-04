package recursion;

public class CutRod {

	public static void main(String[] args) {
		//int arr[] = {3, 5, 8, 9, 10, 17, 17, 20};
		//int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		//int arr[] = {4, 2,3,1};
		int arr[] = {2,5 ,7 , 8};
		System.out.println(optimumCostRecursion(arr, arr.length));
	}
	
	
	
	private static int optimumCostRecursion(int[] prices, int n){
		
		if(n < 1){
			return 0;
		}
		int max = prices[n-1];
		for(int i=0; i < n; i++){
			max = Math.max(max, optimumCostRecursion(prices, n-i-1) + prices[i]);
		}
		return max;
	}
	
	private static int optimumCostDP(int[] prices, int n){
		
		int[] result = new int[n+1];
		result[0] = 0;
		
		for(int i=1; i <= n; i++){
			int max = prices[i-1];
			for(int j=0; j<i; j++){
				result[i] = Math.max(max, prices[j]+result[i-j-1]);
			}
		}
		
		return result[n];
	}
	
	
}
