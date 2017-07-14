package algo.sort;

import java.util.Scanner;

public class InsertionSort2 {
	
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

	//2 3 6 8 3
	private static void sort(int[] arr){
		
		int length = arr.length;
		int e = arr[length-1];
		
		for(int i = length -2; i >= 0; i-- ){
			int temp = arr[i];
			if(temp > e){
				arr[i+1] = temp;
				printArray(arr);
			}
			else{
				arr[i+1] = e;
				printArray(arr);
				break;
			}
			if(i == 0){
				arr[i] = e;
				printArray(arr);
			}
		}
		
	}

	private static void printArray(int[] arr) {

		for(int k = 0; k < arr.length; k++){
			System.out.print(arr[k] +" ");
		}
		System.out.println();
		
	}
}
