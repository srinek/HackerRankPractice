package strings;

/*Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/

import java.util.Arrays;

/*
 * 
 */
public class LongestSubstringWithoutRepeatingChars {
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingChars test = new LongestSubstringWithoutRepeatingChars();
		System.out.println(test.lengthOfLongestSubstring("dvdf"));
		System.out.println(test.lengthOfLongestSubstring("abba"));
		System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(test.lengthOfLongestSubstring("bbbbb"));
		System.out.println(test.lengthOfLongestSubstring("pwwkew"));
	}

	public int lengthOfLongestSubstring(String s) {
		if(s == null){
			return 0;
		}
		int[] buffer = new int[255];
		Arrays.fill(buffer, -1);
		char[] chars = s.toCharArray();
		int total = 0;
		int i=0;
		int j;
		for(j=0; j<chars.length; j++){
			if (buffer[s.charAt(j)] != -1) {
				int oldIndex = buffer[s.charAt(j)];
				total = Math.max(total, j-i);
				i = oldIndex+1;
			}
			buffer[s.charAt(j)] = j;
		}
		total = Math.max(total, j-i);
		return total;
	}
	
	public int lengthOfLongestSubstring_old(String s) {
		
		if(s == null){
			return 0;
		}
		int[] buffer = new int[255];
		int[] window = new int[255];
		char[] chars = s.toCharArray();
		int i =0, total = 0, maxTotal = Integer.MIN_VALUE;
		for(int j=0; j<chars.length; j++){
			buffer[s.charAt(j)]++;
			if(buffer[s.charAt(j)] == 1){
				total++;
			}
			else{
				buffer[s.charAt(j)]--;
				i = Math.max(i, window[s.charAt(j)]);
				maxTotal = Math.max(total, maxTotal);
				total = j-i+1;
			}
			window[s.charAt(j)] =j+1;
		}
		maxTotal = Math.max(total, maxTotal);
		return maxTotal;
	}
	
	/*public int lengthOfLongestSubstring(String s) {
		
		if(s == null){
			return 0;
		}
		char[] chars = s.toCharArray();
		int[] buffer = new int[255];
		int total = 0;
		for(int i=0, j=0; i<chars.length; j++){
			i = Math.max(buffer[chars[j]], i);
			buffer[chars[j]] = j+1;
			total = Math.max(j-i+1, total);
		}
		return total;
	}*/

}
