package algo.sort;

import java.util.Scanner;

public class CountingSort2 {

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
		sort(arr, result);
	}

	private static void sort(int[] arr, int[] result) {
		
		for(int i : arr){
			result[i]++;
		}
		
		for(int i = 0; i < result.length; i++){
			int count = result[i];
			for(int k = 0; k < count; k++){
				System.out.print((i)+" ");
			}
		}
		
	}
	
	
}
