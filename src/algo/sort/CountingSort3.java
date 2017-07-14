package algo.sort;

import java.util.Scanner;

public class CountingSort3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		int[] arr = new int[n];
		while(index < n){
			arr[index++] = scan.nextInt();
			scan.next();
		}
		scan.close();
		int[] result = new int[100];
		sort(arr, result);
	}

	private static void sort(int[] arr, int[] result) {
		
		for(int i : arr){
			result[i]++;
		}
		
		int total = 0;
		for(int i = 0; i < result.length; i++){
			int count = result[i];
			total += count;
			System.out.print(total +" ");
		}
		
	}
	
	
}
