package algo.arrays;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/hand-of-straights/solution/
 *
 * Alice has a hand of cards, given as an array of integers.
 *
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 *
 * Return true if and only if she can.
 *
 * Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 *
 *
 * Example 1:
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 *
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 */
public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int w) {
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card: hand) {
            map.put(card, map.getOrDefault(card, 0)+1);
        }

        while (map.size() > 0) {
            final int card = map.firstKey();
            for (int i = card; i < card + w; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.get(i)-1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        return true;
    }
}
