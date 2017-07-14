package recursion;

import java.math.BigInteger;
import java.util.Scanner;

public class RecursiveDigitSum {

	public static BigInteger _10 = new BigInteger("10");
	public static int counter = 0;
	public static void main(String[] args) {

           Scanner scan = new Scanner(System.in);
           //BigInteger n =  new BigInteger(scan.next()+"");;
           String n = scan.next();
           int k = scan.nextInt();
     
           long sum=0;
           for(int i=0;i<n.length();i++)
               {
               sum+=(n.charAt(i)-48);
           }

           sum*=k;

           if(sum%9==0)
               System.out.println(9);

           else
               System.out.println(sum%9);
           
           /*System.out.println(super_digit(getSumOfDigits(n, k)));
           System.out.println(counter);*/
           scan.close();
	}
	
	/*private static BigInteger getSumOfDigits(BigInteger n, int k){
		BigInteger sum = new BigInteger("0");
		
		if(k == 0){
			return sum;
		}
		sum = super_digit(n);
		//sum += getSumOfDigits(n, --k);
		sum = sum.multiply(new BigInteger(k+""));;
		return sum;
	}

	private static BigInteger super_digit(BigInteger n) {
		counter++;
		if(n.bitCount() == 0){
			return new BigInteger("0");
		}
		BigInteger mod = n.mod(_10);
		n = n.divide(_10);
		mod = mod.add(super_digit(n));
		if(mod.intValue() > 9){
			mod = super_digit(mod);
		}
		return mod;
	}*/
}
