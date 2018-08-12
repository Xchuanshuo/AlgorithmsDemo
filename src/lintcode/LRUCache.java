package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-6-29.
 * @description 第134号题 LRUCache
 *  最近最少使用算法 这里把最近使用放到了底部 最少使用放到了顶部
 */
public class LRUCache {

    // 双向链表
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = next = null;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    // 虚拟头节点
    private Node head;
    // 虚拟尾节点
    private Node tail;

    public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            // 查询到该节点后后取出该节点 移到底部
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            cur.prev = null;
            cur.next = null;
            moveToTail(cur);
            return map.get(key).value;
        } else {
            return -1;
        }
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        // 如果缓存容器满了就从顶部移除 (最近使用的都移动到了底部)
        // 因为头部和尾部都是虚拟节点 所以真实的元素是从head.next开始
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToTail(newNode);
    }

    private void moveToTail(Node cur) {
        tail.prev.next = cur;
        cur.prev = tail.prev;
        cur.next = tail;
        tail.prev = cur;
    }
}