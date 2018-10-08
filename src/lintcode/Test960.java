package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Legend
 * @data by on 18-10-8.
 * @description first-unique-number-in-a-stream-ii
 */
public class Test960 {

    class DataStream {

        private int p = 0;
        private Map<Integer, Integer> map;
        private List<Integer> list;

        DataStream() {
            // do intialization if necessary
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
        }

        /**
         * @param num: next number in stream
         * @return: nothing
         */
        public void add(int num) {
            // write your code here
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
                return;
            }
            list.add(num);
            map.put(num, 1);
        }

        /**
         * @return: the first unique number in stream
         */
        public int firstUnique() {
            // write your code here
            while (map.get(list.get(p)) > 1) p++;
            return list.get(p);
        }
    }
}
