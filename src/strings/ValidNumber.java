package strings;

import java.math.BigDecimal;

/**
 * https://leetcode.com/problems/valid-number/
 *
 * A valid number can be split up into these components (in order):
 *
 * A decimal number or an integer.
 * (Optional) An 'e' or 'E', followed by an integer.
 * A decimal number can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 * At least one digit, followed by a dot '.'.
 * At least one digit, followed by a dot '.', followed by at least one digit.
 * A dot '.', followed by at least one digit.
 * An integer can be split up into these components (in order):
 *
 * (Optional) A sign character (either '+' or '-').
 * At least one digit.
 * For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 *
 * Given a string s, return true if s is a valid number.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "0"
 * Output: true
 * Example 2:
 *
 * Input: s = "e"
 * Output: false
 * Example 3:
 *
 * Input: s = "."
 * Output: false
 * Example 4:
 *
 * Input: s = ".1"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        return isDecimal(s) || isInteger(s, false);
    }

    private boolean isDecimal(String s) {
        if (s.equals("")) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        int dot = s.indexOf(".");
        if (dot == -1) {
            return false;
        }
        String before = s.substring(0, dot);
        String after = s.substring(dot + 1);
        if ("".equals(before)) {
            return integerHelper(after, false);
        }
        if ("".equals(after)) {
            return integerHelper(before, true);
        }
        boolean eSeen = false;
        if (after.charAt(0) == 'e' || after.charAt(0) == 'E') {
            after = after.substring(1);
            eSeen = true;
            if (after.length() > 0 && (after.charAt(0) == '+' || after.charAt(0) == '-')) {
                after = after.substring(1);
            }
        }
        return integerHelper(before, true) && integerHelper(after, eSeen);
    }

    private boolean isInteger(String s, boolean eSeen) {
        if (s.equals("")) {
            return false;
        }
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        return integerHelper(s, eSeen);
    }

    private boolean integerHelper(String s, boolean eSeen) {
        if (s.equals("")) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (( s.charAt(i) == 'e' || s.charAt(i) == 'E') && i != 0 && !eSeen) {
                return isInteger(s.substring(i + 1), true);
            }
            if (!Character.isDigit(s.charAt(i)) ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidNumber v = new ValidNumber();
        System.out.println(v.isNumber("123"));
        System.out.println(v.isNumber("12e2"));
        System.out.println(v.isNumber("12e+342"));
        System.out.println(v.isNumber("+12e+342"));
        System.out.println(v.isNumber("+12e-342"));
        System.out.println(v.isNumber("+12rt342"));
        System.out.println(v.isNumber("+12e+-342"));
        System.out.println(v.isNumber("+-12e+342"));
        System.out.println(v.isNumber("12e34e43"));
        System.out.println(v.isNumber("12ee"));
        System.out.println(v.isNumber("12e"));
        System.out.println();
        System.out.println(v.isNumber("12.12"));
        System.out.println(v.isNumber("-12.12"));
        System.out.println(v.isNumber(".12"));
        System.out.println(v.isNumber("-.12"));
        System.out.println(v.isNumber("12."));
        System.out.println(v.isNumber("12.e12"));
        System.out.println(v.isNumber("12.e+12"));
        System.out.println(v.isNumber("+12.e12"));
        System.out.println(v.isNumber("12.e-12"));
        System.out.println(v.isNumber("+-12.e12"));
        System.out.println(v.isNumber("12.+12"));
        System.out.println(v.isNumber("12.e"));
    }
}
