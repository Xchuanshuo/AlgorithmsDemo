package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-6-29.
 * @description top-k-frequent-words-map-reduce
 */
public class Test549 {

    class OutputCollector<K, V> {
      public void collect(K key, V value) {

      }
      // Adds a key/value pair to the output buffer
    }
    class Document {
        public int id;
        public String content;
    }

    static class Pair {
        String key;
        int value;
        public Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class TopKFrequentWords {

        public static class Map {
            public void map( Document value,
                            OutputCollector<String, Integer> output) {
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, int value);
                int id = value.id;
                String content = value.content;
                String[] words = content.split(" ");
                for (String word: words) {
                    if (word.length()>0) {
                        output.collect(word, 1);
                    }
                }
            }
        }

        public static class Reduce {
            private Queue<Pair> queue;
            private int k;
            private Comparator<Pair> comparator = (o1, o2) -> o1.value!=o2.value?o1.value-o2.value:o2.key.compareTo(o1.key);

            public void setup(int k) {
                // initialize your data structure here
                this.k = k;
                queue = new PriorityQueue<>(k, comparator);
            }

            public void reduce(String key, Iterator<Integer> values) {
                // Write your code here
                int sum = 0;
                while (values.hasNext()) {
                    sum += values.next();
                }
                Pair pair = new Pair(key, sum);
                if (queue.size()<k) {
                    queue.offer(pair);
                } else {
                    if (comparator.compare(pair, queue.peek())>0) {
                        queue.poll();
                        queue.add(pair);
                    }
                }
            }

            public void cleanup(OutputCollector<String, Integer> output) {
                // Output the top k pairs <word, times> into output buffer.
                // Ps. output.collect(String key, Integer value);
                List<Pair> list = new ArrayList<>();
                while (!queue.isEmpty()) {
                    list.add(queue.poll());
                }
                // 最小堆倒序输出
                for (int i=k-1;i>=0;i--) {
                    output.collect(list.get(i).key, list.get(i).value);
                }
            }
        }
    }
}
