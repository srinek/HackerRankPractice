package algo.dp;


/*
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element. 
 * Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). 
 * If an element is 0, then cannot move through that element.
 * 
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
   Output: 3 (1-> 3 -> 8 ->9)
*/

public class MinJumpsToReachEnd {
	
	public static void main(String[] args) {
		MinJumpsToReachEnd task = new MinJumpsToReachEnd();
		int[] arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(task.findMinJumps_Recursion(arr, 0));
	}

	private int findMinJumps_Recursion(int[] arr, int index){
		
		if(index >= arr.length){
			return 0;
		}
		int distance = arr[index];
		int[] sol = new int[distance];
		for(int i=0; i<distance; i++){
			 sol[i] = 1 + findMinJumps_Recursion(arr, i+index+1);
		}
		
		return min(sol);
	}

	private int min(int[] sol) {
		
		int min = Integer.MAX_VALUE;
		for(int each : sol){
			if(each < min){
				min = each;
			}
		}
		return min;
	}
}
