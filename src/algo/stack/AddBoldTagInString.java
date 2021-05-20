package algo.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/add-bold-tag-in-string/
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 * Example 1:
 *
 * Input:
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 *
 *
 * Example 2:
 *
 * Input:
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 *
 *
 * Constraints:
 *
 * The given dict won't contain duplicates, and its length won't exceed 100.
 * All the strings in input have length in range [1, 1000].
 * Note: This question is the same as 758: https://leetcode.com/problems/bold-words-in-string/
 */
public class AddBoldTagInString {

    class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public String toString() {
            return "[" + i + ", " + j + "]" ;
        }
    }
    public String addBoldTag(String s, String[] dict) {
        List<Pair> list = new ArrayList<>();
        for (String d: dict) {
            int index = s.indexOf(d, 0);
            while (index != -1) {
                list.add(new Pair(index, index + d.length()));
                index = s.indexOf(d, index + 1);
            }
        }
        Stack<Pair> stack = merge(list);
        StringBuilder sb = new StringBuilder();
        int i = s.length();
        while(!stack.isEmpty()) {
            Pair temp = stack.pop();
            sb.insert(0, s.substring(temp.j, i));
            sb.insert(0, "</b>");
            sb.insert(0, s.substring(temp.i, temp.j));
            sb.insert(0, "<b>");
            i = temp.i;
        }
        sb.insert(0, s.substring(0, i));
        return sb.toString();
    }

    private Stack<Pair> merge(List<Pair> list) {
        Collections.sort(list, (o1, o2) -> o1.i - o2.i);
        Stack<Pair> stack = new Stack<>();
        for (Pair p: list) {
            if (stack.isEmpty()) {
                stack.push(p);
            } else {
                if(p.i <= stack.peek().j) {
                    Pair temp = stack.pop();
                    temp.i = Math.min(temp.i, p.i);
                    temp.j = Math.max(temp.j, p.j);
                    stack.push(temp);
                } else {
                    stack.push(p);
                }
            }
        }
        return stack;
    }
}
