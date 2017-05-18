package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuickSort2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		Integer[] arr = new Integer[n];
		while(index < n){
			arr[index++] = scan.nextInt();
		}
		scan.close();
		qsort(arr);
	}

	//5 8 1 3 7 9 2
	private static List<Integer> qsort(Integer[] arr) {
		if(arr.length == 0){
			return Collections.EMPTY_LIST;
		}
		if(arr.length == 1){
			return Arrays.asList(arr);
		}
		int p = arr[0];
		List<Integer>  left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		
		for(int i : arr){
			
			if(i < p){
				left.add(i);
			}
			if(i > p){
				right.add(i);
			}
		}
		left = qsort(left.toArray(new Integer[left.size()]));
		right = qsort(right.toArray(new Integer[right.size()]));
		return merge(left, p, right);
	}

	private static List<Integer> merge(List<Integer> left, int p, List<Integer> right) {
		List<Integer> retList = new ArrayList<>();
		for(int i : left){
			retList.add(i);
		}
		retList.add(p);
		for(int i : right){
			retList.add(i);
		}
		for(int i : retList){
			System.out.print(i+" ");
		}
		System.out.println();
		return retList;
	}
	
}
