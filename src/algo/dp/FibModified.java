package algo.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibModified {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    BigInteger t1 = new BigInteger(scan.nextInt()+"");
	    BigInteger t2 = new BigInteger(scan.nextInt()+"");
	    int n = scan.nextInt();
	    System.out.println(t1);
	    System.out.println(t2);
	    //System.out.println(t1.add(t2));
	    BigInteger temp = new BigInteger("0");
	    for(int i=3;i<=n;i++){
	        temp = t2;
	        //t2 = t2.multiply(t2);
	        t2 = t2.add(t1);
	        t1 = temp;
	        //System.out.println(t2);
	    }
	    scan.close();
	    System.out.println(t2);
	}
	
	/*public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    BigInteger t1 = new BigInteger(scan.nextInt()+"");
	    BigInteger t2 = new BigInteger(scan.nextInt()+"");
	    int n = scan.nextInt();

	    BigInteger temp = new BigInteger("0");
	    for(int i=3;i<=n;i++){
	        temp = t2;
	        t2 = t2.multiply(t2);
	        t2 = t2.add(t1);
	        t1 = temp;
	        System.out.println(t2);
	    }
	    scan.close();
	    
	}*/
	
	

	/*public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		BigInteger t1 = new BigInteger(scan.nextInt()+"");
		BigInteger t2 = new BigInteger(scan.nextInt()+"");
		BigInteger n = new BigInteger(scan.nextInt()+"");
		scan.close();
		
		Map<BigInteger, BigInteger> memo = new HashMap<>();
		System.out.println(fib(n.subtract(new BigInteger("1")), t1, t2, memo));
		//System.out.println(Float.MAX_VALUE);
	}
	
	private static BigInteger fib(BigInteger n, BigInteger t1, BigInteger t2, Map<BigInteger, BigInteger> memo){
		
		if(memo.get(n) != null){
			return memo.get(n);
		}
		
		if(n.equals(t1)){
			memo.put(n, t1);
			//System.out.println(t1);
			return t1;
		}
		if(n.equals(t2)){
			memo.put(n, t2);
			//System.out.println(t2);
			return t2;
		}
		BigInteger _one = fib(n.subtract(new BigInteger("1")), t1, t2, memo);
		memo.put(n.subtract(new BigInteger("1")), _one);
		BigInteger _two = fib(n.subtract(new BigInteger("2")), t1, t2, memo);
		memo.put(n.subtract(new BigInteger("2")), _two);
		BigInteger result = (_one.multiply(_one)).add(_two);
		//System.out.println(result);
		return result;
	}*/
}
