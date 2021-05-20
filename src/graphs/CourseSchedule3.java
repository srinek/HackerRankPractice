package graphs;

import java.util.*;

/**
 * You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting should be scheduled when a student has completed 50% of their academic program.
 *
 * Each course at our university has at most one prerequisite that must be taken first. No two courses share a prerequisite. There is only one path through the program.
 *
 * Write a function that takes a list of (prerequisite, course) pairs, and returns the name of the course that the student will be taking when they are halfway through their program. (If a track has an even number of courses, and therefore has two "middle" courses, you should return the first one.)
 *
 * Sample input 1: (arbitrarily ordered)
 * prereqs_courses1 = [
 * 	["Foundations of Computer Science", "Operating Systems"],
 * 	["Data Structures", "Algorithms"],
 * 	["Computer Networks", "Computer Architecture"],
 * 	["Algorithms", "Foundations of Computer Science"],
 * 	["Computer Architecture", "Data Structures"],
 * 	["Software Design", "Computer Networks"]
 * ]
 *
 * In this case, the order of the courses in the program is:
 * 	Software Design
 * 	Computer Networks
 * 	Computer Architecture
 * 	Data Structures
 * 	Algorithms
 * 	Foundations of Computer Science
 * 	Operating Systems
 *
 * Sample output 1:
 * 	"Data Structures"
 *
 *
 * Sample input 2:
 * prereqs_courses2 = [
 * 	["Data Structures", "Algorithms"],
 * 	["Algorithms", "Foundations of Computer Science"],
 * 	["Foundations of Computer Science", "Logic"]
 * ]
 *
 *
 * Sample output 2:
 * 	"Algorithms"
 *
 * Sample input 3:
 * prereqs_courses3 = [
 * 	["Data Structures", "Algorithms"],
 * ]
 *
 *
 * Sample output 3:
 * 	"Data Structures"
 *
 * Complexity analysis variables:
 *
 * n: number of pairs in the input
 *
 *
 * */
public class CourseSchedule3 {

    private static class Graph {
        List<Node> nodes = new ArrayList<>();
        Graph() {

        }
    }

    private static class Node {
        public String val;
        List<Node> adjList = new ArrayList<>();
        boolean visited = false;

        public Node(String val) {
            this.val = val;
        }
    }

    public String courseSchedule(String[][] pairs) {
        Map<String, Node> map = new HashMap<>();
        Graph g = new Graph();
        for (String[] pair: pairs) {
            String c1 = pair[0];
            String c2 = pair[1];
            if (!map.containsKey(c1)) {
                map.put(c1, new Node(c1));
                g.nodes.add(map.get(c1));
            }
            if (!map.containsKey(c2)) {
                map.put(c2, new Node(c2));
                g.nodes.add(map.get(c2));
            }
            map.get(c2).adjList.add(map.get(c1));
        }
        List<Node> s = new ArrayList<>();
        for (Node n: g.nodes) {
            if (!n.visited) {
                dfs(n, s);
            }
        }
        if (s.size() % 2 == 0) {
            if (s.size() / 2 > 0) {
                return s.get(s.size() / 2 - 1).val;
            }
        }
        return s.get(s.size() / 2).val;
    }

    private void dfs(Node n, List<Node> s) {
        n.visited = true;
        for (Node c: n.adjList) {
            if (!c.visited) {
                dfs(c, s);
            }
        }
        s.add(n);
    }

    public static void main(String[] args) {
        CourseSchedule3 cs = new CourseSchedule3();
        String[][] prereqs_courses1 = new String[][] {
            {"Foundations of Computer Science", "Operating Systems"},
            {"Data Structures", "Algorithms"},
            {"Computer Networks", "Computer Architecture"},
            {"Algorithms", "Foundations of Computer Science"},
            {"Computer Architecture", "Data Structures"},
            {"Software Design", "Computer Networks"}
        };
        System.out.println(cs.courseSchedule(prereqs_courses1));
        String[][] prereqs_courses2 = {
            {"Data Structures", "Algorithms"},
            {"Algorithms", "Foundations of Computer Science"},
            {"Foundations of Computer Science", "Logic"}
        };
        System.out.println(cs.courseSchedule(prereqs_courses2));
        String[][] prereqs_courses3 = {
            {"Data Structures", "Algorithms"}
        };
        System.out.println(cs.courseSchedule(prereqs_courses3));
    }

}
