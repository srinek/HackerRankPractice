package recursion;

public class TotalWaytoClimbStairCase {
	
	public static void main(String[] args) {
		
		TotalWaytoClimbStairCase totalWays = new TotalWaytoClimbStairCase();
		//System.out.println(totalWays.findWays(4, new int[]{1,2}));
		System.out.println(steps(4));
	}

	private static int steps(int n) {
		if(n<0){
			return 0;
		}
		if(n == 0){
			return 1;
		}
		return steps(n-1) + steps(n-2);
	}
	
	private static int stepsdp(int n) {
		
		int[] steps = new int[n+1];
		
		for(int i=0; i<n+1; i++){
			if(i == 0 || i == 1){
				steps[i] = 1;
			}
			else{
				steps[i] = steps[i-1] + steps[i-2]; 
			}
		}
		
		return steps[n];
		
	}
	
	/*public int findWays(int n, int[] steps){
		
		if(n == 0){
			return 1; // reached
		}
		if(n < 0){
			return 0; //  not reached
		}
		int count = 0;
		for(int step : steps){
			int remaining = n-step;
			count += findWays( remaining, steps);
	
		}
		return count;
	}*/

	
	/*f(2)
	
	f(1) f(0)
	f(0) f(-1)*/
}
