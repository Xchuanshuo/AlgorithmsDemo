package lintcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Legend
 * @data by on 18-6-29.
 * @description  top-k-largest-numbers-ii
 */
public class Test545 {

    private Queue<Integer> queue;
    private int k;

    public Test545(int k) {
        // do intialization if necessary
        this.k = k;
        queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        queue.offer(num);
        while (queue.size()>k) {
            queue.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> list = new ArrayList<>(queue);
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    public static void main(String[] args) {
        Test545 test = new Test545(3);
        test.add(0);
        test.add(6);
        test.add(7);
        test.add(5);
        System.out.println(test.topk());
    }
}
