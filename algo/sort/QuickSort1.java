package algo.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		int[] arr = new int[n];
		while(index < n){
			arr[index++] = scan.nextInt();
		}
		scan.close();
		qsort(arr);
	}
   
	// 4 3 2 5 7
	// 4 3 4 5 7 2
	private static void qsort(int[] arr) {
		
		int p = arr[0];
		List<Integer> left = new ArrayList<>();
		List<Integer> equal = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		
		for(int i : arr){
			
			if(i < p){
				left.add(i);
			}
			if(i == p){
				equal.add(i);
			}
			if(i > p){
				right.add(i);
			}
		}
		for(int i : left){
			System.out.print(i+" ");
		}
		for(int i : equal){
			System.out.print(i+" ");
		}
		for(int i : right){
			System.out.print(i+" ");
		}
		
	}

	
}
