package tree.btree;

import java.util.*;

/**
 * @author Legend
 * @data by on 19-6-13.
 * @description B + Tree
 */
public class BPlusTree<K extends Comparable<K>, V> {

    public static enum RangePolicy {
        EXCLUSIVE, INCLUSIVE;
    }

    /**
     * 在构造函数中未指定时使用的分裂因子
     */
    private static final int DEFAULT_BARANCHING_FACTOR = 128;

    private int branchingFactor;

    private Node root;

    public BPlusTree() {
        this(DEFAULT_BARANCHING_FACTOR);
    }

    public BPlusTree(int branchingFactor) {
        if (branchingFactor <= 2) {
            throw new IllegalArgumentException("Illegal branching factor: " + branchingFactor);
        }
        this.branchingFactor = branchingFactor;
        root = new LeafNode();
    }

    public V search(K key) {
        return root.getValue(key);
    }

    public List<V> searchRange(K key1, RangePolicy policy1, K key2,
                               RangePolicy policy2) {
        return root.getRange(key1, policy1, key2, policy2);
    }

    public void insert(K key, V value) {
        root.insertValue(key, value);
    }

    public void delete(K key) {
        root.deleteValue(key);
    }

    @Override
    public String toString() {
        Queue<List<Node>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(root));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Queue<List<Node>> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                List<Node> nodes = queue.remove();
                sb.append("{");
                Iterator<Node> iterator = nodes.iterator();
                while (iterator.hasNext()) {
                    Node node = iterator.next();
                    sb.append(node.toString());
                    if (iterator.hasNext()) {
                        sb.append(", ");
                    } else if (node instanceof BPlusTree.InternalNode) {
                        nextQueue.add(((InternalNode) node).childrens);
                    }
                }
                sb.append("}");
                if (!queue.isEmpty()) {
                    sb.append(", ");
                } else {
                    sb.append("\n");
                }
            }
            queue = nextQueue;
        }
        return sb.toString();
    }

    private class InternalNode extends Node {

        List<Node> childrens;

        InternalNode() {
            this.keys = new ArrayList<>();
            this.childrens = new ArrayList<>();
        }

        @Override
        V getValue(K key) {
            return getChild(key).getValue(key);
        }

        @Override
        void deleteValue(K key) {
            Node child = getChild(key);
            child.deleteValue(key);
            if (child.isUnderflow()) {
                Node childLeftSibling = getChildLeftSibling(key);
                Node childRightSibling = getChildRightSibling(key);
                Node left = childLeftSibling != null ? childLeftSibling : child;
                Node right = childLeftSibling!= null ? child : childRightSibling;
                left.merge(right);
                deleteChild(right.getFirstLeafKey());
                if (left.isOverflow()) {
                    Node sibling = left.split();
                    insertChild(sibling.getFirstLeafKey(), sibling);
                }
                if (root.keyNumber() == 0) {
                    root = left;
                }
            }
        }

        @Override
        void insertValue(K key, V value) {
            Node child = getChild(key);
            child.insertValue(key, value);
            if (child.isOverflow()) {
                Node sibling = child.split();
                insertChild(sibling.getFirstLeafKey(), sibling);
            }
            overFlow();
        }

        @Override
        K getFirstLeafKey() {
            return childrens.get(0).getFirstLeafKey();
        }

        @Override
        List<V> getRange(K key1, RangePolicy policy1, K key2, RangePolicy policy2) {
            return getChild(key1).getRange(key1, policy1, key2, policy2);
        }

        @Override
        void merge(Node sibling) {
            InternalNode node = (InternalNode) sibling;
            keys.add(node.getFirstLeafKey());
            keys.addAll(node.keys);
            childrens.addAll(node.childrens);
        }

        @Override
        Node split() {
            int from = keyNumber() / 2 + 1, to = keyNumber();
            InternalNode sibling = new InternalNode();
            sibling.keys.addAll(keys.subList(from, to));
            sibling.childrens.addAll(childrens.subList(from, to + 1));
            keys.subList(from - 1, to).clear();
            childrens.subList(from, to + 1).clear();
            return sibling;
        }

        @Override
        boolean isOverflow() {
            return childrens.size() > branchingFactor;
        }

        @Override
        boolean isUnderflow() {
            return childrens.size() < (branchingFactor + 1) / 2;
        }

        Node getChild(K key) {
            int location = Collections.binarySearch(keys, key);
            int childIndex = location >= 0 ? location + 1 : -location - 1;
            return childrens.get(childIndex);
        }

        void deleteChild(K key) {
            int location = Collections.binarySearch(keys, key);
            if (location >= 0) {
                keys.remove(location);
                childrens.remove(location + 1);
            }
        }

        void insertChild(K key, Node child) {
            int location = Collections.binarySearch(keys, key);
            int childIndex = location >= 0 ? location + 1: -location - 1;
            if (location >= 0) {
                childrens.set(childIndex, child);
            } else {
                keys.add(childIndex, key);
                childrens.add(childIndex + 1, child);
            }
        }

        Node getChildLeftSibling(K key) {
            int location = Collections.binarySearch(keys, key);
            int childIndex = location >= 0 ? location + 1 : -location - 1;
            if (location >= 0) {
                return childrens.get(childIndex - 1);
            }
            return null;
        }

        Node getChildRightSibling(K key) {
            int location = Collections.binarySearch(keys, key);
            int childIndex = location >= 0 ? location + 1 : -location - 1;
            if (childIndex < keyNumber()) {
                return childrens.get(childIndex + 1);
            }
            return null;
        }
    }

    private class LeafNode extends Node {
        List<V> values;
        LeafNode next;

        LeafNode() {
            keys = new ArrayList<>();
            values = new ArrayList<>();
        }

        @Override
        V getValue(K key) {
            int location = Collections.binarySearch(keys, key);
            return location >= 0 ? values.get(location) : null;
        }

        @Override
        void deleteValue(K key) {
            int location = Collections.binarySearch(keys, key);
            if (location >= 0) {
                keys.remove(location);
                values.remove(location);
            }
        }

        @Override
        void insertValue(K key, V value) {
            int location = Collections.binarySearch(keys, key);
            int valueIndex = location >= 0 ? location : -location - 1;
            if (location >= 0) {
                values.set(valueIndex, value);
            } else {
                keys.add(valueIndex, key);
                values.add(valueIndex, value);
            }
            overFlow();
        }

        @Override
        K getFirstLeafKey() {
            return keys.get(0);
        }

        @Override
        List<V> getRange(K key1, RangePolicy policy1, K key2, RangePolicy policy2) {
            List<V> result = new LinkedList<>();
            LeafNode node = this;
            while (node != null) {
                Iterator<K> kIt = node.keys.iterator();
                Iterator<V> vIt = node.values.iterator();
                while (kIt.hasNext()) {
                    K key = kIt.next();
                    V value = vIt.next();
                    int cmp1 = key.compareTo(key1);
                    int cmp2 = key.compareTo(key2);
                    if (((policy1 == RangePolicy.EXCLUSIVE && cmp1 > 0) || (policy1 == RangePolicy.INCLUSIVE && cmp1 >= 0))
                            && ((policy2 == RangePolicy.EXCLUSIVE && cmp2 < 0) || (policy2 == RangePolicy.INCLUSIVE && cmp2 <= 0))) {
                        result.add(value);
                    } else if ((policy2 == RangePolicy.EXCLUSIVE && cmp2 >= 0)
                            || (policy2 == RangePolicy.INCLUSIVE && cmp2 > 0)) {
                        return result;
                    }
                }
                node = node.next;
            }
            return result;
        }

        @Override
        void merge(Node sibling) {
            LeafNode node = (LeafNode) sibling;
            keys.addAll(node.keys);
            values.addAll(node.values);
            next = node.next;
        }

        @Override
        Node split() {
            LeafNode sibling = new LeafNode();
            int from = (keyNumber() + 1) / 2, to = keyNumber();
            sibling.keys.addAll(keys.subList(from, to));
            sibling.values.addAll(values.subList(from, to));

            keys.subList(from, to).clear();
            values.subList(from, to).clear();

            sibling.next = next;
            next = sibling;
            return sibling;
        }

        @Override
        boolean isOverflow() {
            return values.size() > branchingFactor - 1;
        }

        @Override
        boolean isUnderflow() {
            return values.size() < branchingFactor / 2;
        }
    }

    private abstract class Node {
        List<K> keys;

        int keyNumber() {
            return keys.size();
        }

        abstract V getValue(K key);

        abstract void deleteValue(K key);

        abstract void insertValue(K key, V value);

        abstract K getFirstLeafKey();

        abstract List<V> getRange(K key1, RangePolicy policy1,
                                  K key2, RangePolicy policy2);

        abstract void merge(Node sibling);

        abstract Node split();

        abstract boolean isOverflow();

        abstract boolean isUnderflow();

        void overFlow() {
            if (root.isOverflow()) {
                Node sibling = split();
                InternalNode newRoot = new InternalNode();
                newRoot.keys.add(sibling.getFirstLeafKey());
                newRoot.childrens.add(this);
                newRoot.childrens.add(sibling);
                root = newRoot;
            }
        }

        @Override
        public String toString() {
            return keys.toString();
        }
    }

    public static void main(String[] args) {
        BPlusTree<String, String> bPlusTree = new BPlusTree<>(8);
        bPlusTree.insert("www.cs.princeton.edu", "128.112.136.12");
        bPlusTree.insert("www.cs.princeton.edu", "128.112.136.11");
        bPlusTree.insert("www.princeton.edu",    "128.112.128.15");
        bPlusTree.insert("www.yale.edu",         "130.132.143.21");
        bPlusTree.insert("www.simpsons.com",     "209.052.165.60");
        bPlusTree.insert("www.apple.com",        "17.112.152.32");
        bPlusTree.insert("www.amazon.com",       "207.171.182.16");
        bPlusTree.insert("www.ebay.com",         "66.135.192.87");
        bPlusTree.insert("www.cnn.com",          "64.236.16.20");
        bPlusTree.insert("www.google.com",       "216.239.41.99");
        bPlusTree.insert("www.nytimes.com",      "199.239.136.200");
        bPlusTree.insert("www.microsoft.com",    "207.126.99.140");
        bPlusTree.insert("www.dell.com",         "143.166.224.230");
        bPlusTree.insert("www.slashdot.org",     "66.35.250.151");
        bPlusTree.insert("www.espn.com",         "199.181.135.201");
        bPlusTree.insert("www.weather.com",      "63.111.66.11");
        bPlusTree.insert("www.yahoo.com",        "216.109.118.65");

        System.out.println(bPlusTree);
        System.out.println(bPlusTree.search("www.weather.com"));
        System.out.println(bPlusTree.searchRange("www.princeton.edu", RangePolicy.INCLUSIVE, "www.yahoo.com", RangePolicy.INCLUSIVE));
    }
}
