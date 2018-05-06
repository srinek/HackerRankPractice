package algo.dp;

import java.util.Scanner;

public class AbbreviationDP {
	
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
	
	/*daBcd
	ABC*/
	private static String findMatch(String a, String b, int m, int n){
		
		char[][] mn = new char[m+1][n+1];
		
		for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				if(i == 0 && j == 0){
					mn[i][j] = 'Y';
					continue;
				}
				if(i == 0){
					mn[i][j] = 'N';
					continue;
				}
				char char_m = a.charAt(i-1);
				if(j == 0){
					if(Character.isUpperCase(char_m)){
						mn[i][j] = 'N';
						continue;
					}
					mn[i][j] = mn[i-1][j];
					continue;
				}
				char char_n = b.charAt(j-1);
				if(Character.isUpperCase(char_m)){
					if(char_m != char_n){
						mn[i][j] = 'N';
						continue;
					}
					mn[i][j] = mn[i-1][j-1];
					continue;
				}
				if(Character.toUpperCase(char_m) != char_n){
					mn[i][j] = mn[i-1][j];
					continue;
				}
				else{
					
					boolean res = ('Y' == mn[i-1][j-1]) || ('Y' == mn[i-1][j]);
					if(res){
						mn[i][j] = 'Y';
						continue;
					}
				}
				mn[i][j] = 'N';
			}
		}
		
		/*for(char[] c : mn){
			System.out.println(Arrays.toString(c));
		}*/
		
		if(mn[m][n] == 'Y'){
			return "YES";
		}
		return "NO";
		
	}

}
