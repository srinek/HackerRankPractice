package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-knight-moves/
 *
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
 *
 * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 *
 *
 *
 * Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 * Example 2:
 *
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 *
 *
 * Constraints:
 *
 * |x| + |y| <= 300
 */
public class MinimumKnightMoves {

    static class Result {
        int i;
        int j;
        int cost;
        public Result(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }

        public boolean equals(Object o) {
            Result r = (Result)o;
            return r.i == i && r.j == j;
        }

        public int hashCode() {
            return i * j;
        }
    }
    private int[][] dirs = new int[][] {{-2,-1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public int minKnightMoves(int x, int y) {
        Set<Result> visited = new HashSet<>();
        Queue<Result> q = new LinkedList<>();
        q.offer(new Result(0, 0, 0));
        visited.add(new Result(0, 0, 0));
        while(!q.isEmpty()) {
            Result t = q.poll();
            //System.out.println(t.i +" "+t.j +" "+t.cost);
            for (int[] dir: dirs) {
                int ni = t.i + dir[0];
                int nj = t.j + dir[1];
                Result nrow = new Result(ni, nj, t.cost + 1);
                if (ni == x && nj == y) {
                    return t.cost + 1;
                } else {
                    if (!visited.contains(nrow)) {
                        q.offer(nrow);
                        visited.add(nrow);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MinimumKnightMoves i = new MinimumKnightMoves();
        System.out.println(i.minKnightMoves(43, -114));
    }
}
