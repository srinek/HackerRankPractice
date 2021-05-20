package trees;

import java.util.Stack;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-string/
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 *
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 *
 * You always start to construct the left child node of the parent first if it exists.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "4(2(3)(1))(6(5))"
 * Output: [4,2,6,3,1,5]
 * Example 2:
 *
 * Input: s = "4(2(3)(1))(6(5)(7))"
 * Output: [4,2,6,3,1,5,7]
 * Example 3:
 *
 * Input: s = "-4(2(3)(1))(6(5)(7))"
 * Output: [-4,2,6,3,1,5,7]
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s consists of digits, '(', ')', and '-' only.
 */
public class ConstructBinaryTreeFromString {

    public static void main(String[] args) {
        ConstructBinaryTreeFromString i = new ConstructBinaryTreeFromString();
        TreeNode n = i.str2tree("4(2(3)(1))(6(5))");
        System.out.println(n);
    }

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int firstParen = s.indexOf('(');
        int rootVal = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode root = new TreeNode(rootVal);
        if (firstParen == -1) {
            return root;
        }
        int count = 0;
        char[] chars = s.toCharArray();
        int start = firstParen;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] != '(' && chars[i] != ')') {
                continue;
            }
            if (chars[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                if (start == firstParen) {
                    root.left = str2tree(s.substring(start + 1, i));
                    start = i + 1;
                } else {
                    root.right = str2tree(s.substring(start + 1, i));
                }
            }
        }
        return root;
    }
}
