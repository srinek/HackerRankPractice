package strings;


/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 * 
 */
public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		LongestPalindromeSubstring sol = new LongestPalindromeSubstring();
		System.out.println(sol.findLongestPalindrome("cbbd"));
	}
	// babad
	private String findLongestPalindrome(String s){
		
		if(s == null || s == ""){
			return ""; 
		}
		
		boolean[][] output = new boolean[s.length()][s.length()];
		String result = "";
		
		for(int i=0; i<s.length(); i++){
			output[i][i] = true; // base condition
			result = 1 > result.length() ? s.substring(i, i+1) : result;
		}
		
		for(int i=0; i<s.length()-1; i++){
			if(s.charAt(i) == s.charAt(i+1)){
				output[i][i+1] = true; // base condition
				result = 2 > result.length() ? s.substring(i, i+2) : result;
			}
			
		}
		int j = 0;
		for(int k=2; k<s.length(); k++){
			for(int i=0; i<s.length()-k; i++){
				j = i+k;
				if(s.charAt(i) == s.charAt(j) && output[i+1][j-1]){
					output[i][j] = true;
					result = j-i+1 > result.length() ? s.substring(i, j+1) : result;
				}
				else{
					output[i][j] = false;
				}
			}
		}
		
		return result;
	}
}
