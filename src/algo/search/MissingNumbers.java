package algo.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MissingNumbers {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int asize = scan.nextInt();
		int index = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while(index++ < asize){
			int aval = scan.nextInt();
			Integer count = map.get(aval);
			if(count == null){
				map.put(aval, 1);	
			}
			else{
				map.put(aval, ++count);
			}
		}
		index = 0;
		int bsize = scan.nextInt();
		List<Integer> missing = new ArrayList<>();
		int missingIndex = 0;
		while(index++ < bsize){
			int bval = scan.nextInt();
			Integer count = map.get(bval);
			if(count == null || count < 1){
				if(!missing.contains(bval)){
					missing.add(bval);
				}
			}
			else{
				map.put(bval, --count);
			}
		}
		Collections.sort(missing);
		int length = missing.size();
		for(int i = 0; i < length; i++ ){
			System.out.print(missing.get(i)+" ");
		}
		scan.close();
	}
	
}
