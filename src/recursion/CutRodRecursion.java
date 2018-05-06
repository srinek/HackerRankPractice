package recursion;

public class CutRodRecursion {

	public static void main(String[] args) {
		//int arr[] = {3, 5, 8, 9, 10, 17, 17, 20};
		//int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		//int arr[] = {4, 2,3,1};
		int arr[] = {2,5 ,7 , 8};
		System.out.println(optimumCost(arr, 1, arr.length));
	}
	
	private static int optimumCost(int[] prices, int begin, int n){
		
		if(begin > n){
			//System.out.println("begin "+begin+" cost "+0);
			return 0;
		}
		if(begin == n){
			//System.out.println("begin "+begin+" cost "+prices[begin-n]);
			return prices[0];
		}
		int cost = 0;
		for(int i = 1; i <= n +1 - begin; i++){
			int tempCost = prices[i-1] + optimumCost(prices, begin+1, n);
			if(tempCost > cost){
				cost = tempCost;
			}
		}
		//System.out.println("begin "+begin+" cost "+cost);
		return cost;
	}
	
}
