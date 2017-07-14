package algo.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

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
			
			//List<Integer> newarr = new ArrayList<>();
			int prev = Integer.MAX_VALUE;
			int tempprev = Integer.MAX_VALUE;
	        Map<Integer, Integer> output = new HashMap<>();
			int lastday = 1;
			for(int a : array){
				if(a <= prev){
					//newarr.add(a);
					prev = a;
					tempprev = a;
					resetStacks(output);
				}
				else{
					if(a > tempprev){
	                   //Integer stack = output.get(1);
	                   output.put(1, a);
	                }
					else{
						int tempday = 2;
						boolean matchFound = false;
						while(output.get(tempday) == -1){
							Integer stack = output.get(tempday);
							int top = 0;//stack.peek();
							if(a > top){
								//output.get(tempday - 1).push(a);
								matchFound = true;
								break;
							}
							tempday++;
						}
						if(!matchFound){
							output.put(tempday, a);
							if(tempday > lastday){
								lastday = tempday;
							}
						}
					}
					tempprev = a;
				}
			}
			return lastday;
		}

		private static void resetStacks(Map<Integer, Integer> output) {
			
			for(int i : output.keySet()){
				Stack<Integer> s = null;//output.get(i);
				while(!s.isEmpty()){
					s.pop();
				}
			}
			
		}
}
