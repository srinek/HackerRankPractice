package algo.arrays;

/**
 * https://leetcode.com/problems/maximum-swap/
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 */
public class MaximumSwap {

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] max = new int[10];
        for (int i = 0; i < chars.length; i++) {
            max[chars[i] - '0'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int d = 9; d > chars[i] - '0'; d--) {
                if (max[d] > i) {
                    char t = chars[max[d]];
                    chars[max[d]] = chars[i];
                    chars[i] = t;
                    return Integer.valueOf(String.valueOf(chars));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap s = new MaximumSwap();
        s.maximumSwap(2376);
    }
}
