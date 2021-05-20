package strings;

import java.util.List;
import java.util.ArrayList;

/*
 * https://careercup.com/question?id=5758006474571776
 * Find the indices of all anagrams of a given word in a another word. 
 * For example: Find the indices of all the anagrams of AB in ABCDBACDAB (Answer: 0, 4, 8)
 *   "top" in "aobcotpxyztopoptpot"
 */
/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 */
public class FindAllAnagramsInAString {

	public static void main(String[] args){
		FindAllAnagramsInAString sol = new FindAllAnagramsInAString();
		List<Integer> output = sol.findAnagrams("abcdbacdab", "ab");
		//List<Integer> output = sol.findAnagrams("aobcotpxyztopoptpot", "top");
		//List<Integer> output = sol.findAnagrams("cbaebabacd","abc"); // 0, 6
		System.out.println(output);
	}
	
	public List<Integer> findAnagrams(String str, String t) {
	
		List<Integer> output = new ArrayList<>();
		
		if(t.length() > str.length()){
			return output;
		}
		int[] sarr = new int[26];
		int[] tarr = new int[26];
		// initialize the window
		for(int i=0; i<t.length(); i++){
			tarr[t.charAt(i)-'a']++;
			sarr[str.charAt(i)-'a']++;
		}
		int k=0;
		for(; k<str.length()-t.length(); k++){
			
			if(compareArrays(sarr, tarr)){
				output.add(k);
			}
			
			//sliding window
			sarr[str.charAt(k)-'a']--;
			sarr[str.charAt(k+t.length())-'a']++;
		}
		if(compareArrays(sarr, tarr)){
			output.add(k);
		}
		return output;
	}
	
	private boolean compareArrays(int[] sarr, int[] tarr) {
		
		for(int i=0; i<sarr.length; i++){
			if(sarr[i] != tarr[i]){
				return false;
			}
		}
		return true;
		
	}
	/*public List<Integer> findAnagrams(String str, String a) {
		
		if(str == null || a == null){
			return null;
		}
		List<Integer> output = new ArrayList<>();
		
		boolean[] temp = new boolean[a.length()];
		int i=0;
		int index = -1;
		int tempIndexMatch  = -1, totalMatch = 0;
		while(i < str.length()){
			if(i== 10){
				System.out.println();
			}
			index = a.indexOf(str.charAt(i));
			if(index >= 0){
				if(tempIndexMatch == -1){
					tempIndexMatch = i;
				}
				temp[index] = true;
				totalMatch++;
				if(totalMatch == a.length() && checkForAllMatch(temp)){
					output.add(tempIndexMatch);
					resetTemp(temp);
					tempIndexMatch = -1;
					totalMatch = 0;
				}
			}
			else{
				resetTemp(temp);
				tempIndexMatch = -1;
				totalMatch = 0;
			}
			i++;
		}
		
		return output;
	}
	
	private static void resetTemp(boolean[] temp){
		
		for(int i=0; i<temp.length; i++){
			temp[i] = false;
		}
	}
	
	private static boolean checkForAllMatch(boolean[] temp){
		
		for(int i=0; i<temp.length; i++){
			if(!temp[i]){
				return false;
			}
		}
		return true;
	}*/

	
	
}
