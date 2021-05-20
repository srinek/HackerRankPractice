package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-shifted-strings/
 *
 * We can shift a string by shifting each of its letters to its successive letter.
 *
 * For example, "abc" can be shifted to be "bcd".
 * We can keep shifting the string to form a sequence.
 *
 * For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
 * Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
 * Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
 * Example 2:
 *
 * Input: strings = ["a"]
 * Output: [["a"]]
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            if (str.length() == 1) {
                map.computeIfAbsent(" -1", (v) -> new ArrayList<>()).add(str);
                continue;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 1; i < str.length(); i++) {
                int first = Character.getNumericValue(str.charAt(i - 1));
                int second = Character.getNumericValue(str.charAt(i));
                int diff = second - first > 0 ? second - first : second - first + 26;
                key.append(" "+diff);
            }
            map.computeIfAbsent(key.toString(), (v) -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
