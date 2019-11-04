package algo.dp;

public class LargestSquareOfOnesInAMatrix {
	
	
	public static void main(String[] args) {
		/*int[][] input = new int[2][2];
		input[0][0] = 1;
		input[0][1] = 1;
		input[1][0] = 1;
		input[1][1] = 1;*/
		char[][] input = new char[1][2];
		input[0][0] = '1';
		input[0][1] = '0';
		System.out.println(findMaximalSquare(input, 1, 2));
		
	}
	
	private static int findMaximalSquare(char[][] matrix, int m, int n){
        
        int[][] output = new int[m+1][n+1];
        int max = 0;
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(matrix[i-1][j-1] == '1'){
                    output[i][j] = 1+ 
                        findMin(output[i-1][j], output[i-1][j-1], output[i][j-1]);
                    max = Math.max(max, output[i][j]);
                }
                
            }
        }
        return max;
    }
    
    private static int findMin(int k, int l, int m){
        
        int temp = Math.min(k, l);
        return Math.min(temp, m);
    }

	/*public static int findLargestSquareOfOnes(int[][] input){
		
		if(input == null || input.length == 0){
			return 0;
		}
		int max = 0;
		int[][] output = new int[input.length][];
		for(int i=0; i < input.length; i++){
			output[i] = new int[input[i].length];
			for(int j = 0; j < input[i].length; j++){
				if(i == 0 || j == 0){
					output[i][j] = input[i][j];
				}
				else{
					if(input[i][j] == 0){
						output[i][j] = 0;
					}
					else{
						output[i][j] = findMinOfneighbours(i, j, input, output) + 1;
					}
				}
				if(output[i][j] > max){
					max = output[i][j];
				}
			}
		}
		
		return max;
	}

	private static int findMinOfneighbours(int i, int j, int[][] input, int[][] output) {
		
		int min = input[i][j-1];
		if(min > input[i-1][j]){
			min = input[i-1][j];
		}
		if(min > input[i-1][j-1]){
			min = input[i-1][j-1];
		}
		return min;
	}*/
	
	
}
