package tree.trie;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-6-24.
 * @description 前缀（字典）树
 */
public class Trie {

    private class Node {
        public boolean isWord;
        public String prefix;
        public Map<Character, Node> next;

        public Node(boolean isWord, String prefix) {
            this.isWord = isWord;
            this.prefix = prefix;
            this.next = new HashMap<>();
        }

        public Node(String prefix) {
            this(false, prefix);
        }

        public Node() {
            this(false, null);
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < word.length();i++) {
            char c = word.charAt(i);
            sb.append(c);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node(sb.toString()));
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // Trie树是否包含某个单词
    public boolean contains(String word) {
        Node cur = root;
        Node node = findPrefixNode(word, cur);
        return  node != null && node.isWord;
    }

    // 是否包含某个前缀
    public boolean containsPrefix(String prefix) {
        Node cur = root;
        return findPrefixNode(prefix, cur) != null;
    }

    // 查找前缀
    private Node findPrefixNode(String prefix, Node cur) {
        for (int i = 0;i < prefix.length();i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return null;
            }
            cur = cur.next.get(c);
        }
        return cur;
    }

    public void dfs() {
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        stack.push(cur);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.next.size() == 0 && node.isWord) {
                System.out.println(node.prefix);
            } else {
                for (Map.Entry<Character, Node> entry : node.next.entrySet()) {
                    stack.push(entry.getValue());
                }
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("apple");
        trie.add("application");
        trie.add("abort");
        trie.add("abandon");
        trie.add("bug");
        System.out.println(trie.contains("apple"));
        System.out.println(trie.contains("abort"));
        System.out.println(trie.contains("application"));
        System.out.println(trie.containsPrefix("ap"));
        System.out.println(trie.containsPrefix("aa"));
        System.out.println(trie.contains("word"));
        System.out.println(trie.contains("bug"));
        System.out.println(trie.containsPrefix("b"));
        System.out.println("-----------------------------------");
        trie.dfs();
    }
}
