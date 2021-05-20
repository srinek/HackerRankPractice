package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-file-system/
 *
 * You are asked to design a file system that allows you to create new paths and associate them with different values.
 *
 * The format of a path is one or more concatenated strings of the form: / followed by one or more lowercase English letters.
 * For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string "" and "/" are not.
 *
 * Implement the FileSystem class:
 *
 * bool createPath(string path, int value) Creates a new path and associates a value to it if possible and returns true. Returns false if the path already exists or its parent path doesn't exist.
 * int get(string path) Returns the value associated with path or returns -1 if the path doesn't exist.
 *
 *
 * Example 1:
 *
 * Input:
 * ["FileSystem","createPath","get"]
 * [[],["/a",1],["/a"]]
 * Output:
 * [null,true,1]
 * Explanation:
 * FileSystem fileSystem = new FileSystem();
 *
 * fileSystem.createPath("/a", 1); // return true
 * fileSystem.get("/a"); // return 1
 * Example 2:
 *
 * Input:
 * ["FileSystem","createPath","createPath","get","createPath","get"]
 * [[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
 * Output:
 * [null,true,true,2,false,-1]
 * Explanation:
 * FileSystem fileSystem = new FileSystem();
 *
 * fileSystem.createPath("/leet", 1); // return true
 * fileSystem.createPath("/leet/code", 2); // return true
 * fileSystem.get("/leet/code"); // return 2
 * fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
 * fileSystem.get("/c"); // return -1 because this path doesn't exist.
 *
 *
 * Constraints:
 *
 * The number of calls to the two functions is less than or equal to 104 in total.
 * 2 <= path.length <= 100
 * 1 <= value <= 109
 */
public class DesignFileSystem {

    public static class Node {
        public String path;
        public Node(final String path) {
           this.path = path;
        }
        public int val;
        public Map<String, Node> children = new HashMap<>();
    }

    public Node root = new Node("");
    public Map<String, Integer> map = new HashMap<>();

    // /a/b/c
    public boolean createPath(String path, int value) {
        if (path == null || path == "") {
            return false;
        }
        if (!path.startsWith("/")) {
            return false;
        }
        final String[] parts = path.split("/");
        Node parent = root;
        for (int i=1; i<parts.length; i++) {
           String part = parts[i];
           if ("".equalsIgnoreCase(part)) {
               return false;
           }
           Node temp = parent.children.get(part);
           if (temp == null) {
               temp = new Node(path);
               temp.path = part;
               temp.val = value;
               if (i != parts.length-1) {
                   return false;
               }
               parent.children.put(part, temp);
               map.put(path, value);
               return true;
           }
            parent = temp;
        }
        return false;
    }

    public int get(String path) {
        Integer ret = map.get(path);
        if (ret == null) {
            return -1;
        }
        return ret;
    }

    public static void main(String[] args) {
        DesignFileSystem i = new DesignFileSystem();
        System.out.println(i.createPath("/a", 1));
        System.out.println(i.createPath("/a/b", 2));
        System.out.println(i.get("/a/b"));
        System.out.println(i.createPath("/a/b", 2));
        System.out.println(i.createPath("/a/b/c", 3));
        System.out.println(i.createPath("/a/b/c", 3));
        System.out.println(i.createPath("/a/d/b/c", 4));
        System.out.println(i.createPath("/a/b/c/d", 5));
        System.out.println(i.createPath("/x/b/c/d", 5));
        System.out.println(i.createPath("/", 5));
    }

}
