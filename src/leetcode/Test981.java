package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Legend
 * @data by on 21-7-10.
 * @description https://leetcode-cn.com/problems/time-based-key-value-store
 */
public class Test981 {

    class TimeMap {

        Map<String, TreeSet<Node>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                TreeSet<Node> set = new TreeSet<>(Comparator.comparingInt(o -> o.time));
                map.put(key, set);
            }
            map.get(key).add(new Node(value, timestamp));
        }

        public String get(String key, int timestamp) {
            TreeSet<Node> set = map.get(key);
            if (set == null) return "";
            Node node = set.floor(new Node("", timestamp));
            if (node == null) return "";
            return node.value;
        }

        class Node {
            String value;
            int time;
            Node(String value, int time) {
                this.value = value;
                this.time = time;
            }
        }
    }

}
