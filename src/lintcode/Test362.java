package lintcode;

import java.time.format.TextStyle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author Legend
 * @data by on 18-6-24.
 * @description sliding-window-maximum
 */
public class Test362 {

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        if (nums.length == 0) {
            return result;
        }
        for (int i=0;i<k-1;i++) {
            inQueue(deque, nums[i]);
        }
        for (int i=k-1;i<nums.length;i++) {
            inQueue(deque, nums[i]);
            result.add(deque.peekFirst());
            outQueue(deque, nums[i-k+1]);
        }
        return result;
    }

    private void inQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast()<num) {
            deque.pollLast();
        }
        deque.offer(num);
    }

    private void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekLast() == num) {
            deque.pollFirst();
        }
    }

    public static void main(String[] args) {
        Test362 test = new Test362();
        int[] nums = {1, 2, 7, 7, 8};
        System.out.println(test.maxSlidingWindow(nums, 3));
    }
}
