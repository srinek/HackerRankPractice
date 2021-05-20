package graphs;

import java.util.HashSet;
import java.util.Set;

public class FindPathsInA2DArray {

    public static void main(String[] args) {
        FindPathsInA2DArray paths = new FindPathsInA2DArray();
        int total = paths.paths(new int[][] {
            {1,1,0},
            {1,1,1},
            {1,1,1}
        });
        System.out.println(total);
    }

    private int paths (int[][] arr) {
        Set<String> set = new HashSet<>();
        StringBuilder str = new StringBuilder();
        str.append(0).append(0);
        dfs(0,0, arr, str, set, arr.length - 1);
        return set.size();
    }

    private void dfs(int curRow, int curCol, int[][] arr, StringBuilder str, Set<String> set, int n) {
        if (curRow == n && curCol == n) {
            set.add(str.toString());
            return;
        }
        int[][] dirs = new int[][] {{0,1}, {1,0}};
        for (int[] dir: dirs) {
            int newRow = curRow + dir[0];
            int newCol = curCol + dir[1];
            if (newRow <= n && newCol <= n && arr[newRow][newCol] != 0 ) {
                str.append(newRow).append(newCol);
                dfs (newRow, newCol, arr, str, set, n);
                str.setLength(str.length() - 2);
            }
        }
    }
}
