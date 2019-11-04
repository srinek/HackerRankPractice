package basictest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class ArraysTest {

	public static void main(String[] args) {
		String[] s = mergeArrays(new String[]{"1"}, new String[]{"2"});
		// System.out.println(Arrays.toString(s));
		Random random = new Random();

        int id1 = random.nextInt(100);//3
		// System.out.println("math random " + id1);
        
        testTreeMap();
	}
	
	private static <T> T[] mergeArrays(T[] obj1, T[] obj2){
		List<T> temp = new ArrayList<>();
		for(T t : obj1){
			temp.add(t);
		}
		for(T t : obj2){
			temp.add(t);
		}
		//temp.toArray(new T[temp.size()]);
		return null;
	}
	
	
	private static void testTreeMap(){
		
		List<String> list = new ArrayList<>();
		
		list.add("Row 5 was not processed because of the user (billackerman@ieee.org) you are trying to invite has not accepted the IEEE Privacy Policy providing consent to be contacted, and so cannot be added to the roster");
		list.add("Row 4 was not processed because of the user (michaelhabrahamsen@eaton.com) you are trying to invite has not accepted the IEEE Privacy Policy providing consent to be contacted, and so cannot be added to the roster");
		list.add("Row 18 was not processed because of the user (carlo66@att.net) you are trying to invite has not accepted the IEEE Privacy Policy providing consent to be contacted, and so cannot be added to the roster");
		
		Collections.sort(list , new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				if(o1 == null || o2 == null){
					return 0;
				}
				int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
				if(o1.startsWith("Row")){
					String[] splittedStrs = o1.split(" ");
					num1 =  safeParseInt(splittedStrs[1]);
				}
				if(o2.startsWith("Row")){
					String[] splittedStrs = o2.split(" ");
					num2 =  safeParseInt(splittedStrs[1]);
				}
				
				return num1-num2;
			}
			
		});
		
		System.out.println(list);
	}
	
	private static int safeParseInt(String num){
		
		try{
			return Integer.parseInt(num);
		}
		catch(NumberFormatException e){
			return Integer.MAX_VALUE;
		}
	}
}

