package algo.dp;

import java.util.Scanner;

public class MaximumSubArray {

	
	//2 -1 2 3 4 -5
	//3 -5 5 -2 6 -1
	//3 -5 1 -2 6 -1
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int tests = scan.nextInt();
		while(tests-- > 0){
			
			int totalSize = scan.nextInt();
			int[] input = new int[totalSize];
			for(int i = 0; i < totalSize; i++){
				input[i] = scan.nextInt();
			}
			findMaxSubarraySum(input);
		}
		scan.close();
		
	}
	
	private static void findMaxSubarraySum(int[] input){
		
		int maxSum = Integer.MIN_VALUE;
		long maxSumNonContinuos = Long.MIN_VALUE;
		int currentMax = Integer.MIN_VALUE;
		
		for(int i = 0; i < input.length; i++){
			
			if(input[i] >= 0){
				if(maxSumNonContinuos <= 0){
					maxSumNonContinuos =0;
				}
				maxSumNonContinuos += input[i];
			}
			else{
				if( input[i] > maxSumNonContinuos){
					maxSumNonContinuos = input[i];
				}
			}
			
			if(currentMax < 0){
				currentMax = input[i];
			}
			else{
				currentMax += input[i];
			}
			if(currentMax > maxSum){
				maxSum = currentMax;
			}
			
			
		}
		System.out.println(maxSum +" "+ maxSumNonContinuos);
	}
	
	
	static class MaxSubArray{
		
		public int start;
		public int end;
		public int sum;
	}
}
