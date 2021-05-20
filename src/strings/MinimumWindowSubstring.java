package strings;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"re
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring tst = new MinimumWindowSubstring();
		System.out.println("1 "+tst.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println("2 "+tst.minWindow("ABCD", "ABC")); //--
		 System.out.println("3 "+tst.minWindow("ABAAACBAB", "AABC")); //--
		System.out.println("4 "+tst.minWindow("bbaa", "aba")); // --
		 System.out.println("5 "+tst.minWindow("ab", "b"));
		 System.out.println("6 "+tst.minWindow("XYZ", "ABC"));
	}

	public String minWindow(final String s, final String t) {
		final int[] sarr = new int[256];
		final int[] tarr = new int[256];
		if (t.length() > s.length()) {
			return "";
		}
		int j=0;
		while (j < t.length()) {
			sarr[s.charAt(j)]++;
			tarr[t.charAt(j)]++;
			j++;
		}
		int[] ans = new int[] { Integer.MAX_VALUE, 0, 0};
		int i=0;
		while (j<s.length()) {
			while (j-i >= t.length() && compare(sarr, tarr)) {
				if (j-i < ans[0]) {
					ans[0] = j-i;
					ans[1] = i;
					ans[2] = j;
				}
				sarr[s.charAt(i)]--;
				i++;
			}
			sarr[s.charAt(j)]++;
			j++;
		}
		while (j-i >= t.length() && compare(sarr, tarr)) {
			if (j-i < ans[0]) {
				ans[0] = j-i;
				ans[1] = i;
				ans[2] = j;
			}
			sarr[s.charAt(i)]--;
			i++;
		}
		if (ans[0] == Integer.MAX_VALUE) {
			return "";
		}
		return s.substring(ans[1], ans[2]);
	}

	private boolean compare(final int[] sarr, final int[] tarr) {
		for (int i=0; i<sarr.length; i++) {
			if (tarr[i] != 0 && sarr[i] < tarr[i]) {
				return false;
			}
		}
		return true;
	}


	public String minWindow_recursive(String s, String t) {
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
// can be done with sliding window
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
