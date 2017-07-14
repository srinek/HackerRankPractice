package algo.sort;

import java.util.Scanner;

public class CountingSort1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		int[] arr = new int[n];
		while(index < n){
			arr[index++] = scan.nextInt();
		}
		scan.close();
		int[] result = new int[100];
		count(arr, result);
	}

	private static void count(int[] arr, int[] result) {
		
		for(int i : arr){
			result[i]++;
		}
		
		for(int r : result){
			System.out.print(r +" ");
		}
		
	}
	
	
}
