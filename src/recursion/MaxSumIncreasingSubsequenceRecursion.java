package recursion;

import java.util.Scanner;

public class MaxSumIncreasingSubsequenceRecursion {

	public static void main(String[] args) {

		/*Scanner scan = new Scanner(System.in);
		int tests = scan.nextInt();
		while (tests-- > 0) {

			int totalSize = scan.nextInt();
			int[] input = new int[totalSize];
			for (int i = 0; i < totalSize; i++) {
				input[i] = scan.nextInt();
			}
			System.out.println(findMaxSubarraySum(input, 0));
		}
		scan.close();*/
		int[] a = new int[]{99, 3, 100};
        System.out.println(findMaxSubarraySum(a, a.length));
	}
	
	//{1, 101, 2, 3, 100, 4, 5}
    //{1,100,2}
	private static int findMaxSubarraySum(int[] a, int n) {
		
		if(n ==  1){
			return a[n-1];
		}
		
		int maxSum = 0;
		for(int i = 1; i < n; i++){
			int tempsum = 0;
			/*if(i == 0){
				tempsum = input[i] + findMaxSubarraySum(input, ++i);
			}
			else if(i < input.length-1 && input[i+1] > input[i]){
				tempsum = input[i] + findMaxSubarraySum(input, ++i);
			}
			else{
				tempsum = Math.max(input[i], findMaxSubarraySum(input, ++i));
			}
			if(tempsum > maxSum){
				maxSum = tempsum;
			}
			System.out.println(k +"  "+maxSum);*/
		}
		return maxSum;
	}
}
