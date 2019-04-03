package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 19-4-3.
 * @description web-logger
 */
public class Test505 {

    class WebLogger {

        private Queue<Integer> queue;
        public WebLogger() {
            this.queue = new LinkedList<>();
        }

        /*
         * @param timestamp: An integer
         * @return: nothing
         */
        public void hit(int timestamp) {
            queue.offer(timestamp);
        }

        /*
         * @param timestamp: An integer
         * @return: An integer
         */
        public int get_hit_count_in_last_5_minutes(int timestamp) {
            while (!queue.isEmpty() && queue.peek() + 300 <= timestamp) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
