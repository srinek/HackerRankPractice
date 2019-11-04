package algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Knapsack0or1 {
	
	
	public static void main(String[] args) {
		
		int[] weights = new int[]{1, 2, 3};
		int[] values = new int[]{6, 10, 12};
		int totalWeight = 5;
		System.out.println( _01knapsack(weights, values, totalWeight));
	}
	
	public static int _01knapsack(int[] weights, int[] values, int totalWeight){
		
		//sort the weights
		
		Arrays.sort(weights);
				
		//start DP solution
		
		int[][] solution = new int[weights.length+1][totalWeight+1];
		Map<String, List<Integer>> weightsIncluded = new HashMap<>();
		
		for(int i=0; i < solution.length; i++){
			for(int j=0; j<solution[i].length; j++){
				weightsIncluded.put(i+""+j, new ArrayList<>());
				if(i == 0 || j == 0){
					solution[i][j] = 0;
				}
				else if(i > j){
					solution[i][j] = solution[i-1][j];
					weightsIncluded.put(i+""+j, weightsIncluded.get((i-1)+""+(j)));
				}
				else if(i <= j){
					solution[i][j] = Math.max(values[i-1]+solution[i-1][j-i], solution[i-1][j]);
					if(values[i-1]+solution[i-1][j-i] > solution[i-1][j]){
						solution[i][j] = values[i-1]+solution[i-1][j-i];
						List<Integer> ls = new ArrayList<>();
						ls.add(weights[i-1]);
						ls.addAll(weightsIncluded.get((i-1)+""+(j-i)));
						weightsIncluded.put(i+""+j, ls);
					}
					else{
						weightsIncluded.put(i+""+j, weightsIncluded.get((i-1)+""+(j)));
					}
					
				}
			}
		}
		System.out.println(weightsIncluded.get((weights.length)+""+(totalWeight)));
		return solution[weights.length][totalWeight];
	}

}
