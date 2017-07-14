package algo.stack;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfOps = scan.nextInt();
		Stack<StackVal> undoStack = new Stack<>();
		String text = "";
		while(noOfOps-- > 0){
			int nextOp = scan.nextInt();
			if(nextOp == 1){
				text = append(undoStack, scan.next(), text);
				continue;
			}
			if(nextOp == 2){
				text = delete(undoStack, scan.nextInt(), text);
				continue;
			}
			if(nextOp == 3){
				print(text, scan.nextInt());
				continue;
			}
			if(nextOp == 4){
				text = undo(undoStack, text);
			}
			//index++;
		}
		//System.out.println(" doneeeeeeeeeeee");
		scan.close();
	}
	
	public static String undo(Stack<StackVal> undoStack, String text){
		if(undoStack.isEmpty()){
			return text;
		}
		StackVal undoVal = undoStack.pop();
		if(undoVal.op == 1){
			text = replaceLastWithEmpty(text, undoVal.val);
			return text;
		}
		return text+undoVal.val;
		
	}
	
	private static String replaceLastWithEmpty(String orig, String match)
	{
	  int index = orig.lastIndexOf(match);
	  if (index == -1){
		  return orig;
	  }
	  return orig.substring(0, index) + ""
	          + orig.substring(index+match.length());
	}
	
	public static void print(String text, int printchar){
		if(text.length() >= printchar){
			System.out.println(text.charAt(printchar-1));
		}
		else{
			//System.out.println("print char out of range");
		}
	}
	
	public static String delete(Stack<StackVal> undoStack, int del, String text){
		String deletedText = "";
		if(text.length() - del < 0){
			deletedText = text;
			text = "";
		}
		else{
			deletedText = text.substring(text.length() - del, text.length());
			text = text.substring(0, text.length() - del);
		}
		StackVal stackVal = new StackVal(2, deletedText);
		undoStack.push(stackVal);
		return text;
	}
	
	public static String append(Stack<StackVal> undoStack, String val, String text){
		StackVal stackVal = new StackVal(1, val);
		undoStack.push(stackVal);
		text = text + val;
		return text;
	}
	
	public static class StackVal{
		public int op;
		public String val;
		public StackVal(int op, String val) {
			super();
			this.op = op;
			this.val = val;
		}
	}
}
