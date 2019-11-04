package strings;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring tst = new MinimumWindowSubstring();
		// System.out.println(tst.minWindow("ADOBECODEBANC", "ABC"));
		// System.out.println(tst.minWindow("ABCD", "ABC")); //--
		 System.out.println(tst.minWindow("ABAAACBAB", "AABC")); //--
		System.out.println(tst.minWindow("bbaa", "aba")); // --
		 System.out.println(tst.minWindow("ab", "b"));
		 System.out.println(tst.minWindow("XYZ", "ABC"));
	}

	public String minWindow(String s, String t) {
		if (s == null || t == null) {
			return "";
		}
		Map<Character, Integer> countMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			int count = countMap.getOrDefault(c, 0);
			countMap.put(c, count+1);
		}
		return helper(s, t, countMap);
	}

	public String helper(String s, String t, Map<Character, Integer> targetCountMap) {
		
		if (t.length() > s.length()) {
			return "";
		}
		Map<Character, Integer> sourceCountMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			int count = sourceCountMap.getOrDefault(c, 0);
			sourceCountMap.put(c, count+1);
		}
		int formed = 0;
		for(Character c : targetCountMap.keySet()){
			if(sourceCountMap.get(c) != null && sourceCountMap.get(c) >= targetCountMap.get(c)){
				formed++;
			}
		}
		if(formed != targetCountMap.size()){
			return "";
		}
		String min = s;
		String leftWindow = helper(s.substring(0, s.length() - 1), t, targetCountMap);
		if (leftWindow != "" && leftWindow.length() < min.length()) {
			min = leftWindow;
		}
		if (s.length() > 0) {
			String rightWindow = helper(s.substring(1, s.length()), t, targetCountMap);
			if (rightWindow != "" && rightWindow.length() < min.length()) {
				min = rightWindow;
			}
		}
		return min;
	}

}
