package algo.arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 */
// 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9
public class MinimumNumberOfJumpsToReachEndOfArray {

	
	public static void main(String[] args){
		findMinimumJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
	}
	
	public static void findMinimumJumps(int[] arr){
		
		if(arr == null || arr.length == 0){
			return;
		}
		
        int[] minJumps = new int[arr.length];		
        int[] jumpedFrom = new int[arr.length];
        
        minJumps[0] = 0;
		
        for(int i = 1; i<arr.length; i++){
        	minJumps[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i<arr.length; i++){
			for(int j=0; j<i; j++){
				if(arr[j] + j >= i){
					minJumps[i] = Math.min(minJumps[i] , minJumps[j] + 1);
					if(minJumps[i] == minJumps[j] + 1){
						jumpedFrom[i] = j;
					}
				}
			}
		}
        
        System.out.println("maxJumps needed "+ minJumps[arr.length - 1]);
        System.out.println("jumpedFrom "+  Arrays.toString(jumpedFrom));
		
        int end = arr.length - 1;
        while(end > 0){
        	System.out.print(arr[jumpedFrom[end]]);
        	end = jumpedFrom[end];
        	if(end > 0){
        		System.out.print(" ==> ");
        	}
        }
		
	}
	

}
