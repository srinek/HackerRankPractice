package algo.dp;

import java.util.Scanner;

public class EqualChocolates {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int totaltests = scan.nextInt();
		
		for(int test_i = 0; test_i < totaltests; test_i++){
			int arrsize = scan.nextInt();
			int[] arr = new int[arrsize];
			int min = Integer.MAX_VALUE;
			for(int arr_i = 0; arr_i < arrsize; arr_i++){
				arr[arr_i] = scan.nextInt();
				if(arr[arr_i] < min){
					min = arr[arr_i];
				}
			}
			System.out.println(findMinSteps(arr, min));
		}
			
		
		scan.close();
	}
	
	private static int findMinSteps(int[] arr, int min){
		
		int[][] result = new int[min+1][3];
		
		
		return findMinSteps(arr, min);
	}

}
