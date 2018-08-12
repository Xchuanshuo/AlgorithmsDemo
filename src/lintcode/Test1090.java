package lintcode;

import java.util.TreeMap;

/**
 * @author Legend
 * @data by on 18-6-24.
 * @description Map Sum Pairs
 */
public class Test1090 {

    class Node {
        int value;
        TreeMap<Character, Node> next;
        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }
        public Node() {
            this(0);
        }
    }

    private Node root;

    public Test1090() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i=0;i<key.length();i++) {
            char c = key.charAt(i);
            if (cur.next.get(c)==null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {

        int res = node.value;
        for (char c: node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }

    public static void main(String[] args) {
        Test1090 test = new Test1090();
        test.insert("apple", 3);
        System.out.println(test.sum("ap"));
        test.insert("app", 2);
        System.out.println(test.sum("ap"));
    }
}
