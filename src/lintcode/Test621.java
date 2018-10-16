package lintcode;

import tree.Set;
import tree.heap.PriorityQueue;
import tree.heap.Queue;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Legend
 * @data by on 18-10-17.
 * @description maximum-subarray-v
 */
public class Test621 {

    public int maxSubarray5(int[] nums, int k1, int k2) {
        // write your code here
        int n = nums.length;
        if (n < k1) return 0;
        int[] preSum = new int[n+1];
        int result = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i=1;i<=n;i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
            if (i < k1) continue;
            if (i > k2) {
                treeMap.remove(preSum[i-k2+1]);
            }
            if (treeMap.size() > 0) {
                result = Math.max(result, preSum[i]-treeMap.firstKey());
            }
            treeMap.put(preSum[i-k1+1], 1);
        }
        return result;
    }
}
