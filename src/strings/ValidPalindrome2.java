package strings;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {

        int low = 0;
        int high = s.length() - 1;
        while (low < high) {

            if (s.charAt(low) == s.charAt(high)) {
                low++;
                high--;
            } else {
                if (isPalindrome(s, low + 1, high) || isPalindrome(s, low, high - 1)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
