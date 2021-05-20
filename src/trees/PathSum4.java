package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/path-sum-iv/
 If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

 For each integer in this list:

 The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
 The units digit represents the value V of this node, 0 <= V <= 9.
 Given a list of ascending three-digits integers representing a binary tree with the depth smaller than 5, you need to return the sum of all paths from the root towards the leaves.

 It's guaranteed that the given list represents a valid connected binary tree.

 Example 1:

 Input: [113, 215, 221]
 Output: 12
 Explanation:
 The tree that the list represents is:
 3
 / \
 5   1

 The path sum is (3 + 5) + (3 + 1) = 12.


 Example 2:

 Input: [113, 221]
 Output: 4
 Explanation:
 The tree that the list represents is:
 3
 \
 1

 The path sum is (3 + 1) = 4.
 */
public class PathSum4 {
    int sum = 0;
    public int pathSum(int[] nums) {
        Map<Integer, Integer> tree = new HashMap<>();
        for (int num: nums) {
            int key = num / 10;
            int val = num % 10;
            tree.put(key, val);
        }
        traverse(tree, nums[0] / 10, 0);
        return sum;
    }

    private void traverse(Map<Integer, Integer> map, int root, int curSum) {
        int val = map.get(root);
        curSum += val;
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + 2 * pos - 1;
        int right = (level + 1) * 10 + 2 * pos;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            sum += curSum;
        }
        if (map.containsKey(left)) {
            traverse(map, left, curSum);
        }
        if (map.containsKey(right)) {
            traverse(map, right, curSum);
        }
    }
}
