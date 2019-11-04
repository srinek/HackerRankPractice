package algo.arrays;

public class MaxLengthRepeatedSubArrray {

	public int findLengthDP(int[] a, int[] b) {
        
        int[][] output = new int[a.length+1][b.length+1];
        int ans = 0;
        
        for(int i=a.length-1; i >= 0; i--){
            
            for(int j=b.length-1; j>=0; j--){
                
                if(a[i] == b[j]){
                    output[i][j] = 1 + output[i+1][j+1];
                    ans = Math.max(output[i][j], ans);
                }
            }
        }
        
        return ans;
    }

	public int findLength(int[] a, int[] b) {

		int ans = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {

				if (a[i] == b[j]) {
					int k = 0;
					while (i + k < a.length && j + k < b.length) {
						if (a[i + k] != b[j + k]) {
							break;
						}
						k++;
					}
					ans = Math.max(ans, k);
				}
			}
		}

		return ans;
	}
	
	public static void main(String[] args) {
		
		MaxLengthRepeatedSubArrray subarray = new MaxLengthRepeatedSubArrray();
		
		System.out.println(subarray.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
		
	}
}
