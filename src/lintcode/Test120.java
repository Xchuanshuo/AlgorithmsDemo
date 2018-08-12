package lintcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Legend
 * @data by on 18-7-29.
 * @description 120 word-ladder
 */
public class Test120 {

    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.contains(end)) return 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int result = 1;
        while(!queue.isEmpty()) {
            int count = queue.size();
            result++;
            for (int i=0;i<count;i++) {
                char[] array = queue.poll().toCharArray();
                for (int j=0;j<array.length;j++) {
                    for (char c='a';c<='z';c++) {
                        char old = array[j];
                        array[j] = c;
                        String cur = String.valueOf(array);
                        if (end.equals(cur)) {
                            return result;
                        }
                        if (dict.contains(cur)) {
                            queue.offer(cur);
                            dict.remove(cur);
                        }
                        array[j] = old;
                    }
                }
            }
        }
        return 0;
    }
}
