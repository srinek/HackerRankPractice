package algo.dp;

public class EqualSubsets {
	
	
	/*
	 * https://www.geeksforgeeks.org/partition-problem-dp-18/
	 * 
	 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
		Examples:
	 * arr[] = {1, 5, 11, 5}
	   Output: true 
	   The array can be partitioned as {1, 5, 5} and {11}

	 */
	
	// 2,3,1,5
	public static void main(String[] args) {
		EqualSubsets s = new EqualSubsets();
		System.out.println(s.hasEqualSubsets(new int[]{1, 5, 11, 5}));
	}
	
	private boolean hasEqualSubsets(int[] arr){
		
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
		}
		if(sum%2 == 1){
			return false;
		}
		
		int total = sum/2;
		//return recursion(arr, total, arr.length-1);
		return dp(arr, total);
	}

	private boolean dp(int[] arr, int total) {
		boolean[][] result = new boolean[arr.length+1][total+1];
		
		for(int i=0; i<result.length; i++){
			for(int j=0; j<total+1; j++){
				
				if(i==0 && j==0){
					result[i][j] = true;
				}
				else if(i == 0){
					result[i][j] = false;
				}
				else if(j == 0 || j < arr[i-1]){
					result[i][j] = result[i-1][j];
				}
				else {
					result[i][j] = result[i-1][j-arr[i-1]];
				}
			}
			if(result[i][total]){
				return true;
			}
		}
		if(result[arr.length][total]){
			return true;
		}
		return false;
	}
	
	private boolean recursion(int[] arr, int total, int i) {
		
		if(i < 0 && total == 0){
			return true;
		}
		if(total < 0 || (i<0 && total > 0)){
			return false;
		}
		
		return recursion(arr, total-arr[i], i-1) || recursion(arr, total, i-1);
	}

}
