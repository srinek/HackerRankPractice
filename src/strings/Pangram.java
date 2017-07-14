package strings;

import java.util.Scanner;

/*We promptly judged antique ivory buckles for the next prize
We promptly judged antique ivory buckles for the prize */   

public class Pangram {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		if(isPanagram(s)){
			System.out.println("pangram");
		}
		else{
			System.out.println("not pangram");
		}
		scan.close();
	}
	private static boolean isPanagram(String str){
		if(str == null || str.trim().length() == 0){
			return false;
		}
		final char[] alphabets = new char[26];
		str = str.replaceAll(" ", "").toLowerCase();
		char[] chars = str.toCharArray();
		for(char c : chars){
			alphabets[c-97] = c;
		}
		for(char c : alphabets){
		   	if(c == '\u0000'){
		   		return false;
		   	}
		}
		return true;
		
	}
}
