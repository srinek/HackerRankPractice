package basictest;

import java.util.ArrayList;
import java.util.List;

public class RunOutOfMemory {
	
	
	public static void main(String[] args){
		
		List<String> numbers = new ArrayList<>();
		System.out.println("Memory before " + Runtime.getRuntime().freeMemory());

		for(int i=0; i<100000000; i++){
			
			numbers.add((i*10000000)+"");
		}
		System.out.println("Memory After " + Runtime.getRuntime().freeMemory());
		//System.out.println(numbers);
	}

}
