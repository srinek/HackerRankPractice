package trees;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 *
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 * Example 1:
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 */
public class RottingOranges {
    private static class Pair {
        public int l;
        public int r;
        public Pair(final int l, final int r) {
            this.l = l;
            this.r = r;
        }
    }
    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        final Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        final int rows = grid.length;
        final int cols = grid[0].length;
        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if (fresh == 0 ) {
            return 0;
        }
        if (q.size() > 0 ) {
            q.add(new Pair(-1, -1));
        }
        final int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0, -1}};
        int result = 0;
        while (!q.isEmpty()) {
            final Pair p = q.poll();
            if (p.l == -1 && p.r == -1) {
                result++;
                if (!q.isEmpty()) {
                    q.add(new Pair(-1, -1));
                }
                continue;
            }
            for (int i=0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int nr = p.l + dir[0];
                int nc = p.r + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    if (grid[nr][nc] == 1) {
                        fresh--;
                        grid[nr][nc] = 2;
                        q.add(new Pair(nr, nc));
                    }
                }
            }
        }
        if (fresh == 0) {
            return result - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        final RottingOranges i = new RottingOranges();
        System.out.println(i.orangesRotting(new int[][] {{2,1,1}, {1,1,0}, {0,1,1}}));
    }
}
