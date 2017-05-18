package algo.sort;

import java.util.Arrays;
import java.util.Scanner;

public class RunningTimeAnalysis {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		int[] arr = new int[n];
		while(index < n){
			arr[index++] = scan.nextInt();
		}
		scan.close();
		int[] orig = Arrays.copyOf(arr, n);
		int ishifts = sort(arr);
		int qshifts = qsort(orig, 0, arr.length);
		System.out.println((ishifts - qshifts));
	}

	//1 4 3 5 6 2
	private static int sort(int[] arr){
		
		int length = arr.length;
        int shifts = 0;
		for(int i =1; i<length; i++){
			int e = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > e){
				arr[j+1] = arr[j];
				shifts++;
				j--;
			}
			arr[j+1] = e;
		}
		//System.out.println(shifts);
		return shifts;
	}

	private static void printArray(int[] arr) {

		for(int k = 0; k < arr.length; k++){
			System.out.print(arr[k] +" ");
		}
		System.out.println();
		
	}
	
	public static int qsort(int[] arr, int begin, int end) {
		if((end-begin) <= 1){
			return 0;
		}
		int swaps = 0;
		int p = arr[end-1];
		int i = begin;
		int current = begin;
		while(current < end){
			if(arr[current] < p){
				swap(arr, i, current);
				swaps++;
				i++;
			}
			current++;
		}
		swap(arr, i, current-1);
		swaps++;
		/*for(int k = 0; k< arr.length; k++){
			System.out.print(arr[k]+" ");
		}
		System.out.println(swaps+"  ");*/
		swaps += qsort(arr, begin, i); // 0 , 1
		swaps += qsort(arr, i+1, end); // 2, 4
		return swaps;
	}

	private static void swap(int[] arr, int i, int current) {
		int temp = arr[i];
		arr[i] = arr[current];
		arr[current] = temp;
	}

}
