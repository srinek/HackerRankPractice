package algo.arrays;

import java.util.Arrays;

public class MeetingPlanner {
	
	/*static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
	    
	    if(slotsA == null && slotsB == null){
	      return null;
	    }
	    // check for slotA or slotsB is null
	    int[] tempSlot = new int[2];
	    for(int[] sa : slotsA){
	      for(int[] sb : slotsB){
	          int[] top = findSortedTop(sa, sb);
	          int[] compareWith = findNonTop(top, sa, sb);
	          if(top[1] > compareWith[0]){
	            tempSlot[0] = Integer.max(top[0], compareWith[0]);
	            tempSlot[1] = Integer.min(top[1], compareWith[1]);
	            int tempDuration = tempSlot[1] - tempSlot[0];
	            if(tempDuration >= dur){
	              tempSlot[1] = tempSlot[0] + dur;
	              return tempSlot;
	            }
	          }

	      }
	    }
	    return new int[0];
	  }*/
	  
	  private static  int[] findSortedTop(int[] sa, int[] sb){
	    if(sa[0] < sb[0]){
	        return sa;
	    }
	    return sb;
	  }
	  
	  private static int[] findNonTop(int[] top, int[] sa, int[] sb){
	    if(top == sa){
	      return sb;
	    }
	    return sa;
	  }
	  
	  
	  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
		    
		    if(slotsA == null && slotsB == null){
		      return null;
		    }
		    // check for slotA or slotsB is null
		    int a =0, b=0;
		    while(a < slotsA.length && b < slotsB.length){
		      int[] sa = slotsA[a];
		      int[] sb = slotsB[b];
		      int begin = Math.max(sa[0], sb[0]);
		      int end = Math.min(sa[1], sb[1]);
		      if( (end-begin) >= dur){
		        return new int[]{begin, begin+dur};
		      }
		      if(sa[1] < sb[1]){
		        a++;
		      }
		      else{
		        b++;
		      }
		    }
		    return new int[0];
	 }
// (10, 15) ( 16, 20) (22,27)     4
// (3,12) ( 14, 18) (20, 24)
	  public static void main(String[] args) {
	        int[][] slotsA = new int[][]{{10, 50}, {60, 120}, {140, 210}};
	        int[][] slotsB = new int[][]{{0, 15}, {60, 70}};
	        System.out.print(Arrays.toString(meetingPlanner(slotsA, slotsB, 8)));
	  }

}
