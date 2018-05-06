package basictest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {

	public static void main(String[] args) {
		String[] s = mergeArrays(new String[]{"1"}, new String[]{"2"});
		System.out.println(Arrays.toString(s));
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
}

