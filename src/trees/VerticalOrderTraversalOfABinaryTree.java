package trees;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 *
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 *
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
 *
 * Return the vertical order traversal of the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Column -1: Only node 9 is in this column.
 * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
 * Column 1: Only node 20 is in this column.
 * Column 2: Only node 7 is in this column.
 * Example 2:
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * Column -2: Only node 4 is in this column.
 * Column -1: Only node 2 is in this column.
 * Column 0: Nodes 1, 5, and 6 are in this column.
 *           1 is at the top, so it comes first.
 *           5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
 * Column 1: Only node 3 is in this column.
 * Column 2: Only node 7 is in this column.
 * Example 3:
 *
 *
 * Input: root = [1,2,3,4,6,5,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * This case is the exact same as example 2, but with nodes 5 and 6 swapped.
 * Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 1000
 */
public class VerticalOrderTraversalOfABinaryTree {
    private static class Pair implements Comparable<Pair> {
        private int ri;
        private int val;
        private Pair(int ri, int val) {
            this.ri = ri;
            this.val = val;
        }

        public int compareTo(Pair p) {
            if (this.ri == p.ri) {
                return this.val - p.val;
            }
            return this.ri - p.ri;
        }
    }
    int minColIndex = 0;
    int maxColIndex = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        dfs(root, map, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = minColIndex; i <= maxColIndex; i++) {
            List<Pair> list = map.get(i);
            Collections.sort(list);
            result.add(list.stream().map(pair -> pair.val).collect(Collectors.toList()));
        }
        return result;
    }

    private void dfs(TreeNode root, Map<Integer, List<Pair>> map, int ri, int ci) {
        if (root == null) {
            return;
        }
        map.computeIfAbsent(ci, (v) -> new ArrayList<>()).add(new Pair(ri, root.val));
        minColIndex = Math.min(minColIndex, ci);
        maxColIndex = Math.min(maxColIndex, ci);
        dfs(root.left, map, ri + 1, ci - 1);
        dfs(root.right, map, ri + 1, ci + 1);
    }
}
