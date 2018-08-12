package map;


/**
 * @author Legend
 * @data by on 18-6-18.
 * @description 基于链表的Map
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key) {
            this(key, null, null);
        }

        public Node () {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString()+" : "+value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node preNode = dummyHead;
        while (preNode.next != null) {
            if (preNode.next.key.equals(key)) {
                break;
            }
            preNode = preNode.next;
        }
        if (preNode.next != null) {
            Node delNode = preNode.next;
            preNode.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null? null: node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key+" doesn't exist");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
