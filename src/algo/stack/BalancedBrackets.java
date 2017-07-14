package algo.stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	public static char[] OPEN = new char[] { '(', '{', '[' };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String s = in.next();
			if(balancedBracket(s)){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
        in.close();
	}

	public static boolean balancedBracket(String expr) {
		if (expr == null || "".equals(expr)) {
			return false;
		}
		Stack<Character> local = new Stack<>();
		char[] brackets = expr.toCharArray();
		for (char bracket : brackets) {
			if (isOpenBarcket(bracket)) {
				local.push(bracket);
			} else {
				if(local.isEmpty()){
				  return false;		
				}
				char c = local.pop();
				if (c != getMatchingBracket(bracket)) {
					return false;
				}
			}
		}
		if(local.isEmpty()){
			return true;
		}
		return false;
	}

	private static char getMatchingBracket(char bracket) {
		if(bracket == ')'){
			return '(';
		}
		if(bracket == ']'){
			return '[';
		}
		if(bracket == '}'){
			return '{';
		}
		return bracket;
	}

	private static boolean isOpenBarcket(char bracket) {
		for (char open_bracket : OPEN) {
			if (open_bracket == bracket) {
				return true;
			}
		}
		return false;
	}
}
