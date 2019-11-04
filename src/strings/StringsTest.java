package strings;

import java.lang.reflect.Field;
import java.util.Arrays;

public class StringsTest {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		String s = "abc";
		System.out.println(s.substring(0, 0));
		
		//System.out.println(s.charAt(2));
		
		String s1 = "dsdsd,dsfdsfsd,,";
		
		//System.out.println(Arrays.toString(s1.split(",")));
		
		//System.out.println(replaceLastWithEmpty(s, "bc"));
		
		//internTest();
		
		substringTest();
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
	
	private static void internTest(){
		
		String a = new String("abc");
		String b = new String("abc");
		String aIntern = a.intern();
		String bIntern = b.intern();
		System.out.println(aIntern == bIntern);
	}
	
	private static void substringTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		 //Our main String
        String mainString = "i_love_java";
        //Substring holds value 'java'
        String subString = mainString.substring(7);
 
        System.out.println(mainString);
        System.out.println(subString);
 
        //Lets see what's inside mainString
        Field innerCharArray = String.class.getDeclaredField("value");
        innerCharArray.setAccessible(true);
        char[] chars = (char[]) innerCharArray.get(mainString);
        System.out.println(Arrays.toString(chars));
 
        //Now peek inside subString
        chars = (char[]) innerCharArray.get(subString);
        System.out.println(Arrays.toString(chars));
	}
}
