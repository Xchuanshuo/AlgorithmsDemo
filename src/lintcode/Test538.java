package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-6-29.
 * @description memcache
 */
public class Test538 {

    class Memcache {

        class Value {
            int val;
            int time;
            int ttl;
            public Value(int val, int time, int ttl) {
                this.val = val;
                this.time = time;
                this.ttl = ttl;
            }
        }
        private Map<Integer, Value> cache;

        public Memcache() {
            // do intialization if necessary
            cache = new HashMap<>();
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @return: An integer
         */
        public int get(int curtTime, int key) {
            // write your code here
            if (!cache.containsKey(key)) return Integer.MAX_VALUE;
            Value value = cache.get(key);
            if (value.ttl>0 && curtTime>value.time+value.ttl) {
                cache.remove(key);
                return Integer.MAX_VALUE;
            }
            return cache.get(key).val;
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @param value: An integer
         * @param ttl: An integer
         * @return: nothing
         */
        public void set(int curtTime, int key, int value, int ttl) {
            // write your code here
            cache.put(key, new Value(value, curtTime, ttl));
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @return: nothing
         */
        public void delete(int curtTime, int key) {
            // write your code here
            if (cache.containsKey(key)) cache.remove(key);
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @param delta: An integer
         * @return: An integer
         */
        public int incr(int curtTime, int key, int delta) {
            // write your code here
            if (!cache.containsKey(key)) return Integer.MAX_VALUE;
            cache.get(key).val += delta;
            cache.get(key).time = curtTime;
            return cache.get(key).val;
        }

        /*
         * @param curtTime: An integer
         * @param key: An integer
         * @param delta: An integer
         * @return: An integer
         */
        public int decr(int curtTime, int key, int delta) {
            // write your code here
            if (!cache.containsKey(key)) return Integer.MAX_VALUE;
            cache.get(key).val -= delta;
            cache.get(key).time = curtTime;
            return cache.get(key).val;
        }
    }
}
