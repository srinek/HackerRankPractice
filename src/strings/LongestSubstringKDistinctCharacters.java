package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 *
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * 0 <= k <= 50
 */
public class LongestSubstringKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if ( s.length() == 0 || k == 0) {
            return 0;
        }
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        while ( j < s.length() ) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            result = Math.max(result, j-i+1);
            j++;
        }
        return result;
    }
}
