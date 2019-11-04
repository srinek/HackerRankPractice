package algo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWords {
	
	public static void main(String[] args) {
		countWords("");
	}

	public static void countWords(String stream){
		
		stream = "this,is,a,word";
		String regEx = "(.*,)";
		Pattern p = Pattern.compile(regEx);
		Matcher matcher = p.matcher(stream);
	    while(matcher.find()){
	    	System.out.println(matcher.group());
	    }
	}
}
