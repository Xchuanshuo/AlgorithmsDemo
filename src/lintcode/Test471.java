package lintcode;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @author Legend
 * @data by on 18-6-14.
 * @description
 */
public class Test471 {

    private Comparator<Helper> comparator = (o1, o2) -> {
        if (o1.count != o2.count) {
            return o1.count-o2.count;
        } else {
            return o2.word.compareTo(o1.word);
        }
    };

    public String[] topKFrequentWords(String[] words, int k) {
        if (k == 0) {
            return new String[]{};
        }
        Map<String, Integer> maps = new HashMap<>();
        for (int i=0;i < words.length;i++) {
            if (maps.containsKey(words[i])) {
                maps.put(words[i], maps.get(words[i])+1);
            } else {
                maps.put(words[i], 1);
            }
        }
        Queue<Helper> queue = new PriorityQueue<>(k, comparator);
        for (String str: maps.keySet()) {
            Helper helper = new Helper(str, maps.get(str));
            queue.offer(helper);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        String[] res = new String[k];
        while (!queue.isEmpty()) {
            res[--k] = queue.poll().word;
        }
        return res;
    }

    public static void main(String[] args) {
        Test471 test = new Test471();
        String[] words = {"yes", "lint", "code",
                "yes", "code", "baby",
                "you", "baby", "chrome",
                "safari", "lint", "code",
                "body", "lint", "code"};
        int k = 4;
        String[] strings = test.topKFrequentWords(words, k);
        for (int i=0;i < strings.length;i++) {
            System.out.print(strings[i]+" ");
        }
    }

    class Helper {
        String word;
        int count;
        public Helper(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
