package algo.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 *
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class KFrequentElements {

    Random random = new Random();

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
            (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }

    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (int i=0; i < words.length; i++) {
            countMap.put(words[i], countMap.getOrDefault(words[i], 0)+1);
        }
        String[] keys = new String[countMap.size()];
        countMap.keySet().toArray(keys);
        qSort(keys, countMap, 0, keys.length - 1, keys.length - k);
        List<String> results = new ArrayList<>();
        for (int i=keys.length-1; i >= k; i--) {
            results.add(keys[i]);
        }
        Collections.sort(results);
        return results;
    }

    private void qSort(String[] keys, Map<String, Integer> countMap, int left, int right, int k) {
        if (left == right) {
            return;
        }
        int partition = partition(keys, countMap, left, right);
        if (partition == k) {
            return;
        }
        if (k < partition) {
            qSort(keys, countMap, left, partition - 1, k);
        } else {
            qSort(keys, countMap, partition + 1, right, k);
        }
    }

    private int partition(String[] keys, Map<String, Integer> countMap, int left, int right) {
        int pIndex = left + random.nextInt(right - left);
        swap(keys, pIndex, right);
        int ptr = left;
        for (int i = left; i < right; i++) {
            if (countMap.get(keys[i]) < countMap.get(keys[right])) {
                swap(keys, i, ptr);
                ptr++;
            }
        }
        swap(keys, ptr, right);
        return ptr;
    }

    private void swap(String[] keys, int i, int j) {
        String temp = keys[i];
        keys[i] = keys[j];
        keys[j] = temp;
    }

    public static void main(String[] args) {
        KFrequentElements i = new KFrequentElements();
        System.out.println(i.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(i.topKFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }
}
