package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/permutation-in-string/
 * 
 * 
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 */
public class PermutationsInString {
	
	public static void main(String[] args) {
		PermutationsInString permuteString = new PermutationsInString();
		//System.out.println(permuteString.checkInclusion("ab", "eidbaooo"));
		//System.out.println(permuteString.checkInclusion11("prosperity","properties"));
		System.out.println(permuteString.checkInclusion11("prosperity","properties"));
	}
	
	public boolean checkInclusion(String s1, String s2) {
		 if(s1 == null || s2 == null){
			 return false;
		 }
		 if(s1.length() > s2.length()){
			 return false;
		 }
		 if(s1.equals(s2) || s2.contains(s1)){
			 return true;
		 }
		 
		 int[] s1map = new int[26];
		 int[] s2map = new int[26];
		 
		 for(int i=0; i<s1.length(); i++){
			 s1map[s1.charAt(i) - 'a']++;
			 s2map[s2.charAt(i) - 'a']++;
		 }
		 
		 for(int i=0; i < s2.length()-s1.length(); i++){
			 if(matches(s1map, s2map)){
				 return true;
			 }
			 s2map[s2.charAt(i)-'a']--;
			 s2map[s2.charAt(i+s1.length())-'a']++;
		 }
		 
		 return matches(s1map, s2map);
	}
	
	
	private boolean matches(int[] s1map, int[] s2map) {
		
		for(int i=0; i<s1map.length; i++){
			if(s1map[i] != s2map[i]){
				return false;
			}
		}
		return true;
	}

	public boolean checkInclusion11(String s1, String s2) {
		 
		 if(s1 == null || s2 == null){
			 return false;
		 }
		 if(s1.length() > s2.length()){
			 return false;
		 }
		 if(s1.equals(s2) || s2.contains(s1)){
			 return true;
		 }
		 List<String> permutations = permute("abc");
		 for(String str : permutations){
			 if(s2.contains(str)){
				 return true;
			 }
		 }
		 return false;
	 }

	private List<String> permute(String s1) {
		
		List<String> result = new ArrayList<>();
		permuteHelper(s1, 0, result);
		return result;
	}

	private void permuteHelper(String s1, int start, List<String> result) {
		
		if(start == s1.length()-1){
			result.add(s1);
			return;
		}
		
		for(int i=start; i< s1.length(); i++){
			s1 = swap(s1, start, i);
			permuteHelper(s1, start+1, result);
			s1 = swap(s1, start, i);
		}
		
	}

	private String swap(String s1, int start, int i) {
		char[] chars = s1.toCharArray();
		char temp =chars[start];
		chars[start] = chars[i];
		chars[i] = temp;
		return new String(chars);
	}

}
