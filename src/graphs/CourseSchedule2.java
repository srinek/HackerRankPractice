package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
 *
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */
public class CourseSchedule2 {

    public int[] findOrder(int n1, int[][] deps) {

        Graph g = new Graph(n1);
        for(int i=0; i<deps.length; i++) {
            g.add(deps[i]);
        }
        List<Integer> finish = g.dfs();
        if(g.hasCircle) {
            return new int[0];
        }
        int[] result = new int[finish.size()];
        for(int k=0; k<finish.size(); k++) {
            result[k] = finish.get(k);
        }
        return result;
    }

    public static class Graph {
        public List<Node> nodes = new ArrayList();
        public boolean hasCircle = false;
        public Graph(int n) {
            for (int i=0; i<n; i++) {
                nodes.add(new Node(i));
            }
        }

        public void add(int[] dep) {
            nodes.get(dep[0]).adj.add(nodes.get(dep[1]));
        }

        public List<Integer> dfs() {
            List<Integer> finish = new ArrayList<>();
            for(Node n : nodes) {
                if(!n.visited) {
                    dfsUtil(n, finish);
                }
            }
            return finish;
        }

        public void dfsUtil(Node n, List<Integer> finishList) {
            if (n.explored) {
                hasCircle = true;
                return;
            }
            n.explored = true;
            for(Node v: n.adj) {
                if (!v.visited) {
                    dfsUtil(v, finishList);
                }
            }
            finishList.add(n.val);
            n.visited = true;
        }
    }

    public static class Node {
        public int val;
        public boolean visited;
        public boolean explored;
        public List<Node> adj = new ArrayList<>();
        public Node(int val) {
            this.val = val;
        }
    }
}
