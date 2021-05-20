package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/smallest-common-region/
 * You are given some lists of regions where the first region of each list includes all other regions in that list.
 *
 * Naturally, if a region X contains another region Y then X is bigger than Y. Also by definition a region X contains itself.
 *
 * Given two regions region1, region2, find out the smallest region that contains both of them.
 *
 * If you are given regions r1, r2 and r3 such that r1 includes r3, it is guaranteed there is no r2 such that r2 includes r3.
 *
 * It's guaranteed the smallest region exists.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * regions = [["Earth","North America","South America"],
 * ["North America","United States","Canada"],
 * ["United States","New York","Boston"],
 * ["Canada","Ontario","Quebec"],
 * ["South America","Brazil"]],
 * region1 = "Quebec",
 * region2 = "New York"
 * Output: "North America"
 *
 *
 * Constraints:
 *
 * 2 <= regions.length <= 10^4
 * region1 != region2
 * All strings consist of English letters and spaces with at most 20 letters.
 */
public class SmallestRegion {

    private static class TreeNode {
        private String val;
        private TreeNode parent;
        private TreeNode(String val, TreeNode parent) {
            this.val = val;
            this.parent = parent;
        }
    }
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, TreeNode> map = new HashMap<>();
        TreeNode root = null;
        for (List<String> region: regions) {
            TreeNode parent = null;
            for (int i = 0; i < region.size(); i++) {
                final String temp = region.get(i);
                if (!map.containsKey(temp)) {
                    TreeNode node = new TreeNode(temp, parent);
                    map.put(temp, node);
                }
                if (i == 0) {
                    parent = map.get(temp);
                    if (root == null) {
                        root = parent;
                    }
                }
            }
        }
        return lca(root, map.get(region1), map.get(region2)).val;
    }

    private TreeNode lca(TreeNode root, TreeNode r1, TreeNode r2) {
        TreeNode r1Temp = r1;
        TreeNode r2Temp = r2;
        while (r1Temp != r2Temp) {
            r1Temp = r1Temp.parent != null ? r1Temp.parent : r2;
            r2Temp = r2Temp.parent != null ? r2Temp.parent : r1;
        }
        return r1Temp;
    }


    /*private static class TreeNode {
        private String val;
        private List<TreeNode> children = new ArrayList<>();
        private TreeNode right;
        private TreeNode(String val) {
            this.val = val;
        }
    }
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, TreeNode> map = new HashMap<>();
        TreeNode r = null;
        for (List<String> region: regions) {
            TreeNode root = null;
            for (int i = 0; i < region.size(); i++) {
                final String temp = region.get(i);
                if (i == 0) {
                    root = map.computeIfAbsent(temp, (val) -> new TreeNode(temp));
                    if ( r == null) {
                        r = root;
                    }
                    continue;
                }
                TreeNode child = map.computeIfAbsent(temp, (val) -> new TreeNode(temp));
                root.children.add(child);
            }
        }
        TreeNode lca = lca(r, region1, region2);
        return lca.val;
    }

    private TreeNode lca(TreeNode root, String r1, String r2) {
        if (root == null || root.val.equals(r1) || root.val.equals(r2)) {
            return root;
        }
        List<TreeNode> found = new ArrayList<>();
        for (TreeNode n: root.children) {
            TreeNode temp = lca(n, r1, r2);
            if (temp != null) {
                found.add(temp);
            }
        }
        if (found.size() == 0) {
            return null;
        }
        if (found.size() == 1) {
            return found.get(0);
        }
        return root;
    }*/

    public static void main(String[] args) {
        SmallestRegion s = new SmallestRegion();
        s.findSmallestRegion(List.of(List.of("EA", "NA", "SA"), List.of("NA", "US", "CA"), List.of("US", "NY", "BA"), List.of("CA", "QU", "ON"), List.of("SA", "BR")), "NY", "US");
    }
}
