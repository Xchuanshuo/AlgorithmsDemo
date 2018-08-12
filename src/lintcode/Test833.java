package lintcode;

import java.util.*;

/**
 * @author Legend
 * @data by on 18-7-9.
 * @description process-sequence
 */
public class Test833 {

    public List<Integer> numberOfProcesses(List<Interval> logs, List<Integer> queries) {
        // Write your code here
        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Interval i: logs) {
            temp.add(i.start);
            temp.add(i.end+1);
        }
        for (int i: queries) {
            temp.add(i);
        }
        Collections.sort(temp);
        int index = 1;
        for (int i: temp) {
            if (!map.containsKey(i)) {
                map.put(i, index++);
            }
        }
        int[] count = new int[index+1];
        for (Interval i: logs) {
            count[map.get(i.start)]++;
            count[map.get(i.end+1)]--;
        }
        for (int i=1;i<=index;i++) {
            count[i] += count[i-1];
        }
        for (int i: queries) {
            result.add(count[map.get(i)]);
        }
        return result;
    }

    public static void main(String[] args) {
        Test833 test = new Test833();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 1234));
        list.add(new Interval(2, 1234));
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        System.out.println(test.numberOfProcesses(list, list1));
    }
}
