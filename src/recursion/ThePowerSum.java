package recursion;

import java.util.Scanner;

public class ThePowerSum {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int n = scan.nextInt();
		/*int max = 1;
		int pow = (int)Math.pow(max, n);
		while(pow <= x){
			max = max + 1;
			pow = (int)Math.pow(max, n);
		}
		System.out.println(powsum(x, n, --max));*/
		System.out.println(powsum(x, n, 1));
		scan.close();
	}
	
	private static int powsum(int x, int n, int start){
		
		int tempX = x - (int)Math.pow(start, n);
		
		if(tempX == 0){
			return 1;
		}
		if(tempX < 0){
			return 0;
		}
		int incr = ++start;
		return powsum(tempX, n, incr) + powsum(x, n, incr);
	}
	
	/*
	  ( 10, 1)
	  (9, 2)+(10, 2)
	  (5, 3)+(9, 3)+(6,3)+(10,3)
	  0+ 1+0+(1, 4)+(10,4)
	  0+1+0+0+0
	  
	 * 
	 */
	
	
	/*private static int powsum(int x, int n, int start){
		x = x - (int)Math.pow(start, n);
		if(x == 0){
			return 1;
		}
		if(x < 0){
			return 0;
		}
		int sum = 0;
		for(int j = start+1; Math.pow(j, n) <= x; j++){
			sum += powsum(x, n, j);
		}
		return sum;
	}*/
	
	
	
	/*private static int powsum(int x, int n, int max){
		int result = 0;
		if(max == 0){
			return 0;
		}
		int power = (int)Math.pow(max, n);
		if(power == x){
			result++;
		}
		int reminder = x - power;
		int start = max -1;
		int temp = matchReminder(start, n, reminder);
		while(temp == 0 && start > 0){
			start--;
			temp = matchReminder(start, n, reminder);
		}
		
		if(temp == 1){
			result++;
		}
		result += powsum(x, n, max -1);
		return result;
	}
	
	private static int matchReminder(int start, int n, int reminder){
		int sum = 0;
		for(int j = start; j > 0; j--){
		   int temp = (int)Math.pow(j, n); 	
		   if(sum + temp > reminder){
			   continue;
		   }
		   sum += temp;
		   if(sum == reminder){
			  return 1;
		   }
		}
		return 0;
	}*/

}
