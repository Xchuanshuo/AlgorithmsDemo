package lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-6-29.
 * @description top-k-largest-numbers
 */
public class Test544 {

    public int[] topk(int[] nums, int k) {
        // write your code here
        if (null==nums || nums.length==0) {
            return new int[]{};
        }
        int[] result = new int[k];
        Queue<Integer> queue = new PriorityQueue<>(nums.length, Comparator.comparingInt(o -> o));
        queue.offer(nums[0]);
        for (int i=1;i<nums.length;i++) {
            if (nums[i]>queue.peek() || queue.size()<k)
                queue.add(nums[i]);
            if (queue.size()>k) {
                queue.poll();
            }
        }
        for (int i=k-1;i>=0;i--) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        Test544 test = new Test544();
        int[] nums = {3,10,1000,-99,4,100};
        int[] result = test.topk(nums, 3);
        for (int i: result) {
            System.out.print(i+" ");
        }
    }
}
