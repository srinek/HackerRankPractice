package basictest;

public class MinCoins {

	
	// 16   = 10 ,  5 , 1
	
	
	public static void main(String[] args) {
		System.out.println(findCoins(81) );
	}
	
	public static int findCoins(int num){
		
		int count = 0;
		int[] coins = new int[] {25, 10, 5, 1};
		for(int i=0; i< coins.length; i++){
			
			if(num < coins[i]){
				continue;
			}
			
			
			
			num = num  - coins[i];
			i--;
			count++;
		}
		
		return count;
	}
}
