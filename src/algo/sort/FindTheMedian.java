package algo.sort;

import java.util.Scanner;

public class FindTheMedian {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		int[] arr = new int[n];
		while(index < n){
			arr[index++] = scan.nextInt();
		}
		scan.close();
		qsort(arr, 0, arr.length);
		System.out.println(arr[arr.length/2]);
	}

	private static void qsort(int[] arr, int start, int end) {
		if((end-start) <= 1){
			return;
		}
		int mid = arr.length/2;
		int p = arr[end -1];
		int current = start;
		int i = start;
		while(current < end-1){
			
			if(arr[current]  < p){
				swap(arr, current, i);
				current++;
				i++;
			}
			else{
				current++;
			}
		}
		swap(arr, current, i);
		/*for(int k = 0; k< arr.length; k++){
			System.out.print(arr[k]+" ");
		}
		System.out.println(p);*/
		if(i == mid){
			return;
		}
		else if(i < mid){
			qsort(arr, i+1, end);
		}
		else{
			qsort(arr, start, i);
		}
		
	}
	
	private static void swap(int[] arr, int i, int current) {
		int temp = arr[i];
		arr[i] = arr[current];
		arr[current] = temp;
	}
}
