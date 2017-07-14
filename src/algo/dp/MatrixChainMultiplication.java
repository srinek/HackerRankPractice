package algo.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {

	private static int matrixChainOrder(int[] p) {

		int[][] m = new int[p.length][p.length];
        int[][] paren = new int[p.length][p.length];
        
		int n = p.length;

		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {

				int j = i + l -1;
				int min = Integer.MAX_VALUE;
				int tempk = -1;
				for (int k = i; k < j; k++) {
					int temp = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (temp < min) {
						min = temp;
						tempk = k;
					}
				}
				m[i][j] = min;
				paren[i][j] = tempk;
			}
		}
		
		for(int i = 0; i < p.length; i++){
			System.out.println(Arrays.toString(m[i]));
		}
		System.out.println("-------------------------");
		for(int i = 0; i < p.length; i++){
			System.out.println(Arrays.toString(paren[i]));
		}
		print(p, paren);
		return m[1][n - 1];

	}
	
	private static void print(int[] p, int[][] paren){
		StringBuilder str = new StringBuilder();
		int add = 0;
		str.append("(");
		add++;
		for(int i = 0 ; i < p.length; i++){
			str.append(p[i]);
		}
		int k = paren[1][p.length-1];
		int i = 1;
		while(k > 0){
			if(i <= 1){
				str.insert(0, "(");
				add++;
			}
			str.insert(k+1+add, ")");
			k = paren[i][k];
		}
		str.append(")");
		System.out.println(str.toString());
	}

	public static void main(String[] args) {

		int[] p = new int[] {10, 20, 30, 40, 30}  ;
		System.out.println(matrixChainOrder(p));
	}
}
