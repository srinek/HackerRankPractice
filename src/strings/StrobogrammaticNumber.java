package strings;

/**
 * https://leetcode.com/problems/strobogrammatic-number/
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 *
 *
 * Example 1:
 *
 * Input: num = "69"
 * Output: true
 * Example 2:
 *
 * Input: num = "88"
 * Output: true
 * Example 3:
 *
 * Input: num = "962"
 * Output: false
 * Example 4:
 *
 * Input: num = "1"
 * Output: true
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int[] map = new int[] {0, 1, -2, -3, -4, -5, 9, -7, 8, 6};
        String snum = new StringBuilder(num).reverse().toString();
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < snum.length(); i++) {
            int intVal = Integer.parseInt(snum.charAt(i)+"");
            newStr.append(map[intVal]);
        }
        return newStr.toString().equals(num);
    }
}
