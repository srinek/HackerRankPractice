package basictest;

import java.util.Arrays;
import java.util.Comparator;


public class IntegerTest {
	
	
	LazyClassLoading lz = LazyClassLoading.getInstance();
	public static void main(String[] args) {
		
		
		//System.out.println(lz);
		/*
		System.out.println( Long.parseLong("8A2E", 16));
		System.out.println( Short.parseShort("512"));
		
		System.out.println( Integer.valueOf("100"));
		System.out.println( Integer.valueOf("100"));
		System.out.println( Integer.valueOf("100"));
		*/
		int i = 0x00F;
		int j = 0x2222;
		//System.out.println(i & j);
		//System.out.println(j);
		
		String[] cities = {"Ban", "Pune", "San F", "New Yor"};
		
		Arrays.sort(cities, new MySort());
		
		System.out.println(Arrays.toString(cities));
		
		System.out.println(Arrays.binarySearch(cities, "New Yor"));
	}
	
	static class MySort implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			//return o2.compareTo(o1);
			return o1.compareTo(o2);
		}
		
	}

}
