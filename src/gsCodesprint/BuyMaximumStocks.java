package gsCodesprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BuyMaximumStocks {
	
	
	static long buyMaximumProducts(int n, long k, int[] a) {
		
	  /*  long total = includeExclude(k, a, a.length-1);
	    return total;*/
		
		return dpSol(n, k, a);
	    		
	}
	
	/*private static long includeExclude(long remaining,  int[] a, int i){
		if(remaining <= 0 || i < 0){
			return 0;
		}
		long buyPower = remaining / a[i];
        long allowed = Math.min(i+1, buyPower);
        return Math.max(allowed+includeExclude(remaining - (allowed * a[i]), a, i-1), includeExclude(remaining, a, i-1));
	}*/
	
	/*private static long dpSol(int n, long k, int[] a){
		
		int[][] mn = new int[n+1][k+1];
		
		for(int i = 0;i< mn.length; i++){
			for(int j = 0; j < mn[i].length; j++){
				if(i == 0 || j == 0){
					mn[i][j] = 0;
					continue;
				}
				if(a[i-1] <= j ){
					int buyPower = j / a[i-1];
			        int allowed = Math.min(i, buyPower);
			        int remaining = j-allowed*a[i-1];
			        int max1 = allowed + mn[i-1][remaining];
			        for(int l = 1; l <= allowed; l++){
			        	remaining = j-l*a[i-1];
			        	int lmax = l + mn[i-1][remaining];
			        	max1 = Math.max(lmax, max1);
			        }
			        
			        mn[i][j] = Math.max( max1, mn[i-1][j]); 
				}
				else{
					mn[i][j] = mn[i-1][j];
				}
				
			}
		}
		for(int i = 0;i< mn.length; i++){
			System.out.println(Arrays.toString(mn[i]));
		}
		return mn[n][k];
	}*/
	
	private static long dpSol(int n, long k, int[] a){
		
		List<Map<Long, Long>> outer = new ArrayList<>();
		for(int i = 0;i< n+1; i++){
			Map<Long, Long> inner = new HashMap<>();
			outer.add(i, inner);
			//System.out.println(i);
			for(long j = 0; j < k+1; j++){
				
				if(i == 0 || j == 0){
					inner.put(j, 0L);
					continue;
				}
				if(a[i-1] <= j ){
					long buyPower = j / a[i-1];
			        long allowed = Math.min(i, buyPower);
			        long remaining = j-allowed*a[i-1];
			        long max1 = allowed + outer.get(i-1).get(remaining);
			        for(int l = 1; l <= allowed; l++){
			        	remaining = j-l*a[i-1];
			        	long lmax = l + outer.get(i-1).get(remaining);
			        	max1 = Math.max(lmax, max1);
			        }
			       // System.out.println(j);
			        //System.out.println(outer);
			        inner.put(j, Math.max( max1, outer.get(i-1).get(j)));
				}
				else{
					inner.put(j, outer.get(i-1).get(j));
				}
			}
		}
		return outer.get(n).get(k);
	}

	
	
	
/*
3  
99 20 1 
100

3
3 1 4
9
 */
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        for(int arr_i = 0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	        }
	        long k = in.nextLong();
	        long result = buyMaximumProducts(n, k, arr);
	        System.out.println(result);
	        in.close();
	    }

}
