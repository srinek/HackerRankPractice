package algo.dp;

import java.util.Arrays;

public class SubsetSum {
	
	//{4, 1, 10, 12, 5, 2}, 
    //sum = 9
	//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
	private boolean recursion(int[] arr, int sum, int n){
		
		if(n < 0 && sum > 0){
			return false;
		}
		if(sum == 0){
			return true;
		}
		if(arr[n] > sum){
			return recursion(arr, sum, n-1);
		}
		return recursion(arr, sum-arr[n], n-1) || recursion(arr, sum, n-1);
	}
	
	private boolean dp(int[] arr, int sum){
		
		boolean[][] result = new boolean[arr.length+1][sum+1];
		
		for(int i=0; i<result.length; i++){
			for(int j=0; j<result[i].length; j++){
				if(i == 0 && j==0){
					result[i][j] = true; // base condition
				}
				else if(i == 0){
					result[i][j] = false;
				}
				else if(j == 0){
					result[i][j] = true;
				}
				else if(arr[i-1] > j){
					result[i][j] = result[i-1][j];  //excluding the current element
				}
				else{
					result[i][j] = result[i-1][j] || result[i-1][j-arr[i-1]];
				}
			}
		}
		
		for(int i=0; i<result.length; i++){
			System.out.println(Arrays.toString(result[i]));
		}
		
		return result[arr.length][sum];
	}
	
	public static void main(String[] args) {
		SubsetSum s = new SubsetSum();
		int[] arr = new int[]{4 , 2};
		//System.out.println(s.recursion(arr, 9, arr.length-1));
		System.out.println(s.dp(arr, 6));
	}

}
