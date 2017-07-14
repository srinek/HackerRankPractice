package algo.dp;

/*Problem Statement: On a positive integer, you can perform any one of the following 3 steps. 1.) Subtract 1 from it. ( n = n - 1 )  , 2.) If its divisible by 2, divide by 2. 
 * ( if n % 2 == 0 , then n = n / 2  )  , 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ). Now the question is, given a positive integer n, 
 * find the minimum number of steps that takes n to 1
eg: 1.)For n = 1 , output: 0       2.) For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )    3.)  For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )*/

public class MinStepsToOne {

	private static int[] cache = null;
	
	public static void main(String[] args) {
		
		System.out.println(getMinStepsBottomUp(10000000));
		
	}
	
	//seems like cache never used and fails with stackoverflow...
	private static int getMinStepsMemoize(int n){
		
		if(cache == null){
			cache = new int[n+1]; // first time
		}
		if(n == 1){
			cache[n] = 0;
			return 0;
		}
		if(cache[n] != 0 ){
			System.out.println("n = "+n+"  "+cache[n]+"");
			return cache[n];
		}
		int result = 1 + getMinStepsMemoize(n-1);
		if(n%2 == 0){
			result = Math.min(result, 1+cache[n/2]);
		}
		if(n%3 == 0){
			result = Math.min(result, 1+cache[n/3]);
		}
		cache[n] = result;
		return result;
	}
	
	private static int getMinStepsBottomUp(int n){
	    if(n == 0){
	    	return 0;
	    }
		int[] arr = new int[n+1];
		arr[1] = 0;
		
		for(int i = 2; i <= n; i++){
			
			int result = 1 + arr[i-1];
			
			if(n % 2 == 0){
				result = Math.min(result, 1 + arr[i/2]);
			}
			
			if(n % 3 == 0){
				result = Math.min(result, 1 + arr[i/3]);
			}
			arr[i] = result;
		}
		return arr[n];
	}
}
