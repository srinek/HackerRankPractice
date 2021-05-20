package algo.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 *
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 *
 *
 * Example 1:
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 * Example 2:
 *
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 *
 *
 * Note:
 *
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[366];
        Set<Integer> daySet = new HashSet<>();
        int min = 365;
        int max = 1;
        for (int i = 0; i < days.length; i++) {
            daySet.add(days[i]);
            min = Math.min(min, days[i]);
            max = Math.max(max, days[i]);
        }
        cache[0] = 0;
        for (int i = min; i <= max; i++) {
            if (daySet.contains(i)) {
                cache[i] =  minCost(i, cache, costs);
            } else {
                cache[i] =  cache[i - 1];
            }

        }
        return cache[max];
    }

    private int minCost(int curDay, int[] cache, int[] costs) {
        int c1 = cache[curDay - 1] + costs[0];
        int c2 = curDay - 7 >= 0 ? cache[curDay - 7] + costs[1] : costs[1];
        int c3 = curDay - 30 >= 0 ? cache[curDay - 30] + costs[2] : costs[2];
        int min = Math.min(c1, c2);
        return Math.min(min, c3);
    }

    public static void main(String[] args) {
        MinimumCostForTickets m = new MinimumCostForTickets();
        m.mincostTickets(new int[]{1,4,6,7,8,20, 21, 22, 33, 44, 55, 88, 101, 267}, new int[] {2,7,15});
    }
}
