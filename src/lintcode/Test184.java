package lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-6-11.
 * @description
 */
public class Test184 {

    private Comparator<String> comparator = (o1, o2) -> (o2+o1).compareTo(o1+o2);

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        Queue<String> queue = new PriorityQueue<>(nums.length, comparator);
        for (int i: nums) {
            queue.offer(Integer.toString(i));
        }
        while (!queue.isEmpty()) {
            builder.append(queue.poll());
        }
        if (builder.charAt(0) == '0') {
            return "0";
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Test184 test184 = new Test184();
        int nums[] = {1, 20, 23, 4, 8};
        System.out.println(test184.largestNumber(nums));
    }
}
