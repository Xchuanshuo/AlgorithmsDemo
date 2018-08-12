package tree.trie;

import java.util.TreeMap;

/**
 * @author Legend
 * @data by on 18-6-24.
 * @description 前缀（字典）树
 */
public class Trie {

    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }
    public int getSize() {
        return size;
    }

    //向Trie中添加一个新的单词
    public void add(String word) {
        Node cur = root;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // 查询单词是否在Trie中
    public boolean contains(String word) {
        Node cur = root;
        if (findWord(word, cur)) return false;
        return cur.isWord;
    }

    //　查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        Node cur = root;
        if (findWord(prefix, cur)) return false;
        return true;
    }

    private boolean findWord(String prefix, Node cur) {
        for (int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return true;
            }
            cur = cur.next.get(c);
        }
        return false;
    }
}
