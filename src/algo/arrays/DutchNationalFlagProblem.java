package algo.arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * 
 *  Input :  {0, 1, 2, 0, 1, 2}
	Output : {0, 0, 1, 1, 2, 2}
    
	Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
	Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */
public class DutchNationalFlagProblem {

	
	public static void main(String[] args) {
		
		//sortTheArray(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}); // DNF problem
		//moveAllZerosToTheEnd(new int[]{1,0,2,3,0,4,5,0});
		moveAllZerosToTheEnd(new int[]{0,0,0, 1,2});
	}
	
	/*
	 * 
	 */
	public static void sortTheArray(int[] arr){
		
		if(arr == null || arr.length == 0){
			return;
		}
		
		int start = 0,  ptr = 0, end = arr.length -1;
		
		while(ptr <= end){
			
			switch(arr[ptr]){
			   
			case 0: 
				swap(arr, start, ptr);
				start++;
				ptr++;
				break;
			case 1 :
				ptr++;
				break;
			case 2 : 
				swap(arr, ptr, end);
				end--;
				break;
			}
			//System.out.println(Arrays.toString(arr));
		}
		
		
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void swap(int[] arr, int start, int end){
		
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	// looks similar to dutch national flag problem.
	/*
	 * given an array [1,0,2,3,0,4,5,0], move all 0's to the end (in-place)
	 * 
	 * 0,0,0,1,2
	 */
	
	public static void moveAllZerosToTheEnd(int[] arr){
		
		if(arr == null){
			return;
		}
		int end = 0, ptr=0;
		while(ptr < arr.length){
			if(arr[ptr] != 0){
				swap(arr, ptr, end);
				ptr++;
				end++;
			}
			else{
				ptr++;
			}
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
