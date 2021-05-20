package algo.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && t[i] > t[stack.peek()]) {
                    int ri = stack.pop();
                    result[ri] = i - ri;
                }
                stack.push(i);
            }
        }
        return result;
    }
}
