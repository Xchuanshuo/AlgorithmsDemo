package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-7-5.
 * @description high-five
 */
public class Test613 {

    class Record {
      public int id, score;
      public Record(int id, int score){
          this.id = id;
          this.score = score;
      }
    }

    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> map = new HashMap<>();
        Queue<Record> queue = new PriorityQueue<>((o1, o2) -> o2.score-o1.score);
        List<Queue<Record>> list = new ArrayList<>();
        list.add(queue);
        Set<Integer> set = new HashSet<>();
        int max= Integer.MIN_VALUE;
        for (Record record: results) {
            max = Math.max(record.id, max);
        }
        for (int i=0;i<max;i++) {
            list.add(new PriorityQueue<>((o1, o2) -> o2.score-o1.score));
        }
        for (Record record: results) {
            list.get(record.id).offer(record);
        }
        double sum;
        for (int i=0;i<list.size();i++) {
            sum = 0;
            if (!list.get(i).isEmpty()) {
                Record record = null;
                for (int j=0;j<5;j++) {
                    record = list.get(i).poll();
                    sum += record.score;
                }
                map.put(record.id, sum/5);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3,2);
        System.out.println(list);
    }
}
