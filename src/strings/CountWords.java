package strings;

public class CountWords {

	
	private static int countWords(String s){
		
		if(s == null){
			return 0;
		}
		s = s.trim();
		if(s.length() == 0){
			return 0;
		}
		char[] chars = s.toCharArray();
		int wordcount = 1;
		for(char c : chars){
			if(c == ' '){
				++wordcount;
			}
		}
		return wordcount;
	}
	
	public static void main(String[] args) {
		System.out.println(countWords(" This is a String "));
		System.out.println(countWords(" ThisisaString "));
		System.out.println(countWords("This is "));
		System.out.println(countWords("This      is "));
	}
}
