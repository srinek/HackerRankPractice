package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*String t always consists of two distinct alternating characters. For example, if string 's two distinct characters are x and y, then t could be xyxyx or yxyxy but not xxyy or xyyx.

You can convert some string s to string t by deleting characters from s. When you delete a character from s, you must delete all occurrences of it in . For example, if  abaacdabd and you delete the character a, then the string s becomes bcdbd.

Given s, convert it to the longest possible string t. Then print the length of string t on a new line; if no string t can be formed from s, print 0 instead.*/

/*10
beabeefeab
anbdkaldbija*/
public class TwoCharacters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		String str = scan.next();
		scan.close();
		
		System.out.println(findLength(str));
	}
	
	private static int findLength(String input){
		
		if(input == null || input.trim().length() == 0){
			return 0;
		}
		
		char[] chars = input.toCharArray();
		Set<Character> charset = new HashSet<>(); 
		
		for(char c : chars){
			charset.add(c);
		}
		if(charset.size() == chars.length){ // all are unique chars
			return 0; 
		}
		Character[] uniquechars = charset.toArray(new Character[charset.size()]);
		int maxLength = 0;
		for(int i=0; i < uniquechars.length; i++){
			char c1 = uniquechars[i];
			for(int j=i+1; j < uniquechars.length; j++){
				char c2 = uniquechars[j];
				String temp = input.replaceAll("[^"+c1+""+c2+"]","");
				if(isValidT(temp)){
					if(maxLength < temp.length()){
						maxLength = temp.length();
					}
				}
			}
		}
		return maxLength;
		
	}

	private static boolean isValidT(String str) {
		char[] charArr = str.toCharArray();
		for(int i = 1; i < str.length(); i++){
			if(charArr[i-1] == charArr[i]){
				return false;
			}
		}
		return true;
		
	}
}

/* a
 * e
 * b
 */
