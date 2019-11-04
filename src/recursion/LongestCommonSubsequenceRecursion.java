package recursion;

import java.util.Scanner;

public class LongestCommonSubsequenceRecursion {
	
	
	public static void main(String[] args) {
		//System.out.println(lcsRecursive1("ABCDGH", "AEDFHR", 5, 5));
		System.out.println(lcsRecursive1("AXYT", "AYZX", 3, 3));
	    Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int[] s1 = new int[m];
		int index = 0;
		while(index < m){
			s1[index++] = scan.nextInt();
		}
		index = 0;
		int[] s2 = new int[n];
		while(index < n){
			s2[index++] = scan.nextInt();
		}
		int[] result = lcsDynamic(s1, s2);
		for(int k = result.length-1; k >= 0; k--){
			System.out.print(result[k]);
			if(k != 0){
				System.out.print(" ");
			}
		}
		scan.close();
	}
	
	private static int[] lcsDynamic(int[] s1, int[] s2){
		int m = s1.length;
		int n = s2.length;
		int[][] matrix = new int[m+1][n+1];
		
		for(int i = 0; i < m+1; i++){
			matrix[i][0] = 0;
		}
		for(int j = 0; j < n+1; j++){
			matrix[0][j] = 0;
		}
		
		for(int i = 1; i < m+1; i++){
			for(int j = 1; j < n+1; j++){
				if(s1[i-1] == s2[j-1]){
					matrix[i][j] = 1 + matrix[i-1][j-1];
				}
				else{
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
				}
			}
		}
		
		for(int i = 0; i < m+1; i++){
			for(int j = 0; j < n+1; j++){
				
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
		
	    int[] result = new int[matrix[m][n]];
	    int i = m , j = n;
	    int index = 0;
	    while(i > 0 && j > 0){
	    	
	    	if(matrix[i][j] == matrix[i][j -1]){
    			j = j-1;
    		}else if(matrix[i][j] == matrix[i-1][j]){
    			i = i-1;
    		}
    		else if(matrix[i][j] == (1+matrix[i-1][j-1])){
	    		result[index++] = s1[i-1];
	    		i = i -1;
	    		j = j -1;
	    	}
	    }
		
	    return result;
	}
	
	
	private static int lcsRecursive1(String s1,  String s2, int i, int j){
		
		if(i < 0 || j < 0){
			return 0;
		}
		if(s1.charAt(i) == s2.charAt(j)){
			return 1+lcsRecursive1(s1, s2, i-1, j-1);
		}
		return Math.max(lcsRecursive1(s1, s2, i-1, j), lcsRecursive1(s1, s2, i, j-1));
	}
	//AXYT
	//AYZX
	private static int lcsRecursive(String s1,  String s2){
		
		int lcs  = 0;
		if(s1.length() == 1 && s2.length() == 1){
			if(s1.charAt(s1.length() -1) == s2.charAt(s2.length()-1)){
				return 1;
			}
			else{
				return 0;
			}
		}
		
		if(s1.charAt(s1.length() -1) == s2.charAt(s2.length()-1)){
			lcs = 1 + lcsRecursive(s1.substring(0, s1.length() -1), s2.substring(0, s2.length() -1));
		}
		else{
			if(s1.length() == 1){
				lcs = lcsRecursive(s1.substring(0, s1.length()), s2.substring(0, s2.length() -1));
			}
			else if(s2.length() == 1){
				lcs = lcsRecursive(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length()));
			}
			else{
				lcs = Math.max(lcsRecursive(s1.substring(0, s1.length() -1), s2.substring(0, s2.length())), 
						lcsRecursive(s1.substring(0, s1.length()), s2.substring(0, s2.length() - 1)));
			}
		}
		return  lcs;
	}
}
