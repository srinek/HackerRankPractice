package strings;

import java.util.Scanner;

/*Julius Caesar protected his confidential information by encrypting it in a cipher. Caesar's cipher rotated every letter in a string by a fixed number,K , 
 * making it unreadable by his enemies. Given a string,S , and a number, K, encrypt  and print the resulting string.
*/

public class CaesarCipher {

	public static void main(String[] args) {
	   
	   Scanner scan = new Scanner(System.in);
	   int total = scan.nextInt();
	   String s = scan.next();
	   int rotate = scan.nextInt();
	   System.out.println(encryptString(s, rotate));
	   scan.close();
	   
	}
	// 97-122 a-z
	//65-90 A-Z
	private static String encryptString(String str, int rotateBy){
		if(str == null || str.length() == 0){
			return "";
		}
		char[] chars = str.toCharArray();
		char[] cycpherchars = new char[str.length()];
		int i = 0;
		rotateBy = rotateBy % 26;
		for(char c : chars){
			if(c >= 97 && c <= 122){
				c = rotateSmall(c, rotateBy);
			}
			if(c >= 65 && c <= 90){
				c = rotateCaps(c, rotateBy);
			}
			cycpherchars[i++] =  c;
		}
		String ret = "";
		for(char c :  cycpherchars){
			ret += c;
		}
		return ret;
	}
	
	private static char rotateCaps(char c, int k) {
		
		if(c+k > 90){
			c = (char)((c + k - 90) + 64);
		}
		else if(c+k < 65){
			c = (char)((91 - (65 - (c + k))));
		}
		else{
			c = (char)(c+k);
		}
		return c;
	}
	
	private static char rotateSmall(char c, int k) {
		
		if(c+k > 122){
			c = (char)((c + k - 122) + 96);
		}
		else if(c+k < 97){
			c = (char)((123 - (97 - (c + k))));
		}
		else{
			c = (char)(c+k);
		}
		return c;
	}
	
}
