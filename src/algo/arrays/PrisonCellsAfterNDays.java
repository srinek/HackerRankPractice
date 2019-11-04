package algo.arrays;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/prison-cells-after-n-days/
 */
public class PrisonCellsAfterNDays {
	
	public static void main(String[] args) {
		PrisonCellsAfterNDays days = new PrisonCellsAfterNDays();
		//System.out.println( ~(0^1));
		//days.prisonAfterNDays(new int[]{1, 1, 0, 1, 1, 0, 1, 1},	6);
		//days.prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7); //0, 0, 1, 1, 0, 0, 0, 0
		//days.prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000); //0,0,1,1,1,1,1,0
		days.prisonAfterNDays(new int[]{0, 1, 1, 1, 0, 0, 0, 1}, 78); //[0,0,1,0,0,1,0,0]
	}

	public int[] prisonAfterNDays(int[] cells, int n) {
		
		 if(cells == null || cells.length <= 2){
			 return cells;
		 }
		 int[] result = new int[cells.length];
		 if(n < cells.length){
			 rotate(cells, n, result);
		 }
		 else{
			 int t = findInterval(cells, n, result);
			 System.out.println(t);
		     int new_n = n% (t);
		     rotate(cells, new_n, result);
		 }
		 System.out.println(Arrays.toString(result));
		 return result;
	}

	private void rotate(int[] cells, int n, int[] result) {
		int i = 0;
		int[] temp = new int[cells.length];
		while(i < n || n == 0){
			for(int k=0; k<cells.length; k++){
				if(k == 0 || k == cells.length-1){
					temp[k] = 0;
				}
				else{
					temp[k] = xnor(cells[k-1], cells[k+1]); // xnor
				}
			}

			cells = Arrays.copyOf(temp, temp.length);
			//System.out.println(i + "  "+Arrays.toString(temp));
			i++;
			if(n == 0){
				break;
			}
		}
		if(i == n){
			for(int m=0; m<temp.length; m++){
				result[m] = temp[m];
			}
		}
		
	}

	private int findInterval(int[] cells, int n, int[] result) {
		
		int i = 0;
		int[] temp = new int[cells.length];
		int[] day1 =null;
		while(i < 256){ // 256 because 2 power 8 (size of the cells)
			for(int k=0; k<cells.length; k++){
				if(k == 0 || k == cells.length-1){
					temp[k] = 0;
				}
				else{
					temp[k] = xnor(cells[k-1], cells[k+1]); // xnor
				}
			}
			if(day1 == null){
				day1 = Arrays.copyOf(temp, temp.length);
			}
			cells = Arrays.copyOf(temp, temp.length);
			//System.out.println(i + "  "+Arrays.toString(temp));
			if(Arrays.equals(day1, temp) && i != 0){
				return i;
			}
			i++;
			
		}
		return -1;
	}
	
	private int xnor(int a, int b){
		if( (a == 0 && b== 0) || 
				(a==1 && b==1)){
			return 1;
		}
		return 0;
	}

}
