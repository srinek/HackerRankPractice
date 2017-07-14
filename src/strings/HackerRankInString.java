package strings;

import java.util.Scanner;

public class HackerRankInString {

	private static final String hacker = "hackerrank";
	private static final char[] hackerchars = hacker.toCharArray();
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            if(hasHackerRankinString(s)){
            	System.out.println("YES");	
            }
            else{
            	System.out.println("NO");
            }
            
        }
    }
	
	/*2
	hereiamstackerrankrtyrryryr
	hackerworld*/
	private static boolean hasHackerRankinString(String str){
		if(str == null || str.trim().length() == 0){
			return false;
		}
		char[] inarr = str.toCharArray();
		int j = 0;
		for(char c : inarr){
			if(j == hackerchars.length){
				return true;
			}
			if(hackerchars[j] == c){
				j++;
			}
		}
		if(j == hackerchars.length){
			return true;
		}
		return false;
		
	}
}
