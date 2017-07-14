package algo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWords {

	public void countWords(String stream){
		
		stream = "this,is,a,word";
		String regEx = "^.*[^,]";
		Pattern p = Pattern.compile(regEx);
		Matcher matcher = p.matcher(stream);
	
	}
}
