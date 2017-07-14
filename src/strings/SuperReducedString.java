package strings;

import java.util.Scanner;

public class SuperReducedString {
	
	//aaabccc  => abccc => abc
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String temp = scan.next();
		scan.close();
        String result = findReducedString(temp);
		System.out.println(result);
	}

	private static String findReducedString(String str){
		
		if(str == null || str.trim().equals("")){
			return "";
		}
		char[] chararr = str.trim().toCharArray();
		
		for(int i=1; i < chararr.length; i++){
			char c = chararr[i-1];
			char prev = chararr[i];
			if(prev == c){
				str = str.replaceFirst(c+""+c, "");
				chararr = str.toCharArray();
				i=0;
			}
		}
		if(str.equals("")){
			str = "Empty String";
		}
		return str;
	}
}
