package algo.arrays;

import java.util.Scanner;

public class SolutionHourglass {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[][] input = new int[6][6];
		Scanner scan = new Scanner(System.in);
		for(int x=0; x < 6; x++){
			for(int y=0; y < 6; y++){
				input[x][y] = scan.nextInt();
			}
		}
		scan.close();
		SolutionHourglass hSum = new SolutionHourglass();
		hSum.findMaxHourGlassSum(input);
    }
    
    public void findMaxHourGlassSum(int[][] input){
		
		int maxSum = 0;
		for(int x=1; x < input.length-1; x++){
			for(int y=1; y < input[x].length-1; y++){
				int lSum = hourglassSum(input, x, y);
				if(x == 1 && y == 1){
					maxSum = lSum;
				}
				if(lSum > maxSum){
					maxSum = lSum;
				}
			}
		}
		System.out.println(maxSum);
	}
	
	public int hourglassSum(int[][] input, int x, int y){
		
		return input[x][y] + input[x-1][y-1] + input[x-1][y] + input[x-1][y+1]+
				input[x+1][y-1] + input[x+1][y] + input[x+1][y+1];
	}
}