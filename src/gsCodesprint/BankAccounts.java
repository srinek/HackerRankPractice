package gsCodesprint;

import java.util.Scanner;

public class BankAccounts {
	
	private static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
		
		double totalPrice = 0;
		for(int i = 0; i < n; i++){
			totalPrice += Math.max(k, (double)(p[i] * x)/100);
		}
		
		if(totalPrice <= d ){
			return "fee";
		}
		return "upfront";
    }
/*
1
3 20 13 349 
999 899 799
 */
	//129.87 + 116.87 + 103.87  350.61 348
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int d = in.nextInt();
            int[] p = new int[n];
            for(int p_i = 0; p_i < n; p_i++){
                p[p_i] = in.nextInt();
            }
            String result = feeOrUpfront(n, k, x, d, p);
            System.out.println(result);
        }
        in.close();
    }

}
