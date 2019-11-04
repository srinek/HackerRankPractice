package algo.dp;

import java.util.Stack;

public class TrappingRainWater {

	
	public static void main(String[] args) {
		TrappingRainWater water = new TrappingRainWater();
		System.out.println(water.trapStacks(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}
	
	public int trap(int[] h) {
	       
        int max_left = Integer.MIN_VALUE;
        int max_right = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=0; i<h.length; i++){
            
            for(int j=i; j >= 0; j--){
                max_left = Math.max(max_left, h[j]);
            }
            
            for(int j=i; j < h.length; j++){
                max_right = Math.max(max_right, h[j]);
            }
            
            ans += Math.min(max_left, max_right) - h[i];
            max_left = Integer.MIN_VALUE;
            max_right = Integer.MIN_VALUE;
        }
        return ans;
    }
	
	 public int trapDP(int[] h) {
	       if(h == null || h.length == 0){
	           return 0;
	       }
	       int size = h.length;
	       int[] lmax = new int[size];
	       int[] rmax = new int[size];
	       lmax[0] = h[0];
	       for(int i=1; i<size; i++){
	           lmax[i] = Math.max(lmax[i-1], h[i]);
	       }
	       rmax[size-1] = h[size-1];
	       for(int i=size-2; i >= 0; i--){
	           rmax[i] = Math.max(rmax[i+1], h[i]);
	       }
	       int ans = 0;
	       for(int i=0; i<size; i++){
	           ans += Math.min(lmax[i], rmax[i]) - h[i] ;
	       }
	       return ans;
	    }
	 
	 public int trapStacks(int[] h) {
		 
	       if(h == null || h.length == 0){
	           return 0;
	       }
	       int ans = 0;
	       Stack<Integer> s = new Stack<>();
	       int i=0;
	       while(i<h.length){
	    	   
	    	   if(s.isEmpty() || h[i] <= h[s.peek()]){
	    		   s.push(i++);
	    	   }
	    	   else{
	    		   int bottom = s.pop();
	    		   ans +=  s.isEmpty() ? 0 :  ( Math.min(h[s.peek()], h[i]) - h[bottom] ) * (i-s.peek()-1) ;
	    	   }
	       }
	       
	       return ans;
	}
}
