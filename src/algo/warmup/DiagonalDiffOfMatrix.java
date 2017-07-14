package algo.warmup;

import java.util.Scanner;

public class DiagonalDiffOfMatrix {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[][] arr = new int[total][total];
		for(int i = 0; i < total; i++){
			for(int j=0; j< total; j++){
				arr[i][j] = scan.nextInt();
			}
		}
		scan.close();
		System.out.println(findDiagonalDiff(arr));
	}
	
	private static int findDiagonalDiff(int[][] a){
		
		int sum1 = 0;
		for(int i = 0; i < a.length; i++){
			sum1 += a[i][i];
		}
		int sum2 = 0;
		int j = 0;
		for(int i = a.length - 1; i >= 0 ; i--){
			sum2 += a[i][j++];
		}
		return Math.abs(sum1-sum2);
	}

}
