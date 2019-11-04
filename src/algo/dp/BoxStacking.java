package algo.dp;

import java.util.Arrays;

/*
 * You are given a set of n types of rectangular 3-D boxes, where the i^th box has height h(i), width w(i) and depth d(i) (all real numbers). 
 * You want to create a stack of boxes which is as tall as possible, but you can only stack a box on top of another box if the dimensions of the 2-D 
 * base of the lower box are each strictly larger than those of the 2-D base of the higher box. 
 * Of course, you can rotate a box so that any side functions as its base. It is also allowable to use multiple instances of the same type of box.
Source: http://people.csail.mit.edu/bdean/6.046/dp/. The link also has video for explanation of solution.
 */

public class BoxStacking {

	public class Box implements Comparable<Box>{
		
		private int h, x, y, area;
		
		public Box(int h, int x, int y){
			this.h = h;
			this.x = x;
			this.y = y;
			this.area = this.x * this.y;
		}

		public int getH() {
			return h;
		}

		public void setH(int h) {
			this.h = h;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getArea() {
			return area;
		}

		public void setArea(int area) {
			this.area = area;
		}
		
		public int compareTo(Box b){
			return b.area-this.area;
		}
		
		public String toString() {
			return (this.x +", "+this.y+", "+this.h);

		}
		
	}
	
	
	public int maxStackHeight(Box[] boxes, int n){
		
		Box[] moreBoxes = new Box[3*n];
		
		for(int i=0; i<boxes.length; i++){
			moreBoxes[3*i+0] = new Box(boxes[i].getH(), 
					Math.max(boxes[i].getY(), boxes[i].getX()), 
					Math.min(boxes[i].getY(), boxes[i].getX()));
			moreBoxes[3*i+1] = new Box(boxes[i].getY(), 
					Math.max(boxes[i].getH(), boxes[i].getX()), 
					Math.min(boxes[i].getH(), boxes[i].getX()));
			moreBoxes[3*i+2] = new Box(boxes[i].getX(), 
					Math.max(boxes[i].getH(), boxes[i].getY()),
					Math.min(boxes[i].getH(), boxes[i].getY()));
		}
		
		Arrays.sort(moreBoxes);
		
		int[] msh = new int[n*3];
		
		for(int i=0; i<msh.length; i++){
			System.out.println(moreBoxes[i]);
			msh[i] = moreBoxes[i].getH();
		}
		
		
		
		for(int i=1; i<moreBoxes.length; i++){
			for(int j=0; j<i; j++){
				if(moreBoxes[i].getX() < moreBoxes[j].getX() 
						&& moreBoxes[i].getY() < moreBoxes[j].getY()){
					msh[i] = Math.max(msh[i], msh[j]+moreBoxes[i].getH());
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<msh.length; i++){
			if(msh[i] > max){
				max = msh[i];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		BoxStacking bs = new BoxStacking();
		Box[] arr = new Box[4];
		arr[0] = bs.new Box(1, 2, 3);
		arr[1] = bs.new Box(4, 5, 6);
		arr[2] = bs.new Box(10, 12, 32);
		arr[3] = bs.new Box(4, 6, 7);
		
		System.out.println("The maximum possible "+
						"height of stack is " + 
						bs.maxStackHeight(arr,4));
	}
}
