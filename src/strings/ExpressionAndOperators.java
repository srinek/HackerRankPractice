package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/expression-add-operators/
 * Given a string num that contains only digits and an integer target, return all possibilities to add the binary operators '+', '-', or '*' between the digits of num so that the resultant expression evaluates to the target value.
 *
 *
 *
 * Example 1:
 *
 * Input: num = "123", target = 6
 * Output: ["1*2*3","1+2+3"]
 * Example 2:
 *
 * Input: num = "232", target = 8
 * Output: ["2*3+2","2+3*2"]
 * Example 3:
 *
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * Example 4:
 *
 * Input: num = "00", target = 0
 * Output: ["0*0","0+0","0-0"]
 * Example 5:
 *
 * Input: num = "3456237490", target = 9191
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= num.length <= 10
 * num consists of only digits.
 * -231 <= target <= 231 - 1
 */
public class ExpressionAndOperators {

    public static void main(String[] args) {
        ExpressionAndOperators ops = new ExpressionAndOperators();
        ops.addOperators("123", 6);
    }

    public ArrayList<String> answer;
    public String digits;
    public long target;

    public void recurse(
        int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops) {
        String nums = this.digits;

        // Done processing all the digits in num
        if (index == nums.length()) {

            // If the final value == target expected AND
            // no operand is left unprocessed
            if (value == this.target && currentOperand == 0) {
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                this.answer.add(sb.toString());
            }
            return;
        }

        // Extending the current operand by one digit
        currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
        String current_val_rep = Long.toString(currentOperand);

        // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
        // valid operand. Hence this check
        if (currentOperand > 0) {

            // NO OP recursion
            recurse(index + 1, previousOperand, currentOperand, value, ops);
        }

        // ADDITION
        ops.add("+");
        ops.add(current_val_rep);
        recurse(index + 1, currentOperand, 0, value + currentOperand, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        if (ops.size() > 0) {

            // SUBTRACTION
            ops.add("-");
            ops.add(current_val_rep);
            recurse(index + 1, -currentOperand, 0, value - currentOperand, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            // MULTIPLICATION
            ops.add("*");
            ops.add(current_val_rep);
            recurse(
                index + 1,
                currentOperand * previousOperand,
                0,
                value - previousOperand + (currentOperand * previousOperand),
                ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }

    public List<String> addOperators(String num, int target) {

        if (num.length() == 0) {
            return new ArrayList<String>();
        }

        this.target = target;
        this.digits = num;
        this.answer = new ArrayList<String>();
        this.recurse(0, 0, 0, 0, new ArrayList<String>());
        return this.answer;
    }
}
