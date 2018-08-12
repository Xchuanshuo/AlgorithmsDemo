package lintcode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    class Node {
        boolean isWord;
        Map<Character, Node> next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }
        public Node() { this(false); }
    }
    
    private Node root = new Node();
    
    public void addWord(String word) {
        // write your code here
        Node cur = root;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        return search(root, word, 0);
    }
    
    public boolean search(Node node, String word, int index) {
        char c = word.charAt(index);
        if (c!='.') {
            if (!node.next.containsKey(c)) {
                return false;
            }
            return search(node.next.get(c), word, index+1);
        } else {
            for (char nextChar: node.next.keySet()) {
                if (search(node.next.get(nextChar), word, index+1)) {
                    return true;
                }
            }
            return false;
        }
    }
}