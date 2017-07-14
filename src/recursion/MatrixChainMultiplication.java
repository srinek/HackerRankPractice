package recursion;

public class MatrixChainMultiplication {

	private static int matrixChainOrder(int[] p, int i, int j){
		
		if(j == i){ 
			return 0;
		}
		int minOps = Integer.MAX_VALUE;
		for(int k = i; k < j; k++){
			int ops = (p[i-1] * p[k] *p[j]) +matrixChainOrder(p, i, k) + matrixChainOrder(p, k+1, j);
			if(ops < minOps){
				minOps = ops;
			}
			
			
		}
		return  minOps;
	}
	
	public static void main(String[] args) {
		
		int[] p = new int[]{10, 20, 30, 40, 30};
		System.out.println( matrixChainOrder(p, 1 , 4));
	}
	
}
