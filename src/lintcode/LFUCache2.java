package lintcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-6-30.
 * @description LintCode第24号题 LFU缓存
 */
public class LFUCache2 {

    private class Node {
        int value;
        int count;
        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Map<Integer, LinkedHashSet<Integer>> freqList;
    private int min;

    public LFUCache2(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqList = new HashMap<>();
        freqList.put(0, new LinkedHashSet<>());
        min = -1;
    }

    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            Node node = cache.get(key);
            node.value = value;
            node.count ++;
            freqList.get(node.count-1).remove(key);
            if (!freqList.containsKey(node.count)) {
                freqList.put(node.count, new LinkedHashSet<>());
            }
            freqList.get(node.count).add(key);
            if (min==node.count-1 && freqList.get(min).isEmpty()) {
                min = node.count;
            }
            return;
        }
        // 当容器缓存满时 这段时间使用频率最小的key
        if (cache.size() == capacity) {
            int evict = freqList.get(min).iterator().next();
            cache.remove(evict);
            freqList.get(min).remove(key);
        }
        min = 0;
        Node newNode = new Node(value, 0);
        cache.put(key, newNode);
        freqList.get(newNode.count).add(key);
    }

    public int get(int key) {
        // write your code here
        if (capacity == 0) return -1;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.count++;
            // 更新节点对应的频率表
            freqList.get(node.count-1).remove(key);
            if (!freqList.containsKey(node.count)) {
                freqList.put(node.count, new LinkedHashSet<>());
            }
            freqList.get(node.count).add(key);
            // 如果之前对应的频率表为空 就更新最小频率为当前的key
            if (min==node.count-1 && freqList.get(min).isEmpty()) {
                min = node.count;
            }
            return node.value;
        } else {
            return -1;
        }
    }
}
