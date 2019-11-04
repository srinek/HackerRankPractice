package algo.dp;


/*
 * Frog steps either 1, 2 or 3 steps to go to top. In how many ways it reaches the top?
 * how many ways a Frog can reach distance 5 using steps 1,2,3.
 */


public class CountNumberOfHops {

	private int recursion(int distance, int[] steps){
		
		if(distance < 0){
			return 0;
		}
		if(distance == 0){
			return 1;
		}
		
		
		int totalSteps = 0;
		for(int step : steps){
			totalSteps += recursion(distance-step, steps);
		}
		
		return totalSteps;
	}
	
	private int dp(int distance, int[] steps){
		
		int[] sol = new int[distance+1];
		sol[0] = 1;  //base condition
		for(int dist=1; dist <= distance; dist++){
			for(int stepIndex=0; stepIndex < steps.length; stepIndex++){
				if(dist - steps[stepIndex] >= 0){
					 sol[dist] += sol[dist - steps[stepIndex]];
				}
			}
		}
		
		return sol[distance];
	}
	
	public static void main(String[] args) {
		CountNumberOfHops hops = new CountNumberOfHops();
		System.out.println(hops.recursion(5, new int[]{1,2,3}));
		System.out.println(hops.dp(5, new int[]{1,2,3}));
	}
	
}
