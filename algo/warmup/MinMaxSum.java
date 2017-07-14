package algo.warmup;

import java.util.Scanner;

public class MinMaxSum {

	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		long totalsum = 0;
		int  index = 0;
		while(index++ < 5){
			long val = scan.nextInt();
			if(val < min){
				min = val;
			}
			if(val > max){
				max = val;
			}
			totalsum += val;
		}
		System.out.print((totalsum - max) +" "+(totalsum - min));
		scan.close();
	}
}
