package strings;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reorganize-string/
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty string.
 *
 * Example 1:
 *
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 *
 * Input: S = "aaab"
 * Output: ""
 * Note:
 *
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class ReorganizeString {
    private static class Pair implements Comparable<Pair> {
        private int count;
        private char letter;
        private Pair(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        public int compareTo(Pair p) {
            if (p.count == this.count) {
                return this.letter - p.letter;
            }
            return p.count - this.count;
        }
    }
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        for(char c: s.toCharArray()) {
            counts[c - 'a']++;
        }
        Queue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > (s.length() + 1) / 2) {
                return "";
            }
            if (counts[i] > 0) {
                pq.add(new Pair((char)(i + 'a'), counts[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();
            sb.append(p1.letter);
            sb.append(p2.letter);
            if (--p1.count > 0) {
                pq.add(p1);
            }
            if (--p2.count > 0) {
                pq.add(p2);
            }
        }
        if (!pq.isEmpty()) {
            sb.append(pq.poll().letter);
        }
        return sb.toString();
    }
}
