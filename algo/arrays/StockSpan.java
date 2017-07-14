package algo.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class StockSpan {

	
	public static void main(String[] args) {
		StockSpan.stockInput(new int[]{ 4, 5, 10, 9, 3, 4, 5,6, 7, 8});
	}
	
     // 3 4 5 10 9 3 4 7 8
	public static void stockInput(int[] input){
		
	
		int local = 0;
		List<Integer> retList = new ArrayList<>();
		int ret = 0;
		for(int k : input){
			if(k > local){
		    	ret++;
		    }
		    else{
		    	retList.add(ret);
		    	ret = 0;
		    }
		    local = k;
		}
		retList.add(ret);
		System.out.println(retList);
	}

}
