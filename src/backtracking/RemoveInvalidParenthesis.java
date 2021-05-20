package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 *
 * Return all the possible results. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 * Example 2:
 *
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 * Example 3:
 *
 * Input: s = ")("
 * Output: [""]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 25
 * s consists of lowercase English letters and parentheses '(' and ')'.
 * There will be at most 20 parentheses in s.
 */
public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        int remL = 0, remR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                remL++;
            } else if (s.charAt(i) == ')') {
                if (remL > 0) {
                    remL--;
                } else {
                    remR++;
                }
            }
        }
        Set<String> set = new HashSet<>();
        dfs(s, new StringBuilder(), set, remL, remR, 0, 0);
        return new ArrayList<>(set);
    }

    private void dfs(String s, StringBuilder out, Set<String> set, int remL, int remR, int open, int index) {
        if (remL < 0 || remR < 0 || open < 0) {
            return;
        }
        if (index == s.length()) {
            if (open == 0 && remL == 0 && remR == 0) {
                set.add(out.toString());
            }
            return;
        }
        int len = out.length();
        char c = s.charAt(index);

        if ( c == '(') {
            dfs(s, out, set, remL - 1, remR, open, index + 1);
            dfs(s, out.append(c), set, remL, remR, open + 1, index + 1);
        } else if (c == ')') {
            dfs(s, out, set, remL, remR - 1, open, index + 1);
            dfs(s, out.append(c), set, remL, remR, open - 1, index + 1);
        } else {
            dfs(s, out.append(c), set, remL, remR, open, index + 1);
        }
        out.setLength(len); //backtrack
    }

    public static void main(String[] args) {
        RemoveInvalidParenthesis i = new RemoveInvalidParenthesis();
        i.removeInvalidParentheses("()())");
    }
}
