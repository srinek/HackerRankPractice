package strings;

public class StringsTest {

	public static void main(String[] args) {
		
		String s = "abc";
		System.out.println(s.substring(0, 3));
		
		System.out.println(s.charAt(2));
		
		System.out.println(replaceLastWithEmpty(s, "bc"));
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
}
