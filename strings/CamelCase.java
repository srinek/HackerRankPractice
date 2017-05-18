package strings;

import java.util.Scanner;

/*
 * saveChangesInTheEditor  should print 5
 */
public class CamelCase {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String temp = scan.next();
		scan.close();
		System.out.println(findWordsInCamelCase(temp));
	}
	
	private static int findWordsInCamelCase(String input){
		
		if(input == null || input.trim().length() == 0){
			return 0;
		}
		
		int totalwords = 1;
		char[] chars = input.toCharArray();
		for(char c : chars){
			if(Character.isUpperCase(c)){
				totalwords++;
			}
		}
		return totalwords;
	}
}
