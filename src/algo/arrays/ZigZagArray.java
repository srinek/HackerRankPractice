package algo.arrays;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 * Given an array of DISTINCT elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a < b > c < d > e < f.
 * Example:
 *
 * Input: arr[] = {4, 3, 7, 8, 6, 2, 1}
 * Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
 *
 * Input: arr[] = {1, 4, 3, 2}
 * Output: arr[] = {1, 4, 2, 3}
 */
public class ZigZagArray {

	public static void main(String[] args) {
		//zigZag(new int[]{4, 3, 7, 8, 6, 2, 1});
		zigZag(new int[]{1, 4, 3, 2});
	}
	
	//4, 3, 7, 8, 6, 2, 1	
	// 3, 7, 4, 8, 2, 6, 1 
	public static void zigZag(int[] arr){
		
		if(arr == null){
			return;
		}
		
		boolean lessThan = true;
		
		for(int i=1; i<arr.length; i++){
			
			if(lessThan){
				if(arr[i-1] > arr[i]){
					swap(arr, i-1, i);
				}
			}
			else{
				if(arr[i-1] < arr[i]){
					swap(arr, i-1, i);
				}
			}
			lessThan = !lessThan;
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp; 
	}
}
