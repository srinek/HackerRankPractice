package strings;

import java.util.Arrays;

public class IsPalindrome {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("ababczz"));
	}

	public static boolean isPalindrome(String inp){
		
		char[] charArray = inp.toCharArray();
		int[] count = new int[255];
		for(char c : charArray){
			count[c]++;
		}
		System.out.println(Arrays.toString(count));
		boolean palindrome = true;
		boolean allowOnlyone = false;
		for(int i : count){
			if(i == 0){
				continue;
			}
			if(i == 1 && !allowOnlyone){
				allowOnlyone = true;
				continue;
			}
			if(i != 2){
				palindrome = false;
			}
		}
		
		return palindrome;
	}
}
