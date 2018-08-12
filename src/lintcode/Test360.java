package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Legend
 * @data by on 18-7-6.
 * @description sliding-window-median
 */
public class Test360 {

    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return result;
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        result.add(maxHeap.peek());
        for (int i = k; i < nums.length; i++) {
            int removeNum = nums[i - k];
            int addNum = nums[i];
            if (addNum > maxHeap.peek()) {
                minHeap.offer(addNum);
            } else {
                maxHeap.offer(addNum);
            }
            if (removeNum > maxHeap.peek()) {
                minHeap.remove(removeNum);
            } else {
                maxHeap.remove(removeNum);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            result.add(maxHeap.peek());
        }
        return result;
    }
}
