package graphs;

/**
 * https://leetcode.com/problems/number-of-provinces/
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 */
public class NumberOfProvinces {

    //

    public int findCircleNum(int[][] graph) {
        int total = 0;
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1 && !visited[j]) {
                    total++;
                    dfs(graph, visited, j);
                }
            }
        }
        return total;
    }

    private void dfs(int[][] graph, boolean[] visited, int row) {
        visited[row] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[row][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    // union - find
    public int findCircleNum_unionFind(int[][] graph) {
        int m = graph.length;
        int[] parents = new int[m];
        for (int i = 0; i < m; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                if (graph[i][j] == 1) {
                    updateParent(parents, i, j);
                }
            }
        }
        int total = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == i) {
                total++;
            }
        }
        return total;
    }

    private void updateParent(int[] parents, int i, int j) {
        int iParent = find(parents, i);
        int jParent = find(parents, j);
        if (iParent < jParent) {
            parents[jParent] = iParent;
            parents[i] = iParent;
            parents[j] = iParent;
        } else {
            parents[iParent] = jParent;
            parents[i] = jParent;
            parents[j] = jParent;
        }
    }

    private int find(int[] parents, int i) {
        if (parents[i] != i) {
            return find(parents, parents[i]);
        }
        return i;
    }
}
