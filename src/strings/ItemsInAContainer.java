package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://leetcode.com/discuss/interview-question/1148760/items-in-containers-amazon-oa
 * Given a string s consisting of items as "*" and closed compartments as an open and close "|", an array of starting indices startIndices, and an array of ending indices endIndices, determine the number of items in closed compartments within the substring between the two indices, inclusive.
 *
 * An item is represented as an asterisk *
 * A compartment is represented as a pair of pipes | that may or may not have items between them.
 * Example:
 * s = '|**|*|*'
 * startIndices = [1,1]
 * endIndices = [5,6]
 *
 * The String has a total 2 closed compartments, one with 2 items and one with 1 item. For the first par of indices, (1,5), the substring is '|**|*'. There are 2 items in a compartment.
 * For the second pair of indices, (1,6), the substring is '|**|*|' and there 2+1=3 items in compartments.
 * Both of the answers are returned in an array. [2,3].
 *
 * class Result {
 * 	public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
 * 		// Write your code here
 *
 *                }
 * }
 */
/*
Tests

|**|*|*
2
1 1
5 6

*|*|**|*
2
1 3
5 7

||||||
2
1 2
3 5

******
2
1 2
3 5
 */
public class ItemsInAContainer {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int startLength = s.nextInt();
        int i = 0;
        List<Integer> startList = new ArrayList<>();
        while (i < startLength) {
            startList.add(s.nextInt());
            i++;
        }
        i = 0;
        List<Integer> endList = new ArrayList<>();
        while (i < startLength) {
            endList.add(s.nextInt());
            i++;
        }
        List<Integer> result = numberOfItems(str, startList, endList);
        System.out.println(result);
    }

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {

        int[] sums = new int[s.length() + 1];
        boolean compStart = false;
        int totalSum = 0;
        int compSum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                compStart = true;
                totalSum  += compSum;
                compSum = 0;
            } else if (compStart) {
                compSum++;
            }
            sums[i + 1] = totalSum;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < startIndices.size(); i++) {
            int start = startIndices.get(i);
            int end = endIndices.get(i);
            result.add(sums[end] - sums[start]);
        }
        return result;
    }
}
