package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tests = scan.nextInt();
		while(tests-- > 0){
			int n = scan.nextInt();
			char[][] carr = new char[n][n];
			for(int i = 0; i < n; i++){
				String str = scan.next();
				for(int j = 0; j < n; j++){
					carr[i][j] = str.charAt(j);
				}
			}
			System.out.println(canBeSorted(carr));
		}
		scan.close();
	}
	
	private static String canBeSorted(char[][] carr){
		
		for(int i = 0; i < carr.length - 1; i++){
			sort(carr[i]);
			sort(carr[i+1]);
			for(int j = 0; j < carr[i].length; j++){
				if(carr[i][j] > carr[i+1][j]){
					return "NO";
				}
			}
		}
		return "YES";
	}

	private static void sort(char[] cs) {
		Arrays.sort(cs);
	}

}
