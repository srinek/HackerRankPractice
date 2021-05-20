package algo.linkedlist;

import java.util.*;

/**
 * public void merger(List<Stream> streams, int countMoreThan){
 *
 *
 *    //
 *
 *  }
 *
 *
 *  public class Stream{
 *
 *
 *
 *   public int peek();
 *
 *   public int pop();
 *
 *   public boolean isEmpty();
 *
 *  }
 *
 *  1) streams return sorted integers.
 *
 *  2) merge the results from stream and print them sorted.
 *
 *  3) duplicates from same stream should be ignored
 *
 *  4) total count of values from streams is greater or equal to "countMoreThan", then only print the value in output.
 *
 *  5) output should not have dups.
 *
 *
 *  Example 1 :
 *
 *     countMoreThan = 2
 *
 *    1 3 4 5 6 8
 *
 *    2 3 6 7 8
 *
 *    1 2 4 6 7
 *
 *
 *
 *    output :  1 2 3 4 7 8
 *
 *
 *  Example 1 :
 *
 *   countMoreThan = 2
 *
 *    1 1 1 1 1 1 1 2
 *
 *    1 1 1 1 1 1 1 1
 *
 *    2 2 2 2 2 2 2 2
 *
 *   output :  1 2
 */
public class MergeKSortedStreams {

    public void merger(List<Stream> streams, int countMoreThan){

        Queue<Integer> q = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (Stream s: streams) {
            int v = s.pop();
            while (!s.isEmpty() && s.peek() == v) {
                s.pop();
            }
            q.add(v);
            if (q.size() >= countMoreThan) {
                int sorted = q.poll();
                if (set.add(sorted)) {
                    System.out.print(sorted+" ");
                }
            }
        }

    }


    public interface Stream{
        public int peek();
        public int pop();
        public boolean isEmpty();
    }
}
