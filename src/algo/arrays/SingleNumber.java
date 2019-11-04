package algo.arrays;

public class SingleNumber {

	
	public static void main(String[] args) {
		SingleNumber test = new SingleNumber();
		test.singleNumber(new int[]{4,1,2,1,2});
	}
	
	public int singleNumber(int[] nums) {
	    int result = 0;
	    for(int i : nums) {
	    	result ^= i;
	    	System.out.println(result);
	    }
	    return result;
	}
}
