package recursion;

import java.util.Scanner;

public class PowSumIncludeExcludeSol {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int n = scan.nextInt();
		System.out.println(powsum(x, n, 1));
		scan.close();
	}
	
	private static int powsum(int x, int n, int i){
		
		int power = (int)Math.pow(i, n);
		int val = x - power;
		if(val == 0){
			return 1;
		}
		if(val < 0){
			return 0;
		}
		return powsum(val, n, i+1) + powsum(x, n, i+1) ; //exclude condition and include condition
	}
}
