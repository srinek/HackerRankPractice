package recursion;

import java.util.Scanner;

public class AbbreviationRecursion {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		int index = 0;
		while(index++ < q){
			String a = scan.next();
			String b = scan.next();
			System.out.println(findMatch(a, b, a.length(), b.length()));
		}
		scan.close();
		
	}

	private static String findMatch(String a, String b, int m, int n) {
		//System.out.println(++counter);
		if(m == 0 && n == 0){
			return "YES";  // abcc AB
		}
		if(m == 0){
			return "NO"; // mno   AB
		}
		char char_m = a.charAt(m-1);
		if(n == 0){   // aaaA A, BBBA A
			if(Character.isUpperCase(char_m)){
				return "NO";
			}
			return findMatch(a, b, m-1, n);   
		}
		
		// AaaBccD ABD
		
		char char_n = b.charAt(n-1);
		if(Character.isUpperCase(char_m)){
			if(char_m != char_n){
				return "NO";
			}
			return findMatch(a, b, m-1, n-1);
		}
		if(Character.toUpperCase(char_m) != char_n){
				return findMatch(a, b, m-1, n);
		}
		else{
			boolean res = "YES".equals(findMatch(a, b, m-1, n-1)) || "YES".equals(findMatch(a, b, m-1, n));
			if(res){
				return "YES";
			}
		}
		return "NO";
	}
}
