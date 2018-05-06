package algo.arrays;

import java.util.Scanner;

public class SolutionLeftRotation {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
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
		}
	}
	
	public int[] leftRotate(int[] a, int rotateBy){
		
		int mod = rotateBy/a.length;
		if( mod > 0 ) {
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
