package careercup;

import java.util.LinkedList;

/*
 * https://www.careercup.com/question?id=5199653285396480
 */

public class AdditionUsingTwoLinkedLists {
	
	public static void main(String[] args){
		
		AdditionUsingTwoLinkedLists adder = new AdditionUsingTwoLinkedLists();
		LinkedList<Integer> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();
		l1.offer(1);
		l1.offer(2);
		l1.offer(3);
		l2.offer(4);
		l2.offer(2);
		System.out.println(adder.add(l1, l2));
		
	}
	
	public static LinkedList<Integer> add(LinkedList<Integer> l1, LinkedList<Integer> l2){
		
		
		
		if(l1.size() == 0){
			return l2;
		}
		if(l2.size() == 0){
			return l1;
		}
		LinkedList<Integer> result = new LinkedList<>();
		int i=0, j=0;
		int pass = 0;
		int tempValue = 0;
		int l1Size = l1.size();
		int l2Size = l2.size();
		while(i < l1Size && j < l2Size){
			tempValue = add(l1.poll(), l2.poll(), pass);
			if(tempValue >= 10){
				tempValue = tempValue % 10;
				pass = 1;
			}
			else{
				pass = 0;
			}
			result.offerFirst(tempValue);
			i++; j++;
		}
		while(i<l1Size){
			tempValue = add(l1.poll(), 0, pass);
			if(tempValue >= 10){
				tempValue = tempValue % 10;
				pass = 1;
			}
			else{
				pass = 0;
			}
			result.offerFirst(tempValue);
			i++;
		}
		while(j < l2Size){
			tempValue = add(0, l2.poll(), pass);
			if(tempValue >= 10){
				tempValue = tempValue % 10;
				pass = 1;
			}
			else{
				pass = 0;
			}
			result.offerFirst(tempValue);
			j++;
		}
		result.offerFirst(pass);
		return result;
	}

	private static int add(Integer first, Integer second, int pass) {
		return first + second + pass;
	}

}
