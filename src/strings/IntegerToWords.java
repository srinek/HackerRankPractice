package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 * Convert a non-negative integer num to its English words representation.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 *
 * Input: num = 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class IntegerToWords {

    private static String[] ones = new String[] {
        "",
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine"
    };
    private static String[] _ltens = new String[] {
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen"
    };
    private static String[] _lhun = new String[] {
        "",
        "",
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninety"
    };

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        return helper(num).trim();
    }

    public String helper(int num) {
        StringBuilder result = new StringBuilder();
        if (num < 10) {
            result.append(ones[num]);
        } else if (num < 20) {
            result.append(_ltens[num%10]);
        } else if (num < 100) {
            result.append(_lhun[num / 10]);
            result.append(" ");
            result.append(ones[num % 10]);
        } else if (num < 1000) {
            result.append(ones[num / 100]);
            result.append(" Hundred ");
            result.append(helper(num % 100));
        } else if (num < 1000000) {
            result.append(helper(num / 1000));
            result.append(" Thousand ");
            result.append(helper(num % 1000));
        } else if (num < 1000000000) {
            result.append(helper(num / 1000000));
            result.append(" Million ");
            result.append(helper(num % 1000000));
        } else {
            result.append(helper(num / 1000000000));
            result.append(" Billion ");
            result.append(helper(num % 1000000000));
        }
        return result.toString().trim();
    }
}
