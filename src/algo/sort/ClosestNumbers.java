package algo.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers {

	
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
		findClosest(arr);
	}
	
	private static void findClosest(int[] arr) {
		List<Integer> n1 = new ArrayList<>();
		List<Integer> n2 = new ArrayList<>();
		int diff = Integer.MAX_VALUE;
		for(int i =1; i < arr.length; i++){
			int ldiff = Math.abs(arr[i] - arr[i-1]);
			if(ldiff == diff){
				n1.add(arr[i-1]);
				n2.add(arr[i]);
			}
			if(ldiff < diff){
				diff = ldiff;
				n1.clear();
				n2.clear();
				n1.add(arr[i-1]);
				n2.add(arr[i]);
			}
			
		}
		
		for(int i =0; i < n1.size(); i++){
		   System.out.print(n1.get(i)+" "+n2.get(i)+" ");
		}
		
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
