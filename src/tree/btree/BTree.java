package tree.btree;

/**
 * @author Legend
 * @data by on 18-8-7.
 * @description BTree
 */
public class BTree<Key extends Comparable<Key>, Value> {
    // 每个节点最多含有M-1对键和链接
    private static final int M = 4;

    // BTree的根节点
    private Node root;
    // BTree的高度
    private int height;
    // BTree中键值对的数量
    private int n;

    // BTree的节点数据类型
    private static final class Node {
        // 孩子节点数目
        private int m;
        // 孩子节点集合
        private Entry[] children = new Entry[M];

        private Node(int k) {
            m = k;
        }
    }

    // 集合里面每个节点：拥有键、值和孩子集合的指针
    private static class Entry {
        private Comparable key;
        private final Object val;
        private Node next;
        public Entry(Comparable key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next= next;
        }
    }

    public BTree() {
        root = new Node(0);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public int height() {
        return height;
    }

    /**
     * 返回给定相关联键的值
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null!");
        return search(root, key, height);
    }

    private Value search(Node x, Key key, int ht) {
        Entry[] children = x.children;
        // 在当前键集的内部查找
        if (ht == 0) {
            for (int j=0;j<x.m;j++) {
                if (eq(key, children[j].key)) {
                    return (Value) children[j].val;
                }
            }
        } else {
            // 递归 当前键集节点的孩子集合里面进行查找
            for (int j=0;j<x.m;j++) {
                if (j+1 == x.m || less(key, children[j+1].key)) {
                    return search(children[j].next, key, ht-1);
                }
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("argument key to put() is null!");
        Node u = insert(root, key, value, height);
        n++;
        if (u == null) return;
        // 表明需要拆分
        Node t = new Node(2);
        t.children[0] = new Entry(root.children[0].key, null, root);
        t.children[1] = new Entry(u.children[0].key, null, u);
        root = t;
        height++;
    }

    private Node insert(Node h, Key key, Value val, int ht) {
        int j;
        Entry t = new Entry(key, val, null);
        if (ht == 0) {
            for (j=0;j<h.m;j++) {
                if (less(key, h.children[j].key)) break;
            }
        } else {
            for (j=0;j<h.m;j++) {
                if ((j+1==h.m) || less(key, h.children[j+1].key)) {
                    Node u = insert(h.children[j++].next, key, val, ht-1);
                    if (u == null) return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }
        for (int i=h.m;i>j;i--) {
            h.children[i] = h.children[i-1];
        }
        h.children[j] = t;
        h.m++;
        if (h.m < M) {
            return null;
        } else {
            // 如果键集里面的元素数量超过了M 则进行拆分
            return split(h);
        }
    }

    private Node split(Node h) {
        Node t = new Node(M/2);
        h.m = M/2;
        for (int j=0;j<M/2;j++) {
            t.children[j] = h.children[M/2+j];
        }
        return t;
    }

    public String toString() {
        return output(root, height,"")+"\n";
    }

    private String output(Node h, int ht, String indent) {
        StringBuilder s = new StringBuilder();
        Entry[] children = h.children;
        if (ht == 0) {
            for (int j=0;j<h.m;j++) {
                s.append(indent+children[j].key+" "+children[j].val+"\n");
            }
        } else {
            for (int j=0;j<h.m;j++) {
                if (j>0) s.append(indent+"("+children[j].key+")\n");
                s.append(output(children[j].next, ht-1, indent+"    "));
            }
        }
        return s.toString();
    }

    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean eq(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }

    public static void main(String[] args) {
        BTree<String, String> st = new BTree<>();
        st.put("www.cs.princeton.edu", "128.112.136.12");
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu",    "128.112.128.15");
        st.put("www.yale.edu",         "130.132.143.21");
        st.put("www.simpsons.com",     "209.052.165.60");
        st.put("www.apple.com",        "17.112.152.32");
        st.put("www.amazon.com",       "207.171.182.16");
        st.put("www.ebay.com",         "66.135.192.87");
        st.put("www.cnn.com",          "64.236.16.20");
        st.put("www.google.com",       "216.239.41.99");
        st.put("www.nytimes.com",      "199.239.136.200");
        st.put("www.microsoft.com",    "207.126.99.140");
        st.put("www.dell.com",         "143.166.224.230");
        st.put("www.slashdot.org",     "66.35.250.151");
        st.put("www.espn.com",         "199.181.135.201");
        st.put("www.weather.com",      "63.111.66.11");
        st.put("www.yahoo.com",        "216.109.118.65");


        System.out.println("cs.princeton.edu:  " + st.get("www.cs.princeton.edu"));
        System.out.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
        System.out.println("simpsons.com:      " + st.get("www.simpsons.com"));
        System.out.println("apple.com:         " + st.get("www.apple.com"));
        System.out.println("ebay.com:          " + st.get("www.ebay.com"));
        System.out.println("dell.com:          " + st.get("www.dell.com"));
        System.out.println();

        System.out.println("size:    " + st.size());
        System.out.println("height:  " + st.height());
        System.out.println(st);
        System.out.println();
    }
}
