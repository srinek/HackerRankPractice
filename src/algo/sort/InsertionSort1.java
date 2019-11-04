package algo.sort;

import java.util.Scanner;

public class InsertionSort1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		int[] arr = new int[n];
		while(index < n){
			arr[index++] = scan.nextInt();
		}
		scan.close();
		sort(arr);
	}

	//1 4 3 5 6 2
	private static void sort(int[] arr){
		
		
		int length = arr.length;
		
		for(int i =1; i<length; i++){
			int e = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > e){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = e;
			
		}
		printArray(arr);
	}

	private static void printArray(int[] arr) {

		for(int k = 0; k < arr.length; k++){
			System.out.print(arr[k] +" ");
		}
		System.out.println();
		
	}
}
