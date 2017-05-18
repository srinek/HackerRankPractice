package algo.dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class EqualChocolates {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int totaltests = scan.nextInt();
		
		for(int test_i = 0; test_i < totaltests; test_i++){
			int arrsize = scan.nextInt();
			int[] arr = new int[arrsize];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int count = 0;
			Stack<Integer> maxIndexes = new Stack<>();
			for(int arr_i = 0; arr_i < arrsize; arr_i++){
				arr[arr_i] = scan.nextInt();
				/*if(arr[arr_i] > max){
					max = arr[arr_i];
					maxIndexes.push(arr_i);
				}*/
				if(arr[arr_i] < min){
					min = arr[arr_i];
				}
			}
			int[] sortarr = Arrays.copyOf(arr, arr.length);
			Arrays.sort(sortarr);
			for(int sort_i=0; sort_i < sortarr.length; sort_i++){
				maxIndexes.push(sort_i);
			}
			System.out.println(findMinSteps(sortarr, min,  maxIndexes, count));
		}
			
		
		scan.close();
	}
	
	private static int findMinSteps(int[] arr, int min,  Stack<Integer> maxIndexes, int count){
		int maxvalIndex = maxIndexes.pop();
		int max =  arr[maxvalIndex];
		if(max == min){
			return count;
		}
		
		int newval = 0;
		if(max - min >= 5){
			count += (max - min) / 5;
			newval = max - (((max - min) / 5) * 5);
		}
		else if(max - min >= 2){
			count += (max - min) / 2;
			newval = max - (((max - min) / 2) * 2);
		}
		else if(max - min >= 1){
			count += (max - min) / 1;
			newval = max - (((max - min) / 1) * 1);
		}
		arr[maxvalIndex] = newval;
		//maxvalIndex = findMaxValIndex(arr);
		//max = arr[maxvalIndex];
		return findMinSteps(arr, min, maxIndexes, count);
	}

	private static int findMaxValIndex(int[] arr) {
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for(int i=0; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
