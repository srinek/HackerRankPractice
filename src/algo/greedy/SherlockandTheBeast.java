package algo.greedy;

import java.util.Scanner;

public class SherlockandTheBeast {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int index = 0;
		
		while(index++ < t){
			int n = scan.nextInt();
			printDecentNumber(n);
			System.out.println();
		}
		scan.close();
	}
	
	private static void printDecentNumber(int n){
		
		if(n%3 == 0){
			for(int i = 1; i <= n; i++){
				System.out.print(5);
			}
			return;
		}
		
		/*if(n%5 == 0){
			for(int i = 1; i <= n; i++){
				System.out.print(3);
			}
			return;
		}*/
		long temp = n;
		int _5ctr = 0;
		int _3ctr = 0;
		while(true){
			temp = temp - 5;
			_5ctr += 5;
			if(temp < 0){
				System.out.print(-1);
				return;
			}
			if(temp == 0){
				break;
			}
			if(temp % 3 == 0){
				_3ctr = (int)temp;
				break;
			}
		}
		for(int i = 1; i <= _3ctr; i++){
			System.out.print(5);
		}
		for(int i = 1; i <= _5ctr; i++){
			System.out.print(3);
		}
		/*if(n < 5 || n % 3 == 1){
			System.out.print(-1);
			return;
		}
		long k = (n/3 - 1) * 3;
		long remaining = n - k;
		for(int i = 1; i <= k; i++){
			System.out.print(5);
		}
		for(int i = 1; i <= remaining; i++){
			System.out.print(3);
		}*/
	}
}
