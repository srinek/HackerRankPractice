package algo.sort;

import java.util.Scanner;

public class QuickSortInPlace {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		int[] arr = new int[n];
		while(index < n){
			arr[index++] = scan.nextInt();
		}
		scan.close();
		System.out.println(qsort(arr, 0, arr.length));
	}

	//1 3 9 8 2
	//1 2 9 8 3  i =1 begin =0
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
		System.out.println(p);*/
		/*System.out.println(swaps+"  ");*/
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
