package algo.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LilysHomework {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		int[] arr = new int[n];
		while(index < n){
			arr[index++] = scan.nextInt();
		}
		scan.close();
		int[] origasc = Arrays.copyOf(arr, arr.length);
		int[] origdsc = Arrays.copyOf(arr, arr.length);
		Arrays.sort(arr);
		int swapsasc = findTotalSwaps(arr, origasc);
		reverse(arr);
		int swapsdsc = findTotalSwaps(arr, origdsc);
		
		/*for(int i : arr){
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i : orig){
			System.out.print(i+" ");
		}*/
		System.out.println(swapsasc < swapsdsc ? swapsasc : swapsdsc);
	}

	private static int findTotalSwaps(int[] arr, int[] orig) {
		Map<Integer, Integer> mapOfOrig = makeMap(orig);
		int swaps = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != orig[i]){
				swap(orig, i, mapOfOrig.get(arr[i]), mapOfOrig);
				swaps++;
			}
		}
		return swaps;
	}

	private static void reverse(int[] arr) {
		for(int i = 0; i< arr.length/2; i++){
			swap(arr, i, arr.length-1-i);
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

	private static Map<Integer, Integer> makeMap(int[] orig) {
		Map<Integer, Integer> ret = new HashMap<>();
		for(int i = 0; i < orig.length; i++){
			ret.put(orig[i], i);
		}
		
		return ret;
	}

	private static void swap(int[] arr, int i, int current, Map<Integer, Integer> mapOfOrig) {
	
		int temp = arr[i];
		arr[i] = arr[current];
		arr[current] = temp;
		mapOfOrig.put(arr[i], i);
		mapOfOrig.put(arr[current], current);
    }
	

}
