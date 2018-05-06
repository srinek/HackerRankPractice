package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {

	
	public static void main(String[] args) {
		
		String str = "beabeefeab".replaceAll("[^be]", "");
		System.out.println(str);
		
		String s = "The reason provided by the Program Manager was #REASON#.";
		Pattern p = Pattern.compile("(#[\\w-]+#)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(s);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			System.out.println(matcher.group(1).toUpperCase());
			 String replacement = "Friday grossed $6,589,341 on its opening weekend debuting at #2 in the bo";
	    	 replacement = replacement.replaceAll("[$]", "\\\\A");
	    	 System.out.println(replacement);
	    	 matcher.appendReplacement(sb, replacement);
		 }
		 matcher.appendTail(sb);
		 
	}
}
