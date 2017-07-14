package algo.greedy;

import java.util.ArrayList;
import java.util.List;

public class WordWrap {

	//m - line length, words - words to fill
	private static void wordWrap(int m, String[] words){
		
		List<String> lines = new ArrayList<>();
		addToLines(m, words, 0, lines);
		System.out.println(lines);
	}
	
	private static void addToLines(int m, String[] words, int start, List<String> lines){
		if(start >= words.length){
			return;
		}	
		String line = "";
		int i = start;
		int tempM = m;
		while(i < words.length && words[i].length() <= tempM){
			if(line != ""){
				line += " ";
			}
			line += words[i];
			tempM = tempM - (words[i].length()+1);
			i++;
		}
		lines.add(line);
		
		addToLines(m, words, i, lines);
	}
	
	public static void main(String[] args) {
		wordWrap(10, new String[]{"Nanda", "likes", "to", "code"});
	}
}
