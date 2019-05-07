package tree.huffman;

public class Node implements Comparable<Node> {
    final char ch;
    final int freq;
    public final Node left, right;

    Node(char ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(Node o) {
        return this.freq - o.freq;
    }
}