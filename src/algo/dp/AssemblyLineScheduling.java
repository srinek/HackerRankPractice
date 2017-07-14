package algo.dp;

import java.util.Arrays;

public class AssemblyLineScheduling {
	
	public static void main(String[] args) {
		int n = 6;
		int e1 = 2;
		int e2 = 4;
		int[] s1 = {7, 9 , 3, 4, 8, 4};
		int[] s2 = {8, 5, 6, 4, 5, 7};
		int[] t1 = {2, 3, 1, 3, 4};
		int[] t2 = {2, 1, 2, 2, 1};
		int x1 = 3;
		int x2 = 2;
		findFastestLine(n, e1, e2, s1, s2, t1, t2, x1, x2);
	}
	
	public static void findFastestLine(int n, int e1, int e2, int[] s1, int[] s2, int[] t1, int[] t2, int x1, int x2){
		
		int[][] sol = new int[2][n+1];
		int[] l1 = new int[n];
		int[] l2 = new int[n];
		
		sol[0][0] = e1 + s1[0];
		sol[1][0] = e2 + s2[0];
		l1[0] = sol[0][0] < sol[1][0] ? 1 : 2;
		for(int j = 1; j < n ; j++){
			
			if(sol[0][j-1] + s1[j] < sol[1][j-1] + t2[j-1]+s1[j]){
				sol[0][j] = sol[0][j-1] + s1[j];
				l1[j] = 1;
			}
			else{
				sol[0][j] = sol[1][j-1] + t2[j-1]+s1[j];
				l1[j] = 2;
			}
			if(sol[1][j-1] + s2[j] < sol[0][j-1] + t1[j-1]+s2[j]){
				sol[1][j] = sol[1][j-1] + s2[j];
				l2[j] = 2;
			}
			else{
				sol[1][j] = sol[0][j-1] + t1[j-1]+s2[j];
				l2[j] = 1;
			}
			//sol[0][j] = min(sol[0][j-1] + s1[j], sol[1][j-1] + t2[j-1]+s1[j] );
			//sol[1][j] = min(sol[1][j-1] + s2[j], sol[0][j-1] + t1[j-1]+s2[j] );
		}
		
		int fastestTime = 0;
		int lineFinish = 0;
        if(sol[0][n-1] + x1 < sol[1][n-1] + x2){
        	fastestTime = sol[0][n-1] + x1;
        	lineFinish = 1;
        }
        else{
        	fastestTime = sol[1][n-1] + x2;
        	lineFinish = 2;
        }
		
		System.out.println("Fastest Time : "+fastestTime);
		//System.out.println("station "+n +" : "+ lineFinish);
		printLinePath(l1, l2, lineFinish, n);
		
		//System.out.println(Arrays.toString(sol[0]));
		//System.out.println(Arrays.toString(sol[1]));
	}

	private static void printLinePath(int[] l1, int[] l2, int lineFinish, int station) {
		if(station < 1){
			return;
		}
		if(lineFinish == 1){
			System.out.println("station "+station +" : Line "+lineFinish);
			printLinePath(l1, l2, l1[station-1], --station);
		}
		else{
			System.out.println("station "+station +" : Line "+ lineFinish);
			printLinePath(l1, l2, l2[station-1], --station);
		}
		
	}

	private static int min(int i1, int i2) {
		
		if(i1 < i2){
			return i1;
		}
		return i2;
	}

}
