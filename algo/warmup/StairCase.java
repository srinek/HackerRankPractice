package algo.warmup;

import java.util.Scanner;

public class StairCase {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		scan.close();
		int spaces = total - 1;
		StringBuilder staircase = new StringBuilder();
		
		for(int k = 0; k < total; k++){
			for(int i = 0; i < spaces; i++){
				staircase.append(" ");
			}
			for(int j=0 ; j < total-spaces; j++){
				staircase.append("#");
			}
			staircase.append("\n");
			spaces--;
		}
		System.out.println(staircase);
		
	}
}
