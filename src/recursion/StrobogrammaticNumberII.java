package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 * Given an integer n, return all the strobogrammatic numbers that are of length n. You may return the answer in any order.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: ["11","69","88","96"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["0","1","8"]
 */
public class StrobogrammaticNumberII {

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    private List<String> helper(int n, int m) {
        if (n == 0) {
            return List.of("");
        }
        if (n == 1) {
            return List.of("0", "1", "8");
        }
        List<String> list = helper(n-2, n);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (n != m) {
                result.add("0"+str+"0");
            }
            result.add("1"+ str+"1");
            result.add("8"+ str+"8");
            result.add("6"+ str+"9");
            result.add("9"+ str+"6");
        }
        return result;
    }
}
