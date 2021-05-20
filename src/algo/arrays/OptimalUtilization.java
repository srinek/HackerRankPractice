package algo.arrays;

import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/373202
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.
 *
 * Example 1:
 *
 * Input:
 * a = [[1, 2], [2, 4], [3, 6]]
 * b = [[1, 2]]
 * target = 7
 *
 * Output: [[2, 1]]
 *
 * Explanation:
 * There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
 * Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
 * Example 2:
 *
 * Input:
 * a = [[1, 3], [2, 5], [3, 7], [4, 10]]
 * b = [[1, 2], [2, 3], [3, 4], [4, 5]]
 * target = 10
 *
 * Output: [[2, 4], [3, 2]]
 *
 * Explanation:
 * There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
 * Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
 * These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
 * Example 3:
 *
 * Input:
 * a = [[1, 8], [2, 7], [3, 14]]
 * b = [[1, 5], [2, 10], [3, 14]]
 * target = 20
 *
 * Output: [[3, 1]]
 * Example 4:
 *
 * Input:
 * a = [[1, 8], [2, 15], [3, 9]]
 * b = [[1, 8], [2, 11], [3, 12]]
 * target = 20
 *
 * Output: [[1, 3], [3, 2]]
 */

/*
Tests
------
3
1 2 2 4 3 6
1
1 2
7


4
1 3 2 5 3 7 4 10
4
1 2 2 3 3 4 4 5
10

3
1 8 2 7 3 14
3
1 5 2 10 3 14
20

3
1 8 2 15 3 9
3
1 8 2 11 3 12
20

3
1 1 2 1 3 1
3
1 2 2 2 3 2
3
 */
public class OptimalUtilization {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int alen = s.nextInt();
        List<List<Integer>> aList = new ArrayList<>();
        int i = 0;
        while (i < alen) {
            List<Integer> temp = new ArrayList<>();
            temp.add(s.nextInt());
            temp.add(s.nextInt());
            aList.add(temp);
            i++;
        }
        int blen = s.nextInt();
        List<List<Integer>> bList = new ArrayList<>();
        i = 0;
        while (i < blen) {
            List<Integer> temp = new ArrayList<>();
            temp.add(s.nextInt());
            temp.add(s.nextInt());
            bList.add(temp);
            i++;
        }
        int target = s.nextInt();
        System.out.println(opt(aList, bList, target));
    }

    public static List<List<Integer>> opt(List<List<Integer>> al, List<List<Integer>> bl, int target) {
        Collections.sort(al, (o1, o2) -> o1.get(1) - o2.get(1));
        Collections.sort(bl, (o1, o2) -> o2.get(1) - o1.get(1));
        int i = 0, j = 0;
        List<List<Integer>> result = new ArrayList<>();
        int curResult = Integer.MIN_VALUE;
        while (i < al.size() && j < bl.size()) {
            int sum = al.get(i).get(1) + bl.get(j).get(1);
            if (sum > target) {
                j++;
            } else {
                if (curResult < sum) {
                    curResult = sum;
                    result.clear();
                }
                int jIndex = j;
                do {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(al.get(i).get(0));
                    temp.add(bl.get(jIndex).get(0));
                    result.add(temp);
                    jIndex++;
                } while (jIndex < bl.size() && bl.get(jIndex).get(1) == bl.get(jIndex - 1).get(1));
                i++;
            }
        }
        return result;
    }
}
