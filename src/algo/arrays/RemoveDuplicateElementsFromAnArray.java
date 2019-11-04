package algo.arrays;

import java.util.Arrays;

public class RemoveDuplicateElementsFromAnArray {
	
	
	// [ 1,5,6, 2, 4, 3, 8, 5, 4, 6, 3, 1, 2]
	public static void removeDuplicateElements(int[] arr){
		
		if(arr == null || arr.length == 0){
			return;
		}
		
		Arrays.sort(arr);
		int[] temp = new int[arr.length];
		int j=0, i =0;
		for( ; i < arr.length-1; i++){
			
			if(arr[i] != arr[i+1]){
				temp[j] = arr[i];
				j++;
			}
		}
		temp[j] = arr[i];
		System.out.print(Arrays.toString(arr));
		System.out.print(Arrays.toString(temp));
	}
	// 1 2, 2, 3
	public static void main(String[] args) {
		removeDuplicateElements(new int[]{1,5,6, 2, 4, 3, 8, 5, 4, 6, 3, 1, 2});
	}

}
