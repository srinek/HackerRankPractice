package algo.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * 
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointsInOrigin {
	

	public static void main(String[] args) {
		
		KClosestPointsInOrigin sol = new KClosestPointsInOrigin();
		//int[][] points = {{5,-1},{4,4},{32,-56},{16,88},{-2,4},{2,2},{2,3},{3,3}}; // 2,2  2,3 3,3 -2,4 5,-1 4,4
		int[][] points = {{-41,72},{53,83},{-95,-31},{-61,68},{-81,-48},{-31,56},{-57,-74},{24,-42},{-59,72},{-86,40},{34,-85},{-45,22},{-35,-95}};
		for(int[] point : sol.kClosest(points, 9)){
			//System.out.println(Arrays.toString(point));
		}
		
	}

	Random random = new Random();
	public int[][] kClosest(int[][] points, int k) {

		if (points == null) {
			return null;
		}
		qSort(points, 0, points.length-1, k);
		for(int[] point : points){
			System.out.print(Arrays.toString(point));
		}
		return Arrays.copyOfRange(points, 0, k);
	}

	
	private void qSort(int[][] points, int l, int r, int k){
		
		if( l < r){
			
			int p = partition(points, l, r, k);
			if (k == p) {
				return;
			}
			if(k  < p){
				qSort(points, l, p-1, k);	
			}
			else if(k > p){
				qSort(points, p+1, r, k);
			}
		}
	}
	
	
	private int partition(int[][] points, int l, int r, int k){
		
		int pivotIndex = l + random.nextInt(r - l);
		
		swap(points, pivotIndex, r);
		
		int pivotDist = dist(points[r]);
		
		int ptr=l;
		
		for(int i=l; i<r ; i++){
			
			if(dist(points[i]) < pivotDist){
				swap(points, i, ptr);
				ptr++;
			}
		}
		
		swap(points, ptr, r);
		
		return ptr;
	}
	
	private int dist(int[] point){
		return point[0] * point[0] + point[1] * point[1];
	}
	
	private void swap(int[][] points, int i, int j){
		
		int[] temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}
	

}
