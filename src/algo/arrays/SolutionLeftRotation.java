package algo.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionLeftRotation {

	public static void main(String[] args) {
		
		
		/*Scanner scan = new Scanner(System.in);
		int arrLength = scan.nextInt();
		int rotateBy = scan.nextInt();
		int[] input = new int[arrLength];
		for(int x=0; x < arrLength; x++){
		   input[x] = scan.nextInt();
		}
		scan.close();
		
		SolutionLeftRotation s = new SolutionLeftRotation();
		int[] temp = s.leftRotate(input, rotateBy);
		for(int k : temp){
			System.out.print(k +" ");
		}*/
		
		int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
		SolutionLeftRotation s = new SolutionLeftRotation();
		int[] temp = s.leftRotate(input, 10);
		//int[] temp = s.rotate(input,10);
		System.out.println("rotation " + Arrays.toString(temp));
	}
	
	public int[] leftRotate(int[] a, int rotateBy){

		int mod = rotateBy/a.length;
		if( mod > 0 ) { // using modulo above
			rotateBy = rotateBy  - mod * a.length ;
		}
		int[] barr = new int[a.length];
		int bIndex = 0;
		for(int i = rotateBy; i < a.length; i++){
			barr[bIndex++] = a[i];
		}
		for(int i = 0; i < rotateBy; i++){
			barr[bIndex++] = a[i];
		}
		return barr;
		
	}
	
	/*
	 * right rotation or regular rotation
	 */
	public int[] rotate(int[] arr, int rotateBy){
		
		int mod = rotateBy/arr.length;
		if(mod > 0){
			rotateBy = rotateBy - arr.length * mod;
		}
		
		int[] barr = new int[arr.length];
		
		for(int i=0; i<arr.length-rotateBy; i++){
			barr[i+rotateBy] = arr[i];
		}
		for(int i=arr.length-rotateBy, j=0; i<arr.length; i++, j++){
			barr[j] = arr[i];
		}
		
		return barr;
	}
	
	
	/*public int findLastIndexAfterRotation(int[] a, int rotateBy){
		int ret = (a.length - 1) - rotateBy;
		while(ret < 0){
			ret = ret + a.length;
		}
		
		return ret;
	}
	
	public int[] leftRotate(int[] a, int rotateBy){
		
		int lir = findLastIndexAfterRotation(a, rotateBy);
		int[] barr = new int[a.length];
		int k = lir;
		int i = 1;
		while(k >= 0){
			barr[k--] = a[a.length - i++];
		}
		k = lir+1;
		i = 0;
		while(k < a.length){
			barr[k++] = a[i++];
		}
		return barr;
	}*/
}
