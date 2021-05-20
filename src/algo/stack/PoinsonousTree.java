package algo.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/poisonous-plants/problem
 */
public class PoinsonousTree {

	 public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			int total = scan.nextInt();
			Integer[] array = new Integer[total];
			int index = 0;
			while(index < total){
				array[index] = scan.nextInt();
				index++;
			}
			scan.close();
			System.out.println(findGoodDay(array));
		}
		
	public static int findGoodDay(Integer[] array){
	   
		if(array.length == 0){
			return 0;
		}
		int[] deathDay = new int[array.length];
		deathDay[0] = 0;
		int minThusFar = array[0];
		Stack<Integer> stack = new Stack<>();
		int totaldays = 0;
		for(int i = 1; i < array.length; i++){
			if(array[i] > array[i-1]){
				deathDay[i] = 1;
			}
			if(array[i] < minThusFar){
				minThusFar =  array[i];
			}
			if(array[i] > minThusFar){  // true means this tree will die one day.
				while(!stack.isEmpty() && array[i] <= array[stack.peek()]){
					deathDay[i] =  deathDay[i] > deathDay[stack.peek()] + 1 ? deathDay[i] : deathDay[stack.peek()] + 1; 
					stack.pop();
				}
			}
			stack.push(i);
			totaldays = deathDay[i] > totaldays ? deathDay[i] : totaldays;
		}
		
		return totaldays;
	 		
	}

}
