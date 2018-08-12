package lintcode;

import java.util.TreeMap;

/**
 * @author Legend
 * @data by on 18-6-24.
 * @description
 */
public class Test442 {

    class Node {
        boolean isWord;
        TreeMap<Character, Node> next;
        public Node(boolean isWord) {
            this.isWord=isWord;
            next = new TreeMap<>();
        }
        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Test442() {
        // do intialization if necessary
        root = new Node();
        size = 0;
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        Node cur = root;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (cur.next.get(c)==null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        Node cur = root;
        if (isEmpty(cur, word)) return false;
        return true;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        Node cur = root;
        if (isEmpty(cur, prefix)) return false;
        return true;
    }

    private boolean isEmpty(Node cur, String word) {
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (cur.next.get(c)==null) {
                return true;
            }
            cur = cur.next.get(c);
        }
        return false;
    }

    public static void main(String[] args) {
        Test442 test = new Test442();
        test.insert("a");
        test.insert("b");
        test.insert("c");
        System.out.println(test.startsWith("a"));
        System.out.println(test.search("b"));
        test.insert("b");
        test.insert("b");
        test.insert("b");
        System.out.println(test.search("b"));
    }
}
