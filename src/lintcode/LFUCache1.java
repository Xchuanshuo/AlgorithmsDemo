package lintcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-6-30.
 * @description LintCode第24号题 LFU缓存
 */
public class LFUCache1 {

    private class Node {
        int value;
        // 使用的次数
        int useCount;
        // 上次访问的时间
        long lastGetTime;
        public Node(int value, int useCount) {
            this.value = value;
            this.useCount = useCount;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;

    public LFUCache1(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.cache = new HashMap<>(2*capacity, 0.75f);
    }

    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            cache.get(key).value = value;
            return;
        }
        if (capacity == 0) return;
        if (cache.size()>=capacity) {
            removeMin();
        }
        Node node = new Node(value, 0);
        node.lastGetTime = System.nanoTime();
        cache.put(key, node);
    }

    public int get(int key) {
        // write your code here
        if (!cache.containsKey(key)) {
            return -1;
        }
        cache.get(key).useCount++;
        cache.get(key).lastGetTime = System.nanoTime();
        return cache.get(key).value;
    }

    // 移除使用频率最小的元素
    private void removeMin() {
        int minCount = Integer.MAX_VALUE;
        long currTime = System.nanoTime();
        int minKey = 0;
        Iterator<Integer> iterator = cache.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            Node node = cache.get(key);
            if (node.useCount<minCount || (node.useCount==minCount && node.lastGetTime<currTime)) {
                minKey = key;
                minCount = node.useCount;
                currTime = node.lastGetTime;
            }
        }
        cache.remove(minKey);
    }

    public static void main(String[] args) {
        LFUCache1 lfuCache = new LFUCache1(3);
        lfuCache.set(1, 10);
        lfuCache.set(2, 20);
        lfuCache.set(3, 30);
        System.out.print("["+lfuCache.get(1)+", ");
        lfuCache.set(4, 40);
        System.out.print(lfuCache.get(4)+", ");
        System.out.print(lfuCache.get(3)+", ");
        System.out.print(lfuCache.get(2)+", ");
        System.out.print(lfuCache.get(1)+", ");
        lfuCache.set(5, 50);
        System.out.print(lfuCache.get(1)+", ");
        System.out.print(lfuCache.get(2)+", ");
        System.out.print(lfuCache.get(3)+", ");
        System.out.print(lfuCache.get(4)+", ");
        System.out.print(lfuCache.get(5)+"]");
        System.out.println();
        System.out.println(lfuCache.cache.size());
    }
}