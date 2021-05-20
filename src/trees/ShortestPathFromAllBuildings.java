package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 * You are given an m x n grid grid of values 0, 1, or 2, where:
 *
 * each 0 marks an empty land that you can pass by freely,
 * each 1 marks a building that you cannot pass through, and
 * each 2 marks an obstacle that you cannot pass through.
 * You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. You can only move up, down, left, and right.
 *
 * Return the shortest travel distance for such a house. If it is not possible to build such a house according to the above rules, return -1.
 *
 * The total travel distance is the sum of the distances between the houses of the friends and the meeting point.
 *
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * Output: 7
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
 * So return 7.
 * Example 2:
 *
 * Input: grid = [[1,0]]
 * Output: 1
 * Example 3:
 *
 * Input: grid = [[1]]
 * Output: -1
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] is either 0, 1, or 2.
 * There will be at least one building in the grid.
 */
public class ShortestPathFromAllBuildings {

    private int[][] adj = new int[][] { {1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] reach = new int[rows][cols];
        int totalBuildings = 0;
        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    ++totalBuildings;
                    bfs(grid, dist, i, j, 0, reach);
                }
            }
        }
        /*for (int l=0; l < rows; l++) {
            System.out.println(Arrays.toString(dist[l]));
            System.out.println(Arrays.toString(reach[l]));
        }*/
        int result = Integer.MAX_VALUE;
        for (int l=0; l < rows; l++) {
            for (int k=0; k < cols; k++) {
                if (grid[l][k] == 0 && reach[l][k] == totalBuildings) {
                    result = Math.min(result, dist[l][k]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void bfs(int[][] grid, int[][] dist, int i, int j, int cost, int[][] reach) {
        Queue<Pair> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        q.offer(new Pair(i, j, cost));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int[] a: adj) {
                int x = p.i + a[0];
                int y = p.j + a[1];
                if ( x >= 0 && x < rows &&  y >= 0 && y < cols && !visited[x][y]) {
                    if (grid[x][y] == 0) {
                        q.offer(new Pair(x, y, p.cost + 1));
                        dist[x][y] += p.cost + 1;
                        reach[x][y]++;
                        visited[x][y] = true;
                    }
                }
            }
        }
    }

    private static class Pair {
        int i;
        int j;
        int cost;
        public Pair (int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }


    public static void main(String[] args) {
        ShortestPathFromAllBuildings i = new ShortestPathFromAllBuildings();
        int[][] n = new int[][]{
            {1, 0, 2, 0 , 1},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0}
        };
        System.out.println(i.shortestDistance(n));

        ShortestPathFromAllBuildings i2 = new ShortestPathFromAllBuildings();
        int[][] n2 = new int[][]{
            {1, 2, 2, 2 , 1},
            {2, 2, 0, 2, 2},
            {2, 2, 1, 2, 2}
        };
        System.out.println(i2.shortestDistance(n2));

        ShortestPathFromAllBuildings i3 = new ShortestPathFromAllBuildings();
        int[][] n3 = new int[][]{
            {1}
        };
        System.out.println(i3.shortestDistance(n3));
    }
}

