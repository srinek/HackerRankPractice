package algo.arrays;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 *
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 *
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 *
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 *
 *
 * Follow up:
 *
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */
public class StreamAsDisjointIntervals {

    public static void main(String[] args) {
        StreamAsDisjointIntervals i = new StreamAsDisjointIntervals();
        SummaryRanges obj = i.new SummaryRanges();
        obj.addNum(1);
        print(obj.getIntervals());
        obj.addNum(3);
        print(obj.getIntervals());
        obj.addNum(7);
        print(obj.getIntervals());
    }

    private static void print(final int[][] nums) {
        for (int[] t: nums) {
            System.out.println(Arrays.toString(t));
        }
    }

    class SummaryRanges {

        final TreeMap<Integer, Interval> map = new TreeMap<>();

        /** Initialize your data structure here. */
        public SummaryRanges() {

        }

        public void addNum(int val) {
            if (map.containsKey(val)) {
                return;
            }
            final Integer l = map.lowerKey(val);
            final Integer h = map.higherKey(val);
            if (l != null && h != null && map.get(l).end + 1 == val && h == val+1) {
                map.get(l).end = map.get(h).end;
                map.remove(h);
            } else if (l != null && map.get(l).end + 1 >= val) {
                map.get(l).end = Math.max(map.get(l).end, val);;
            } else if ( h != null && val+1 == h) {
                map.put(val, new Interval(val, map.get(h).end));
                map.remove(h);
            } else {
                map.put(val, new Interval(val, val));
            }
        }

        public int[][] getIntervals() {
            int[][] res = new int[map.size()][2];
            int i = 0;
            for(Interval a:map.values()){
                res[i][0] = a.start;
                res[i][1] = a.end;
                i++;
            }
            return res;
        }

        public class Interval {
            public int start;
            public int end;
            public Interval(final int start, final int end) {
                this.start = start;
                this.end = end;
            }
        }
    }

}