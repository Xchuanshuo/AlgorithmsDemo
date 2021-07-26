package leetcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 21-5-20.
 * @description https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class Test692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        Queue<Word> pq = new PriorityQueue<>((o1,o2) -> {
            if (o1.cnt == o2.cnt) return o2.str.compareTo(o1.str);
            return o1.cnt - o2.cnt;
        });
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(new Word(e.getKey(), e.getValue()));
            } else if (e.getValue() > pq.remove().cnt || (e.getValue() == pq.remove().cnt
                            && e.getKey().compareTo(pq.remove().str) < 0)) {
                pq.poll(); pq.offer(new Word(e.getKey(), e.getValue()));
            }
        }
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.remove().str);
        }
        Collections.reverse(result);
        return result;
    }

    class Word {
        String str;
        int cnt;

        Word(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }
}
