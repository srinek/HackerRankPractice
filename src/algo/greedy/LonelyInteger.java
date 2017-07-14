package algo.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LonelyInteger {
	
	
	private static int lonelyInteger(int[] a) {
      
		if(a.length == 0){
			return 0;
		}
		if(a.length == 1){
			return a[0];
		}
		List<Integer> ret = new ArrayList<>();
		
		for(int i : a){
			if(!ret.contains(i)){
				ret.add(i);	
			}
			else{
				ret.remove(new Integer(i));
			}
		}
		return ret.get(0);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }

}
