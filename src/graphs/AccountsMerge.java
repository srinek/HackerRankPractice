package graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/accounts-merge/
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Example 2:
 *
 * Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 *
 *
 * Constraints:
 *
 * 1 <= accounts.length <= 1000
 * 2 <= accounts[i].length <= 10
 * 1 <= accounts[i][j] <= 30
 * accounts[i][0] consists of English letters.
 * accounts[i][j] (for j > 0) is a valid email.
 */
public class AccountsMerge {

    private static class Graph {
        public List<Node> nodes = new ArrayList<>();
        public Map<String, Node> nodeMap = new HashMap<>();

        public Graph() {

        }

        public Node createNode(String email, String name) {
            Node n = nodeMap.computeIfAbsent(email, (v) -> new Node(email, name));
            nodes.add(n);
            return n;
        }

        public void addEdge(String e1, String e2) {
            Node n1 = nodeMap.get(e1);
            Node n2 = nodeMap.get(e2);
            n1.adjList.add(n2);
            n2.adjList.add(n1);
        }

        public List<List<String>> connectedComponents() {
            List<List<String>> cc = new ArrayList<>();
            List<String> c = new ArrayList<>();
            for (Node n: nodes) {
                if (!n.visited) {
                    dfsUtil(n, c);
                    Collections.sort(c);
                    c.add(0, n.name);
                    cc.add(c);
                    c = new ArrayList<>();
                }
            }
            return cc;
        }

        public void dfsUtil(Node n, List<String> c) {
            n.visited = true;
            for (Node n1: n.adjList) {
                if (!n1.visited) {
                    dfsUtil(n1, c);
                }
            }
            c.add(n.val);
        }
    }

    private static class Node {
        public String val;
        public String name;
        public boolean visited;
        public List<Node> adjList = new ArrayList<>();
        public Node(String val, String name) {
            this.val = val;
            this.name = name;
        }

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Graph g = new Graph();
        for (List<String> accountList: accounts) {
            String name = "";
            String prev = "";
            for (String email: accountList) {
                if (name == "") {
                    name = email;
                    continue;
                }
                g.createNode(email, name);
                if (prev != "") {
                    g.addEdge(prev, email);
                }
                prev = email;
            }
        }

        List<List<String>> cc = g.connectedComponents();
        return cc;
    }

    public static void main(String[] args) {
        AccountsMerge m = new AccountsMerge();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(List.of("n1", "1", "2", "3"));
        accounts.add(List.of("n2", "4", "5", "6"));
        accounts.add(List.of("n2", "2", "7", "8"));
        List<List<String>> res = m.accountsMerge(accounts);
        for (List<String> a: res) {
            System.out.println(a);
        }

    }
}
