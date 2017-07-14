package algo.warmup;

import java.math.BigDecimal;
import java.util.Scanner;

/*Sample Input

6
-4 3 -9 0 4 1         
Sample Output

0.500000
0.333333
0.166667
Explanation

There are 3 positive numbers, 2 negative numbers, and 1 zero in the array. 
The respective fractions of positive numbers, negative numbers and zeroes are 3/6, 2/6 and ,1/6 respectively.*/

public class PlusMinus {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int index = 0;
		int poscnt = 0, negcnt = 0, zerocnt =0;
		while(index++ < total){
			int nextVal = scan.nextInt();
			if(nextVal < 0){
				negcnt++;
			}
			if(nextVal == 0){
				zerocnt++;
			}
			if(nextVal > 0){
				poscnt++;
			}
		}
		BigDecimal pos = new BigDecimal(poscnt);
		BigDecimal neg = new BigDecimal(negcnt);
		BigDecimal zero = new BigDecimal(zerocnt);
		BigDecimal tot = new BigDecimal(total);
		System.out.println(pos.divide(tot, 6, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println(neg.divide(tot, 6, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println(zero.divide(tot, 6, BigDecimal.ROUND_HALF_UP).doubleValue());
		scan.close();
	}
}
